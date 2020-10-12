package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

/**
 * Servlet implementation class CriarNoticia
 */
@WebServlet("/CriarNoticia.do")
public class CriarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriarNoticia() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String pTexto = request.getParameter("conteudo");
		String pTitulo = request.getParameter("titulo");
		String pDescricao = request.getParameter("descricao");

		Noticia noticia = new Noticia();
		noticia.setTitulo(pTitulo);
		noticia.setDescricao(pDescricao);
		noticia.setTexto(pTexto);

		NoticiaService cs = new NoticiaService();
		cs.criar(noticia);
		noticia = cs.carregar(noticia.getId());
		response.sendRedirect("home.aluno.jsp");
	}
}
