package br.com.curso.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.model.Contato;
import br.com.curso.service.ContatoService;

/**
 * Servlet implementation class ContatoController
 */
public class ListarContatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Contato> contatos;
	private ContatoService service;

	public ListarContatoController() {
		this.service = new ContatoService();
		this.contatos = new ArrayList<Contato>();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action != null) {
			
			try {
				this.service.removeById(Long.parseLong(request.getParameter("id")));
				this.contatos = this.service.list();
				RequestDispatcher rd = request.getRequestDispatcher("/pages/lista.jsp");
				request.setAttribute("contatos", this.contatos);
				request.setAttribute("exclusao", "Contato removeido com sucesso");
				rd.forward(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/pages/lista.jsp");
		try {
			this.contatos = this.service.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("contatos", this.contatos);
		rd.forward(request, response);
		
	}

	
}
