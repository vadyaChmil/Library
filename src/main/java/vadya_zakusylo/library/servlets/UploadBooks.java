package vadya_zakusylo.library.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vadya_zakusylo.library.daoimpl.LibraryDaoSql;
import vadya_zakusylo.library.model.Book;
import vadya_zakusylo.library.model.dao.LibraryDao;

public class UploadBooks extends HttpServletLibrary {

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
				request.getRequestDispatcher(UPLOAD_BOOKS_PAGE).forward(request, response);
			} else {
				int[] id = new int[bookId.length];
				for (int index = 0; index < bookId.length; index++) {
					id[index] = Integer.valueOf(bookId[index]);
				}

				@SuppressWarnings("unchecked")
				List<Book> uploadBookList = (List<Book>) request.getSession().getAttribute(UPLOAD_BOOKLIST);
				List<Book> booksList = new ArrayList<>();
				for (int bookById : id) {
					for (Book book : uploadBookList) {
						if (book.getBookId() == bookById) {
							booksList.add(book);
						}
					}
				}
				LibraryDao libraryDao = new LibraryDaoSql(connection);
				libraryDao.addBookList(booksList);
				String message = "Chosen books have loaded to the library";
				// delete uploadedBooksList from memory of session
				uploadBookList = new ArrayList<>();
				request.getSession().setAttribute(UPLOAD_BOOKLIST, uploadBookList);
				request.setAttribute(MESSAGE, message);
				request.getRequestDispatcher(UPLOAD_BOOKS_PAGE).forward(request, response);
			}
		} catch (SQLException e) {
			String errorMessage = e.getMessage();
			request.setAttribute(ERROR_MESSAGE, errorMessage);
			request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
		}
	}
}
