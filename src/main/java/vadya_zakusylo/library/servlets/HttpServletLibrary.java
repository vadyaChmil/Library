package vadya_zakusylo.library.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class HttpServletLibrary extends HttpServlet {

	/**
	 * Vadya Zakusylo
	 */
	private static final long serialVersionUID = 1L;

	public static final String USER_NAME = "adminc7Q7z8S";
	public static final String USER_PASSWORD = "YafujDIEJZ2i";

	public static final String CONNECTION = "connection";
	public static final String BOOKLIST = "booksList";
	public static final String DOWNLOADED_BOOKLIST = "downloadedBooksList";
	public static final String MESSAGE = "message";
	public static final String ERROR_MESSAGE = "errorMessage";

	public static final String LIBRARY_PAGE = "library.jsp";
	public static final String SELECT_BOOKS_PAGE = "select_books.jsp";
	public static final String INSERT_BOOKS_PAGE = "insert_books.jsp";
	public static final String ERROR_PAGE = "error.jsp";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	Connection getConnection(HttpServletRequest request) {
		Connection connection = (Connection) request.getSession().getAttribute(CONNECTION);
		if (connection == null) {
			try {
				connection = DriverManager.getConnection("jdbc:mysql://127.6.177.130:3306/tomcat", USER_NAME, USER_PASSWORD);
				request.getSession().setAttribute(CONNECTION, connection);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return connection;
	}
}
