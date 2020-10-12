package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Solicitacao;
import service.SolicitacaoService;

/**
 * Servlet implementation class AtualizarSolicitacao
 */
@WebServlet("/AtualizarSolicitacao.do")
public class AtualizarSolicitacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtualizarSolicitacao() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		SolicitacaoService ss = new SolicitacaoService();
		Solicitacao solicitacao = new Solicitacao();
		solicitacao = ss.carregar(Integer.parseInt(request.getParameter("id")));
		solicitacao.setStatus(request.getParameter("status"));
		ss.atualizar(solicitacao);
		request.setAttribute("erro", " <script>alert(\"Atualização feita com sucesso!\");</script>");
	     RequestDispatcher view = 
	    	        request.getRequestDispatcher("solicitacoes.jsp");
	    	        view.forward(request, response);
	} catch (NullPointerException e) {
	
		request.setAttribute("erro", " <script>alert(\"Tente novamente não foi possível atualizar a solicitação!\");</script>");
	     RequestDispatcher view = 
	    	        request.getRequestDispatcher("solicitacoes.jsp");
	    	        view.forward(request, response);
	}
		
	}

}
