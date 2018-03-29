package com.formation.infotel.controller;

import com.formation.infotel.controller.dto.BookCopyDto;
import com.formation.infotel.entity.BookBasket;
import com.formation.infotel.entity.Book_copy;
import com.formation.infotel.services.interfaces.BookBasketService;
import com.formation.infotel.services.interfaces.BookCopyService;
import com.formation.infotel.services.interfaces.BookService;
import com.formation.infotel.services.interfaces.BookShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class BookCopyController {

	@Autowired
	private BookCopyService bookCopyService;
	@Autowired
	private BookService bookService;
	@Autowired
	private BookShelfService bookShelfService;
	@Autowired
	private BookBasketService bookBasketService;

	@PutMapping(value = "bookCopy/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Resultat  addBookCopy(@RequestBody BookCopyDto bookCopyDto) {
		
		Resultat resultat = new Resultat();

		try {
			Book_copy bookCopy = new Book_copy();
			bookCopy.setBook_copyTitle(bookCopyDto.getBook_copyTitle());
			bookCopy.setBook(bookService.getBookById(bookCopyDto.getBookIsbn()));
			bookCopy.setBookShelf(bookShelfService.getBookShelf(bookCopyDto.getBookShelfId()));
			Set<BookBasket> basket = new HashSet<>();
			for (int i = 0; i < bookCopyDto.getBookBasketsId().size(); i++) { // parcours de la liste des ID de
																				// bookbasket
				basket.add(bookBasketService.getBookBasket(bookCopyDto.getBookBasketsId().get(i)));
			}
			bookCopy.setBookBaskets(basket);

			bookCopyService.insertBookCopy(bookCopy);
			resultat.setMessage(ControllerConstants.INSERT_SUCCESS);
			resultat.setSuccess(true);

		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.INSERT_ERRORS);
			e.printStackTrace();
		}
		
		return resultat;
	}

	@PostMapping(value = "bookCopy/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Resultat  updateBookCopy(@RequestBody BookCopyDto bookCopyDto, @PathVariable(value = "id") int id) {
		
		Resultat resultat = new Resultat();


		try {

			Book_copy bookCopy = bookCopyService.getBookCopy(id);
			bookCopy.setBook_copyTitle(bookCopyDto.getBook_copyTitle());
			bookCopy.setBook(bookService.getBookById(bookCopyDto.getBookIsbn()));
			bookCopy.setBookShelf(bookShelfService.getBookShelf(bookCopyDto.getBookShelfId()));
			Set<BookBasket> basket = new HashSet<>();
			for (int i = 0; i < bookCopyDto.getBookBasketsId().size(); i++) { // parcours de la liste des ID de
																				// bookbasket
				basket.add(bookBasketService.getBookBasket(bookCopyDto.getBookBasketsId().get(i)));
			}
			bookCopy.setBookBaskets(basket);

			bookCopyService.updateBookCopy(bookCopy);
			resultat.setMessage(ControllerConstants.UPDATE_SUCCESS);
			resultat.setSuccess(true);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.UPDATE_ERRORS);
			e.printStackTrace();
		}
		
		return resultat;
	}

	@DeleteMapping(value = "bookCopy/delete/{id}")
	public Resultat deleteBookCopy(@PathVariable(value = "id") int id) {
		
		Resultat resultat = new Resultat();

		try {
			Book_copy bookCopy = bookCopyService.getBookCopy(id);

			bookCopyService.deleteBookCopy(bookCopy);
			
			resultat.setMessage(ControllerConstants.DELETE_SUCCESS);
			resultat.setSuccess(true);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.DELETE_ERRORS);
			e.printStackTrace();
		}
		return resultat;
	}

	@RequestMapping("bookCopy/get/{id}")
	public Resultat getBookCopy(@PathVariable(value = "id") int id) {
		BookCopyDto viewBookCopy = null;
		Resultat resultat = new Resultat();
		try {
			Book_copy bookCopy = bookCopyService.getBookCopy(id);
			List<Integer> basketsId = new ArrayList<>();
			bookCopy.getBookBaskets().forEach(bb -> basketsId.add(bb.getBoookBasketId()));
			viewBookCopy = new BookCopyDto(bookCopy.getBook_copyTitle(), bookCopy.getBook().getIsbn(),
					bookCopy.getBookShelf().getBookShelfId(), basketsId);
			
			resultat.setMessage(ControllerConstants.RETRIVE_SUCCESS);
			resultat.setSuccess(true);
			resultat.setPayload(viewBookCopy);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.RETRIVE_ERRORS);
			e.printStackTrace();
		}
		return resultat;
	}

	@RequestMapping("bookCopy/get")
	public Resultat  getBookCopies() {
		
		List<BookCopyDto> viewBookCopy = new ArrayList<>();
		Resultat resultat = new Resultat();
		try {
			List<Book_copy> bookCopy = bookCopyService.getAll();
			List<Integer> basketsId = new ArrayList<>();
			bookCopy.forEach(bb -> {
				bb.getBookBaskets().forEach(b -> basketsId.add(b.getBoookBasketId()));
				viewBookCopy.add(new BookCopyDto(bb.getBook_copyTitle(), bb.getBook().getIsbn(),
						bb.getBookShelf().getBookShelfId(), basketsId));
			});
			resultat.setMessage(ControllerConstants.RETRIVE_SUCCESS);
			resultat.setSuccess(true);
			resultat.setPayload(viewBookCopy);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.RETRIVE_ERRORS);
			e.printStackTrace();
		}
		return resultat;
	}
}



