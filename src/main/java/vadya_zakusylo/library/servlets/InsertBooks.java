package vadya_zakusylo.library.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vadya_zakusylo.library.daoimpl.LibraryDaoMySql;
import vadya_zakusylo.library.model.Book;
import vadya_zakusylo.library.model.dao.LibraryDao;
import vadya_zakusylo.library.model.exception.SqlConnectionException;

public class InsertBooks extends HttpServletLibrary {

	/**
	 * Vadya Zakusylo
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connection = getConnection(request);

		try {
			String[] bookId = request.getParameterValues("bookId");
			if (bookId == null) {
				String message = "You haven't chosen books for loading";
				request.setAttribute(MESSAGE, message);
				request.getRequestDispatcher(INSERT_BOOKS_PAGE).forward(request, response);
			} else {
				int[] id = new int[bookId.length];
				for (int index = 0; index < bookId.length; index++) {
					id[index] = Integer.valueOf(bookId[index]);
				}

				@SuppressWarnings("unchecked")
				List<Book> downloadedBooksList =
						(List<Book>) request.getSession().getAttribute(DOWNLOADED_BOOKLIST);
				List<Book> booksList = new ArrayList<>();
				for (int bookById : id) {
					for (Book book : downloadedBooksList) {
						if (book.getBookId() == bookById) {
							booksList.add(book);
						}
					}
				}
				LibraryDao libraryDao = new LibraryDaoMySql(connection);
				libraryDao.setBookList(booksList);
				String message = "Chosen books have loaded to the library";
				// delete downloadedBooksList from memory of session
				downloadedBooksList = new ArrayList<>();
				request.getSession().setAttribute(DOWNLOADED_BOOKLIST, downloadedBooksList);
				request.setAttribute(MESSAGE, message);
				request.getRequestDispatcher(INSERT_BOOKS_PAGE).forward(request, response);
			}
		} catch (SqlConnectionException e) {
			String errorMessage = e.getMessage();
			request.setAttribute(ERROR_MESSAGE, errorMessage);
			request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
		}
	}
}
