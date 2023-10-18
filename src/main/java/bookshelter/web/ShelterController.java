package bookshelter.web;

import bookshelter.logic.BaseController;
import bookshelter.model.Book;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ShelterController {
	private final static int MAX_BOOK_NAME_LENGTH = 10;

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(Model model) {
		
		BaseController base = new BaseController();
		List<Book> books = base.getListOfBooks();
		base.closeConnection();
		
		model.addAttribute("books", books);
		
		return "bookshelter";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doPost(@RequestParam(value = "name") String name, Model model) {
		if (name.length() > MAX_BOOK_NAME_LENGTH) {
			model.addAttribute("message", "довга назва");
			return doGet(model);
		}
		Book book = new Book(name, new Date());
		BaseController base = new BaseController();
		base.saveBook(book);

		return doGet(model);
	}
	
}
