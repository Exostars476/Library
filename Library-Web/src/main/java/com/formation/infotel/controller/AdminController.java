package com.formation.infotel.controller;

import com.formation.infotel.entity.*;
import com.formation.infotel.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class AdminController extends HttpServlet{

    @Autowired
    MemberService memberService;
    @Autowired
    EditorService editorService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    AuthorService authorService;

    @RequestMapping(value = "/administration")
    public String administration(){
        return "admin/administration";
    }

    @RequestMapping(value = "/addUser")
    public String addMember(){
        return "admin/addMember";
    }

    @RequestMapping(value = "/editMember", method = RequestMethod.GET, produces = "application/json")
    public String editMember(@RequestParam("id") int id) {
        /*
        Member member = memberService.getMember(id);
        model.addAttribute("member", member);
        return "admin/editMember";*/
        return "";
    }

    @RequestMapping(value = "/addBook", produces = "application/json")
    public Resultat addBook(Model model, HttpServletRequest request){
		Resultat resultat = new Resultat();

       try {
    	   List<Editor> editors = editorService.getAllEditors();
       
        model.addAttribute("editors", editors);

        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);

        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("authors", authors);
        resultat.setMessage(ControllerConstants.INSERT_SUCCESS);
		resultat.setSuccess(true);

        
		} catch (Exception e) {

			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.INSERT_ERRORS);
			e.printStackTrace();

		}

        return resultat;
    }
}
