package com.formation.infotel.controller;

import com.formation.infotel.controller.dto.BookDto;
import com.formation.infotel.controller.dto.BookRecDto;
import com.formation.infotel.controller.dto.SearchDto;
import com.formation.infotel.entity.*;
import com.formation.infotel.services.interfaces.*;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	EditorService editorService;
	@Autowired
	AuthorService authorService;

//	@RequestMapping("/books")
//	public Resultat list(Model model) {
//		try {
//			List<Book> books = bookService.getBooks();
//			model.addAttribute("books", books);
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
//
//		return "bookList";
//	}

	@PostMapping(value = "/book/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Resultat bookAdd(@RequestBody BookDto bookDto) throws Exception {

		/*DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(bookDto.getPubDate());
		Book book = new Book(bookDto.getBookTitle(), bookDto.getDescription(), bookDto.getPrice(),
				date, bookDto.getPopular(), bookDto.getImagePath());

		book.setCategory(categoryService.getCategory(bookDto.getCategoryId()));
		book.setEditor(editorService.getEditor(bookDto.getEditorId()));
		List<Author> authors = new ArrayList<>();
		for (int i = 0; i < bookDto.getAuthorsId().size(); i++) {
			authors.add(authorService.getAuthor(bookDto.getAuthorsId().get(i)));
		}
		book.setAuthors(authors);

		bookService.insertBook(book);*/
		
		Resultat resultat = new Resultat();
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = formatter.parse(bookDto.getPubDate());
			Book book = new Book(bookDto.getBookTitle(), bookDto.getDescription(), bookDto.getPrice(),
					date, bookDto.getPopular(), bookDto.getImagePath());

			book.setCategory(categoryService.getCategory(bookDto.getCategoryId()));
			book.setEditor(editorService.getEditor(bookDto.getEditorId()));
			Set<Author> authors = new HashSet<>();
			for (int i = 0; i < bookDto.getAuthorsId().size(); i++) {
				authors.add(authorService.getAuthor(bookDto.getAuthorsId().get(i)));
			}
			book.setAuthors(authors);

			bookService.insertBook(book);
			resultat.setMessage(ControllerConstants.INSERT_SUCCESS);
			resultat.setSuccess(true);
		} catch (Exception e) {

			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.INSERT_ERRORS);
			e.printStackTrace();
		}
	
		return resultat;
	}

	@PostMapping(value = "book/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Resultat updateBook(@RequestBody BookDto bookDto, @PathVariable(value = "id") int id) {
		
		Resultat resultat = new Resultat();
		try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = (Date) formatter.parse(bookDto.getPubDate());
			Book book = bookService.getBookById(id);
			book.setBookTitle(bookDto.getBookTitle());
			book.setBookDescription(bookDto.getDescription());
			book.setBookPrice(bookDto.getPrice());
			book.setPublicationDate(date);
			book.setPopularBook(bookDto.getPopular());
			book.setImagePath(bookDto.getImagePath());
			book.setEditor(editorService.getEditor(bookDto.getEditorId()));
			book.setCategory(categoryService.getCategory(bookDto.getCategoryId()));
			Set<Author> authors = new HashSet<>();
			for (int i = 0; i < bookDto.getAuthorsId().size(); i++) {
				authors.add(authorService.getAuthor(bookDto.getAuthorsId().get(i)));
			}
			book.setAuthors(authors);

			bookService.updateBook(book);
			resultat.setMessage(ControllerConstants.UPDATE_SUCCESS);
			resultat.setSuccess(true);
		} catch (Exception e) {

			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.UPDATE_ERRORS);
			e.printStackTrace();
		}
		
		return resultat;
	}

	@DeleteMapping(value = "book/delete/{id}")
	public Resultat deleteBook(@PathVariable(value = "id") int id) {
		
		Resultat resultat = new Resultat();
		try {
			Book book = bookService.getBookById(id);

			bookService.deleteBook(book);
			resultat.setMessage(ControllerConstants.DELETE_SUCCESS);
			resultat.setSuccess(true);
		} catch (Exception e) {

			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.DELETE_ERRORS);
			e.printStackTrace();
		}
		return resultat;
	}

	@RequestMapping("book/get/{id}")
	public Resultat getBook(@PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();
		BookDto viewBook = null;
		try {
			Book book = bookService.getBookById(id);
			List<Integer> authorsId = new ArrayList<>();
			book.getAuthors().forEach(a -> authorsId.add(a.getAuthorId()));
			viewBook = new BookDto(book.getIsbn(), book.getBookTitle(), book.getBookDescription(), book.getBookPrice(), authorsId,
					book.getCategory().getCategoryId(), book.getEditor().getEditorId(), book.getPublicationDate(),
					book.isPopularBook(), book.getImagePath());
			
			resultat.setMessage(ControllerConstants.RETRIVE_SUCCESS);
			resultat.setSuccess(true);
			resultat.setPayload(viewBook);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.RETRIVE_ERRORS);
			e.printStackTrace();
		}
		return  resultat;
	
	}

	@RequestMapping("book/get")
	public Resultat getBooks() {
		
		Resultat resultat = new Resultat();
		List<BookDto> viewBooks = new ArrayList<>();
		try {
			List<Book> books = bookService.getAll();
			List<Integer> authorsId = new ArrayList<>();
			books.forEach(b -> {
				b.getAuthors().forEach(a -> authorsId.add(a.getAuthorId()));
				viewBooks.add(new BookDto(b.getIsbn(), b.getBookTitle(), b.getBookDescription(), b.getBookPrice(), authorsId,
						b.getCategory().getCategoryId(), b.getEditor().getEditorId(), b.getPublicationDate(),
						b.isPopularBook(), b.getImagePath()));
			});
			resultat.setMessage(ControllerConstants.RETRIVE_SUCCESS);
			resultat.setSuccess(true);
			resultat.setPayload(viewBooks);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.RETRIVE_ERRORS);
			e.printStackTrace();
		}
		return  resultat;
	}

	@RequestMapping("book/get/recs")
	public Resultat getRecBooks(){
		Resultat resultat = new Resultat();
		List<BookRecDto> viewBooks = new ArrayList<>();
		try {
			List<Book> books = bookService.getRecommandedBooks();
			List<Integer> authorsId = new ArrayList<>();
			books.forEach(b -> {
				b.getAuthors().forEach(a -> authorsId.add(a.getAuthorId()));
				viewBooks.add(new BookRecDto(b.getIsbn(), b.getBookTitle(), b.getImagePath()));
			});
			resultat.setMessage(ControllerConstants.RETRIVE_SUCCESS);
			resultat.setSuccess(true);
			resultat.setPayload(viewBooks);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.RETRIVE_ERRORS);
			e.printStackTrace();
		}
		return  resultat;
	}

	@RequestMapping(path = "book/search/{bookTitle}", method = RequestMethod.GET)
	public List<BookDto> searchByName(@PathVariable(value = "bookTitle") String bookTitle){
		System.out.println("BookTitle : " + bookTitle);
		List<BookDto> viewBooks =
				bookService.getBooksByCriteria(bookTitle)
						.stream()
						.map(this::bookToBookDto)
						.collect(Collectors.toList());
		return viewBooks;
	}

	private BookDto bookToBookDto(Book book){
		BookDto bookDto = new BookDto();
		bookDto.setBookId(book.getIsbn());
		bookDto.setBookTitle(book.getBookTitle());
		bookDto.setDescription(book.getBookDescription());
		bookDto.setCategoryId(book.getCategory().getCategoryId());
		bookDto.setEditorId(book.getEditor().getEditorId());
		bookDto.setImagePath(book.getImagePath());
		bookDto.setPopular(book.isPopularBook());
		bookDto.setPrice(book.getBookPrice());
		bookDto.setPubDate(book.getPublicationDate().toString());
		List<Integer> authorsId = new ArrayList<>();
		book.getAuthors().forEach(a -> authorsId.add(a.getAuthorId()));
		System.out.println("Auteurs : " + authorsId);
		bookDto.setAuthorsId(authorsId);
		return bookDto;
	}

	@RequestMapping(value = "/image", method = RequestMethod.GET)
	public void getImageAsByteArray(@RequestParam String imagePath, HttpServletResponse response, HttpServletRequest request) throws IOException {
		InputStream in = request.getServletContext().getResourceAsStream("/webapp/resources/" + imagePath);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		IOUtils.copy(in, response.getOutputStream());
	}
}
