package bookshelter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookshelter.dao.ShelterDAO;
import bookshelter.model.Book;


@Service("ShelterService")
@Transactional
public class ShelterService {

	@Autowired
	private ShelterDAO dao;
	
	public List<Book> getListOfBooks(){
		return dao.getListOfBooks();
	}

	public Book saveBook(Book book){
		return dao.saveBook(book);
	}
	
}
