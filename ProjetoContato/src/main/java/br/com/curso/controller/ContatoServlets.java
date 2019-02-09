package br.com.curso.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.model.Contato;
import br.com.curso.service.ContatoService;

public class ContatoServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Contato contato;
	private ContatoService contatoService;

	public ContatoServlets() {
		this.contato = new Contato();
		this.contatoService = new ContatoService();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");

		this.contato.setNome(nome);
		this.contato.setEmail(email);
		
		try {
			
			this.contatoService.save(this.contato);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
