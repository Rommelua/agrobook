package bookshelter.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bookshelter.logic.BaseController;
import bookshelter.model.Book;

@Controller
@RequestMapping("/")
public class ShelterController {


	@RequestMapping(method = RequestMethod.GET)
	public String doGet(Model model) {
		
		BaseController base = new BaseController();
		List<Book> books = base.getListOfBooks();
		base.closeConnection();
		
		model.addAttribute("books", books);
		
		return "bookshelter";
	}
	
}
