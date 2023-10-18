package bookshelter.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@Column
	private int id;
	@Column
	private String bookname;
	@Column
	private Date dateofbook;

	public Book() {
	}

	public Book(String bookname, Date dateofbook) {
		this.bookname = bookname;
		this.dateofbook = dateofbook;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public Date getDateofbook() {
		return dateofbook;
	}
	public void setDateofbook(Date dateofbook) {
		this.dateofbook = dateofbook;
	}

}
