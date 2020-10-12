package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// int id = Integer.parseInt((request.getParameter("idUsuario")));
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		UsuarioService us = new UsuarioService();
		Usuario usuario = new Usuario();
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
		System.out.println(usuario.toString());

		Usuario usuarioa = us.carregar(usuario.getEmail());
		System.out.println(usuarioa.toString());

		PrintWriter out = response.getWriter();

		out.println("<html>" + "<head>" + "<meta charset='UTF-8'>" + "<title>Login</title>"

				+ "</head>" + "<body>");

		try {
			if (usuarioa.getEmail().equals(usuario.getEmail()) && usuarioa.getSenha().equals(usuario.getSenha())) {

				HttpSession sessaoUsuario = request.getSession();
				sessaoUsuario.setAttribute("usuario", usuarioa);
			
				// sessaoUsuario.
				sessaoUsuario.setAttribute("idLogado", usuarioa.getId());
				// sessaoUsuario.setMaxInactiveInterval(1800);
				response.sendRedirect("home.aluno.jsp");
			} else {
				request.setAttribute("class", "is-invalid");
				request.setAttribute("erro", "erro");
			     RequestDispatcher view = 
			    	        request.getRequestDispatcher("index.jsp");
			    	        view.forward(request, response);


			}

		} catch (NullPointerException e) {
			out.print("<script>");
			out.print("alert('uma mensagem escrita pelo servidor');");
			out.print("</script>");
			request.setAttribute("erro", " <script>alert(\"Senha ou e-mail inválidos!\");</script>");
		     RequestDispatcher view = 
		    	        request.getRequestDispatcher("index.jsp");
		    	        view.forward(request, response);
		}

	}

}
