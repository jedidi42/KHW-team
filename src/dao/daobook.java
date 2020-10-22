package dao;

import java.util.Date;

import bookstore.Models.Book;

public class daobook {

	
	
	Book createook(String title , Date date , String authors)

	{
		Book b1 = new Book ();
		b1.title = title ;
		b1.publicationDate=date  ; 
		b1.authors=authors ;
		return null;}

}
