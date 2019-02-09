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
public class ContatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Contato> contatos;
	private Contato contato;
	private ContatoService service;

	public ContatoController() {
		this.service = new ContatoService();
		this.contato = new Contato();
		this.contatos = new ArrayList<Contato>();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		try {
			this.contatos = this.service.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("contatos", this.contatos);
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String sobrenome = request.getParameter("sobrenome");
		String telefone = request.getParameter("telefone");

		this.contato.setNome(nome);
		this.contato.setEmail(email);
		this.contato.setSobrenome(sobrenome);
		this.contato.setTelefone(telefone);
		
		System.out.println(nome);
		System.out.println(email);
		
		try {
			this.service.save(this.contato);
			this.contato = new Contato();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
