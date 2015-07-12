package vadya_zakusylo.library.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vadya_zakusylo.library.daoimpl.LibraryDaoMySql;
import vadya_zakusylo.library.model.Book;
import vadya_zakusylo.library.model.dao.LibraryDao;
import vadya_zakusylo.library.model.exception.SqlConnectionException;

public class LibraryServlet extends HttpServletLibrary {

	/**
	 * Vadya Zakusylo
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = getConnection(request);
		try {
			LibraryDao libraryDao = new LibraryDaoMySql(connection);
			List<Book> booksList = libraryDao.getBookList();
			request.setAttribute(BOOKLIST, booksList);
			request.getRequestDispatcher(LIBRARY_PAGE).forward(request, response);
		} catch (SqlConnectionException e) {
			String errorMessage = e.getMessage();
			request.setAttribute(ERROR_MESSAGE, errorMessage);
			request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
		}
	}
}
