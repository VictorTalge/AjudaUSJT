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
 * Servlet implementation class ApagarNoticia
 */
@WebServlet("/ApagarNoticia.do")
public class ApagarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApagarNoticia() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		NoticiaService cs = new NoticiaService();
		cs.excluir(Integer.parseInt(request.getParameter("id")));
		response.sendRedirect("home.aluno.jsp");
		//getRequestDispatcher();
	}
}
