package vadya_zakusylo.library.servlets;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HttpServletLibrary extends HttpServlet {

	/**
	 * Vadya Zakusylo
	 */
	private static final long serialVersionUID = 1L;

	public static final String CONNECTION = "connection";
	public static final String BOOKLIST = "booksList";
	public static final String DOWNLOADED_BOOKLIST = "downloadedBooksList";
	public static final String MESSAGE = "message";
	public static final String ERROR_MESSAGE = "errorMessage";

	public static final String LIBRARY_PAGE = "library.jsp";
	public static final String SELECT_BOOKS_PAGE = "select_books.jsp";
	public static final String INSERT_BOOKS_PAGE = "insert_books.jsp";
	public static final String ERROR_PAGE = "error.jsp";

	Connection getConnection(HttpServletRequest request) {
		Connection connection = (Connection) request.getSession().getAttribute(CONNECTION);
		if (connection == null) {
			try {
				ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Datasource.xml");
				DataSource dataSource = (DataSource) context.getBean("dataSource");
				connection = dataSource.getConnection();
				request.getSession().setAttribute(CONNECTION, connection);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return connection;
	}
}
