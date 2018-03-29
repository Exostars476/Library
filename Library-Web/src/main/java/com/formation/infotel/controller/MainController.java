package com.formation.infotel.controller;

import com.formation.infotel.entity.Book;
import com.formation.infotel.services.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MainController extends HttpServlet {

    @Autowired
    BookService bookService;

    @GetMapping("/index")
    public String home(HttpServletRequest request, Model model){
        recommandedBooks(request, model);
        return "index";
    }

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model){
        recommandedBooks(request, model);
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "loginPages/login";
    }

    private void recommandedBooks(HttpServletRequest request, Model model){
        List<Book> books;
		try {
			books = bookService.getRecommandedBooks();
			model.addAttribute("books", books);
		} catch (Exception e) {
			e.printStackTrace();
		}
      
    }
}