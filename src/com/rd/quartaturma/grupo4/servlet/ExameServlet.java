package com.rd.quartaturma.grupo4.servlet;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rd.quartaturma.grupo4.entity.ExameEntity;
import com.rd.quartaturma.grupo4.vo.Exame;

@WebServlet("/ExameServlet")
public class ExameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExameServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if (acao == null) {
			this.listarExames(request, response);
		} else if (acao.equals("editar")) {
			this.editarExame(request, response);
		} else if (acao.equals("remover")) {
			this.excluirExame(request, response);
		} else if (acao.equals("novo")) {
			RequestDispatcher rd = request.getRequestDispatcher("/pages/novo-exame.jsp");
			rd.forward(request, response);
		}
	}

	private void listarExames(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;

		try {
			EntityManager em = CrudEntityManager.getEntityManager();
			Query query = em.createNamedQuery("Exame.findAll", ExameEntity.class);

			List<ExameEntity> exameEntity = query.getResultList();

			List<Exame> exames = new ArrayList<>();

			for (ExameEntity entity : exameEntity) {
				Exame exame = new Exame();
				
				exame.setIdTipoExame(BigInteger.valueOf(entity.getIdTipoExame().intValue()));
				exame.setDsTipoExame(entity.getDsTipoExame());

				exames.add(exame);
			}

			request.setAttribute("exames", exames);

			rd = request.getRequestDispatcher("/pages/lista-exames.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			request.setAttribute("erro", "Erro ao consultar lista de exames!");
			rd = request.getRequestDispatcher("/pages/erro-validacao.jsp");
			e.printStackTrace();
		}
	}

	private void editarExame(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;

		try {
			String id = request.getParameter("id");
			EntityManager em = CrudEntityManager.getEntityManager();
			ExameEntity exameEntity = em.find(ExameEntity.class, new BigInteger(id));

			Exame exame = new Exame();

			exame.setIdTipoExame(exameEntity.getIdTipoExame());
			exame.setDsTipoExame(exameEntity.getDsTipoExame());

			request.setAttribute("exame", exame);

			rd = request.getRequestDispatcher("/pages/form-exame.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			request.setAttribute("erro", "Erro ao editar exames!");
			rd = request.getRequestDispatcher("/pages/erro-validacao.jsp");

			rd.forward(request, response);
			e.printStackTrace();
			e.printStackTrace();
		}

	}

	private void excluirExame(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		EntityManager em = CrudEntityManager.getEntityManager();
		ExameEntity exameEntity = em.find(ExameEntity.class, new BigInteger(id));
		em.getTransaction().begin();
		em.remove(exameEntity);
		em.getTransaction().commit();

		listarExames(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if (acao.equals("editar"))
			this.atualizarExame(request);
		else if (acao.equals("novo"))
			this.inserirExame(request);

		listarExames(request, response);
	}

	private void atualizarExame(HttpServletRequest request) {
		
		BigInteger id = BigInteger.valueOf(Integer.valueOf(request.getParameter("id")).intValue());
		String exameNome = request.getParameter("nomeExame");


		EntityManager em = CrudEntityManager.getEntityManager();
		ExameEntity exameEntity = em.find(ExameEntity.class, id);
		
		exameEntity.setDsTipoExame(exameNome);

		em.getTransaction().begin();
		em.merge(exameEntity);
		em.getTransaction().commit();
	}

	private void inserirExame(HttpServletRequest request) {

		String exameNome = request.getParameter("nomeExame");

		ExameEntity exameEntity = new ExameEntity();
		exameEntity.setDsTipoExame(exameNome);
		
		EntityManager em = CrudEntityManager.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(exameEntity);
		em.getTransaction().commit();
	}

}
