package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.apache.catalina.Session;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.Usuario;
import service.UsuarioService;

@WebServlet("/upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Upload() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ID para upload:  " + request.getParameter("id"));

		/* Obtem o caminho relatorio da pasta img */
		String path = request.getServletContext().getRealPath("img") + File.separator;

		File files = new File(path);
		response.setContentType("image/jpeg");

		/* Mostra o arquivo que está na pasta img onde foi realizado o upload */
		for (String file : files.list()) {
			File f = new File(path + file);
			BufferedImage bi = ImageIO.read(f);
			OutputStream out = response.getOutputStream();
			ImageIO.write(bi, "jpg", out);
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* Identifica se o formulario é do tipo multipart/form-data */
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				/* Faz o parse do request */
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

				/* Escreve a o arquivo na pasta img */

				UsuarioService us = new UsuarioService();
				int s = (Integer) request.getSession().getAttribute("idLogado");
				Usuario usuarioLogado = us.carregar(s);
				usuarioLogado.setFoto(s + ".png");
				us.atualizar(usuarioLogado);
				request.getSession().removeAttribute("usuario");
				request.getSession().setAttribute("usuario", usuarioLogado);
				System.out.println("ID para upload:  " + (Integer) request.getSession().getAttribute("idLogado"));
				System.out.println("ID para upload:  " + usuarioLogado.toString());

				File file = new File(request.getServletContext().getRealPath("img") + File.separator
						+ usuarioLogado.getId() + ".png");
				System.out.println("Lugar onde a imagem foi gravada: "+request.getServletContext().getRealPath("img") + File.separator
						+ usuarioLogado.getId() + ".png");

				file.delete();

				for (FileItem item : multiparts) {
					if (!item.isFormField()) {

						item.write(new File(request.getServletContext().getRealPath("img") + File.separator
								+ usuarioLogado.getId() + ".png"));

					}
				}

				//request.setAttribute("message", "Arquivo carregado com sucesso");
			} catch (Exception ex) {
				//request.setAttribute("message", "Upload de arquivo falhou devido a " + ex);
			}

		} else {
			//request.setAttribute("message", "Desculpe este Servlet lida apenas com pedido de upload de arquivos");
		}
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setHeader("Expires", "0"); // Proxies.
		request.setAttribute("foto", " <script>alert(\"Atualização feita com sucesso!\");</script>");
	     RequestDispatcher view = 
	    	        request.getRequestDispatcher("foto-usuario.jsp");
	    	        view.forward(request, response);
	
	
	}

}