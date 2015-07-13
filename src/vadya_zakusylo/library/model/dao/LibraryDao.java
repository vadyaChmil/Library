package vadya_zakusylo.library.model.dao;

import java.util.List;

import vadya_zakusylo.library.model.Book;
import vadya_zakusylo.library.model.exception.SqlConnectionException;

public interface LibraryDao {

	List<Book> getBookList() throws SqlConnectionException;

	void setBookList(List<Book> books) throws SqlConnectionException;

}
