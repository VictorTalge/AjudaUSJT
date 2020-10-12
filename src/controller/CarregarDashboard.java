package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Solicitacao;
import service.SolicitacaoService;

/**
 * Servlet implementation class CriarUsuario
 */
@WebServlet("/CarregarDashboard.do")
public class CarregarDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CarregarDashboard() {
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	SolicitacaoService ss = new SolicitacaoService();
		Solicitacao solicitacao = new Solicitacao();
		//solicitacao.setData(request.getParameter("data").toLowerCase());
		
		
		String chave = request.getParameter("data[search]");
		String acao = request.getParameter("acao");
		request.getParameter("id");
		ArrayList<Solicitacao> array;
		HttpSession session = request.getSession();
		System.out.println("ID recebido pela servelet Dashboard: " + request.getParameter("id"));
		
			if (request.getParameter("id") != null) {
				array = ss.carregarData(Integer.parseInt(request.getParameter("id")));
			} else {
			array = ss.carregarData();
			}
		  	
		System.out.println("Tamanho solicitacao"+array.size());
		
    	int janeiro = 0;
    	int fevereiro = 0;
    	int marco = 0;
    	int abril = 0;
    	int maio = 0;
    	int junho = 0;
    	int julho = 0;
    	int agosto = 0;
    	int setembro = 0;
    	int outubro = 0;
    	int novembro = 0;
    	int dezembro = 0;
    		
		
		for(int i=0; i<array.size();i++) {
		solicitacao = array.get(i);
			if(solicitacao.getData().substring(3,5).equals("01")){
			janeiro ++;
		  }
		else if(solicitacao.getData().substring(3,5).equals("02")){
		      fevereiro ++;
		  }
		else if(solicitacao.getData().substring(3,5).equals("03")){
		      marco ++;
		  }
		else if(solicitacao.getData().substring(3,5).equals("04")){
		      abril ++;
		  }
		else if(solicitacao.getData().substring(3,5).equals("05")){
		      maio ++;
		  }
		else if(solicitacao.getData().substring(3,5).equals("06")){
		      junho ++;
		  }
		else if(solicitacao.getData().substring(3,5).equals("07")){
		      julho ++;
		  }
		else if(solicitacao.getData().substring(3,5).equals("08")){
		      agosto ++;
		  }
		else if(solicitacao.getData().substring(3,5).equals("09")){
		      setembro ++;
		  }
		else if(solicitacao.getData().substring(3,5).equals("10")){
		      outubro ++;
		  }
		else if(solicitacao.getData().substring(3,5).equals("11")){
		      novembro ++;
		  }
		else if(solicitacao.getData().substring(3,5).equals("12")){
		      dezembro ++;
		  }
			System.out.println(solicitacao.getData().substring(3,5) + "  Solicitacao dentro do LOOP: " + solicitacao.toString());
		}
		
		ArrayList<Integer> mes = new ArrayList<> ();
		mes.add(janeiro);
		mes.add(fevereiro);
		mes.add(marco);
		mes.add(abril);
		mes.add(maio);
		mes.add(junho);
		mes.add(julho);
		mes.add(agosto);
		mes.add(setembro);
		mes.add(outubro);
		mes.add(novembro);
		mes.add(dezembro);
		
		request.setAttribute("array", mes);
        RequestDispatcher view = request.getRequestDispatcher("dashboardteste.jsp");
		view.forward(request, response);

    }

}
