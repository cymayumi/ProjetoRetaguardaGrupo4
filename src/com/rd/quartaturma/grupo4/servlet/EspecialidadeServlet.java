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

import com.rd.quartaturma.grupo4.entity.EspecialidadeEntity;
import com.rd.quartaturma.grupo4.vo.Especialidade;



@WebServlet("/EspecialidadeServlet")
public class EspecialidadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EspecialidadeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if (acao == null) {
			this.listarEspecialidade(request, response);
		} else if (acao.equals("editar")) {
			this.editarEspecialidade(request, response);
		} else if (acao.equals("remover")) {
			this.excluirEspecialidade(request, response);
		} else if (acao.equals("novo")) {
			RequestDispatcher rd = request.getRequestDispatcher("/pages/nova-especialidade.jsp");
			rd.forward(request, response);
		}
	}

	private void listarEspecialidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;

		try {
			EntityManager em = CrudEntityManager.getEntityManager();
			Query query = em.createNamedQuery("Especialidade.findAll", EspecialidadeEntity.class);

			List<EspecialidadeEntity> especialidadeEntity = query.getResultList();

			List<Especialidade> especialidades = new ArrayList<>();

			for (EspecialidadeEntity entity : especialidadeEntity) {
				Especialidade esp = new Especialidade();
				
				esp.setIdTipoEspecialidade(BigInteger.valueOf(entity.getIdTipoEspecialidade().intValue()));
				esp.setDsTipoEspecialidade(entity.getDsTipoEspecialidade());

				especialidades.add(esp);
			}

			request.setAttribute("especialidades", especialidades);

			rd = request.getRequestDispatcher("/pages/lista-especialidades.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			request.setAttribute("erro", "Erro ao consultar lista de exames!");
			rd = request.getRequestDispatcher("/pages/erro-validacao.jsp");
			e.printStackTrace();
		}
	}

	private void editarEspecialidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;

		try {
			String id = request.getParameter("id");
			EntityManager em = CrudEntityManager.getEntityManager();
			EspecialidadeEntity especialidadeEntity = em.find(EspecialidadeEntity.class, new BigInteger(id));

			Especialidade esp = new Especialidade();

			esp.setIdTipoEspecialidade(especialidadeEntity.getIdTipoEspecialidade());
			esp.setDsTipoEspecialidade(especialidadeEntity.getDsTipoEspecialidade());

			request.setAttribute("especialidade", esp);

			rd = request.getRequestDispatcher("/pages/form-especialidade.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			request.setAttribute("erro", "Erro ao editar exames!");
			rd = request.getRequestDispatcher("/pages/erro-validacao.jsp");

			rd.forward(request, response);
			e.printStackTrace();
			e.printStackTrace();
		}

	}

	private void excluirEspecialidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		EntityManager em = CrudEntityManager.getEntityManager();
		EspecialidadeEntity especialidadeEntity = em.find(EspecialidadeEntity.class, new BigInteger(id));
		em.getTransaction().begin();
		em.remove(especialidadeEntity);
		em.getTransaction().commit();

		listarEspecialidade(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if (acao.equals("editar"))
			this.atualizarEspecialidade(request);
		else if (acao.equals("novo"))
			this.inserirEspecialidade(request);

		listarEspecialidade(request, response);
	}

	private void atualizarEspecialidade(HttpServletRequest request) {
		
		BigInteger id = BigInteger.valueOf(Integer.valueOf(request.getParameter("id")).intValue());
		String especialidadeNome = request.getParameter("nomeEspecialidade");


		EntityManager em = CrudEntityManager.getEntityManager();
		EspecialidadeEntity especialidadeEntity = em.find(EspecialidadeEntity.class, id);
		
		especialidadeEntity.setDsTipoEspecialidade(especialidadeNome);

		em.getTransaction().begin();
		em.merge(especialidadeEntity);
		em.getTransaction().commit();
	}

	private void inserirEspecialidade(HttpServletRequest request) {

		String especialidadeNome = request.getParameter("nomeEspecialidade");

		EspecialidadeEntity especialidadeEntity = new EspecialidadeEntity();
		especialidadeEntity.setDsTipoEspecialidade(especialidadeNome);
		
		EntityManager em = CrudEntityManager.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(especialidadeEntity);
		em.getTransaction().commit();
	}

}
