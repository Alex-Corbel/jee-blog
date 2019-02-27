package fr.epsi.jeeProject.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.jeeProject.beans.Utilisateur;
import fr.epsi.jeeProject.dao.IBlogDao;
import fr.epsi.jeeProject.dao.IUtilisateurDao;
import fr.epsi.jeeProject.dao.mockImpl.MockBlogDao;
import fr.epsi.jeeProject.dao.mockImpl.MockUtilisateurDao;

/**
 * Servlet implementation class SearchBlogServlet
 */
@WebServlet("/searchBlog")
public class SearchBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchBlogServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String email = request.getParameter("email");
		if(email != null && email.length() > 2) {
			final IUtilisateurDao utilisateurDao = new MockUtilisateurDao();
			final Utilisateur utilisateur = utilisateurDao.getUtilisateur(email);
			if(utilisateur != null) {
				final IBlogDao blogDao = new MockBlogDao();
				request.setAttribute("utilisateur", utilisateur);
				request.setAttribute("blogs", blogDao.getBlogs(utilisateur));
			}
		}
		final RequestDispatcher requestDispatcher = request.getRequestDispatcher("/searchBlog.jsp");
		requestDispatcher.forward(request, response);
	}

}
