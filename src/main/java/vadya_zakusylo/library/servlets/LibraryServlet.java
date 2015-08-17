package vadya_zakusylo.library.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vadya_zakusylo.library.daoimpl.LibraryDaoSql;
import vadya_zakusylo.library.model.Book;
import vadya_zakusylo.library.model.dao.LibraryDao;

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
			LibraryDao libraryDao = new LibraryDaoSql(connection);
			List<Book> bookList = libraryDao.getBookList();
			request.setAttribute(BOOKLIST, bookList);
			request.getRequestDispatcher(LIBRARY_PAGE).forward(request, response);
		} catch (SQLException e) {
			String errorMessage = e.getMessage();
			request.setAttribute(ERROR_MESSAGE, errorMessage);
			request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
		}
	}
}
