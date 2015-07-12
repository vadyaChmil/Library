package vadya_zakusylo.library.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vadya_zakusylo.library.model.Book;
import vadya_zakusylo.library.model.dao.LibraryDao;
import vadya_zakusylo.library.model.exception.SqlConnectionException;

public class LibraryDaoMySql implements LibraryDao {
	private Connection connection;
	List<Book> bookList;

	public LibraryDaoMySql(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Book> getBookList() throws SqlConnectionException {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(createCommandSelectBooks());
			ResultSet resultSet = preparedStatement.executeQuery();
			bookList = new ArrayList<Book>();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String bookAutor = resultSet.getString("autor");
				String bookTitle = resultSet.getString("title");
				int yearEdition = resultSet.getInt("year_edition");
				int pages = resultSet.getInt("pages");
				bookList.add(new Book(id, bookAutor, bookTitle, yearEdition, pages));
			}
			return bookList;
		} catch (SQLException e) {
			throw new SqlConnectionException("Problem with connecting to DataBase");
		}
	}

	String createCommandSelectBooks() {
		StringBuilder sql = new StringBuilder();
		sql.append("select id, autor, title, year_edition, pages ");
		sql.append("from books;");
		return sql.toString();
	}

	@Override
	public void setBookList(List<Book> books) throws SqlConnectionException {
		for (Book book : books) {
			insertBook(book.getBookId(), book.getBookAutor(), book.getBookTitle(),
					book.getYearEdition(), book.getPages());
		}
	}

	void insertBook(int id, String bookAutor, String bookTitle, int yearEdition, int pages)
			throws SqlConnectionException {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(createCommandInsertBook());
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, bookAutor);
			preparedStatement.setString(3, bookTitle);
			preparedStatement.setInt(4, yearEdition);
			preparedStatement.setInt(5, pages);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new SqlConnectionException("Problem with connecting to DataBase");
		}
	}

	String createCommandInsertBook() {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into books ");
		sql.append("(id, autor, title, year_edition, pages) ");
		sql.append("values (?,?,?,?,?);");
		return sql.toString();
	}
}
