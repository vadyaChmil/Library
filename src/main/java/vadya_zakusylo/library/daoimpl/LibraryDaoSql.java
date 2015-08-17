package vadya_zakusylo.library.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vadya_zakusylo.library.model.Book;
import vadya_zakusylo.library.model.dao.LibraryDao;

public class LibraryDaoSql implements LibraryDao {
	private Connection connection;
	List<Book> bookList;

	public LibraryDaoSql(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Book> getBookList() throws SQLException {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(createCommandSelectBooks());
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
			throw new SQLException("Problem with connecting to DataBase");
		}
	}

	String createCommandSelectBooks() {
		StringBuilder sql = new StringBuilder();
		sql.append("select id, autor, title, year_edition, pages ");
		sql.append("from books;");
		return sql.toString();
	}

	@Override
	public void addBook(Book book) throws SQLException {
		try {
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement = connection.prepareStatement(createCommandInsertBook());
			preparedStatement.setInt(1, book.getBookId());
			preparedStatement.setString(2, book.getBookAutor());
			preparedStatement.setString(3, book.getBookTitle());
			preparedStatement.setInt(4, book.getYearEdition());
			preparedStatement.setInt(5, book.getPages());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			connection.rollback();
			throw new SQLException("Problem with connecting to DataBase");
		}
	}

	String createCommandInsertBook() {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into books ");
		sql.append("(id, autor, title, year_edition, pages) ");
		sql.append("values (?,?,?,?,?);");
		return sql.toString();
	}

	@Override
	public void addBookList(List<Book> books) throws SQLException {
		for (Book book : books) {
			addBook(book);
		}
	}
}
