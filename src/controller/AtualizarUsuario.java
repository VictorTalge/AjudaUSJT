package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Materia;
import service.MateriaService;
import model.Usuario;
import service.UsuarioService;

/**
 * Servlet implementation class AtualizarUsuario
 */
@WebServlet("/AtualizarUsuario.do")
public class AtualizarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AtualizarUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			MateriaService ms = new MateriaService();
			Materia materia = new Materia();
			UsuarioService us = new UsuarioService();
			Usuario usuario = new Usuario();
			usuario.setNome(request.getParameter("nome"));
			usuario.setEmail(request.getParameter("email"));
			usuario.setSenha(request.getParameter("senha"));
			usuario.setCidade(request.getParameter("cidade"));
			usuario.setEstado(request.getParameter("estado"));
			usuario.setRa(request.getParameter("ra"));
			usuario.setCodMateriaBoa(ms.carregar(request.getParameter("materia").toLowerCase()).getId());
			int s = (Integer) request.getSession().getAttribute("idLogado");
			Usuario aux = us.carregar(s);
			usuario.setId(s);
			usuario.getId();
			usuario.setFoto(aux.getFoto());
			usuario.setAdm(aux.getAdm());
			us.atualizar(usuario);
			request.setAttribute("message", " <script>alert(\"Atualização feita com sucesso!\");</script>");
			RequestDispatcher view = request.getRequestDispatcher("perfil.jsp");
			view.forward(request, response);
		} catch (Exception e) {
			request.setAttribute("message",
					" <script>alert(\"Ouve um erro não foi possível realizar a atualização!\");</script>");
			RequestDispatcher view = request.getRequestDispatcher("perfil.jsp");
			view.forward(request, response);

			e.printStackTrace();
		}
	}

}
