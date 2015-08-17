package vadya_zakusylo.library.model.dao;

import java.sql.SQLException;
import java.util.List;

import vadya_zakusylo.library.model.Book;

public interface LibraryDao {

	List<Book> getBookList() throws SQLException;

	void addBook(Book book) throws SQLException;

	void addBookList(List<Book> books) throws SQLException;

}
