package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Solicitacao;
import model.Usuario;
import service.SolicitacaoService;
import service.UsuarioService;

/**
 * Servlet implementation class CriarSolicitacao
 */
@WebServlet("/CriarSolicitacao.do")
public class CriarSolicitacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CriarSolicitacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Usuario usuarioa = new Usuario();
		Usuario usuariob = new Usuario();
		UsuarioService us = new UsuarioService();
		usuarioa = us.carregar(request.getParameter("email"));
		usuariob =us.carregar(request.getParameter("emailaprende"));
		HttpSession sessaoUsuario = request.getSession();
        sessaoUsuario.setAttribute("usuario",usuariob);
		SolicitacaoService ss = new SolicitacaoService();
		Solicitacao solicitacao = new Solicitacao();
		solicitacao.setAssunto("Pedido de Ajuda");
		solicitacao.setStatus("Pendente");
		
		
		String data = request.getParameter("data");
		String dia = data.substring(8,data.length()); 
		System.out.println("Data que chegou");
		for(int i=0; i <data.length()-1;i++) {
			System.out.println("Caracter: "+data.charAt(i) + "Na Posição: "+ i );
		}
		String mes = data.substring(5,7);
		String ano = data.substring(0,4);
				
		solicitacao.setData(dia +"/"+mes+"/"+ano);
		solicitacao.setHoraInicio(request.getParameter("horaInicio"));
		solicitacao.setHoraFinal(request.getParameter("horaFinal"));
		solicitacao.setLocal(request.getParameter("local"));
		solicitacao.setCodAlunoAprende(usuariob.getId());
		solicitacao.setCodAlunoEnsina(usuarioa.getId());
		solicitacao.setEmailAprende(usuariob.getEmail());
		solicitacao.setEmailEnsina(usuarioa.getEmail());
		solicitacao.setId(0);
		solicitacao.setCodMateria(usuariob.getCodMateriaBoa());
		solicitacao.getId();
		ss.criar(solicitacao);
		response.sendRedirect("solicitacoes.jsp");
		

	}

}
