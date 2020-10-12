package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Materia;
import model.Usuario;
import service.MateriaService;
import service.UsuarioService;

/**
 * Servlet implementation class CriarUsuario
 */
@WebServlet("/CriarUsuario.do")
public class CriarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CriarUsuario() {
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	UsuarioService us = new UsuarioService();
		Usuario usuario = new Usuario();
		usuario.setNome(request.getParameter("nome").toLowerCase());
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha").toLowerCase());
		usuario.setCidade(request.getParameter("cidade").toLowerCase());
		usuario.setEstado(request.getParameter("estado").toLowerCase());
		usuario.setRa(request.getParameter("ra"));
		MateriaService ms = new MateriaService();
		Materia materia = ms.carregar(request.getParameter("materia"));
		usuario.setCodMateriaBoa(materia.getId());
		usuario.getId();
		us.criar(usuario);
		HttpSession sessaoUsuario = request.getSession();
        sessaoUsuario.setAttribute("usuario",usuario);
        response.sendRedirect("index.jsp");

    }

}
