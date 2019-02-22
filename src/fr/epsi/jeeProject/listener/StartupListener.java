package fr.epsi.jeeProject.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epsi.jeeProject.beans.Blog;
import fr.epsi.jeeProject.beans.Utilisateur;
import fr.epsi.jeeProject.dao.IBlogDao;
import fr.epsi.jeeProject.dao.mockImpl.MockBlogDao;

/**
 * Application Lifecycle Listener implementation class StartupListener
 *
 */
@WebListener
public class StartupListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */

	private static final Logger Logger = LogManager.getLogger(StartupListener.class);
	public StartupListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce)  {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce)  {
		Logger.info("Démarrage application");
		final IBlogDao blogDao = new MockBlogDao();
		final Utilisateur utilisateur = new Utilisateur();
		utilisateur.setEmail("contact@aquasys.fr");
		final List<Blog> listOfBlogs = blogDao.getBlogs(utilisateur);
		Logger.info("nb blogs = " + listOfBlogs.size());
	}

}
