package com.formation.infotel.controller;

import com.formation.infotel.controller.dto.BookBasketDto;
import com.formation.infotel.entity.BookBasket;
import com.formation.infotel.entity.Book_copy;
import com.formation.infotel.services.interfaces.BookBasketService;
import com.formation.infotel.services.interfaces.BookCopyService;
import com.formation.infotel.services.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class BookBasketController {

	@Autowired
	private BookBasketService bookBasketService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private BookCopyService bookCopyService;

	@PutMapping(value = "bookBasket/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Resultat addBookBasket(@RequestBody BookBasketDto bookBasketDto) {
		Resultat resultat = new Resultat();
		try {
			BookBasket bookBasket = new BookBasket();
			bookBasket.setCreationDate(bookBasketDto.getCreationDate());
			bookBasket.setDeliveryDate(bookBasketDto.getDeliveryDate());
			bookBasket.setMember(memberService.getMember(bookBasketDto.getMemberId()));
			Set<Book_copy> books = new HashSet<>();
			for (int i = 0; i < bookBasketDto.getBook_copiesId().size(); i++) {
				books.add(bookCopyService.getBookCopy(bookBasketDto.getBook_copiesId().get(i)));
			}
			bookBasket.setBook_copies(books);

			bookBasketService.insertBookBasket(bookBasket);
			resultat.setMessage(ControllerConstants.INSERT_SUCCESS);
			resultat.setSuccess(true);

		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.INSERT_ERRORS);
			e.printStackTrace();

		}

		return resultat;
	}

	@PostMapping(value = "bookBasket/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Resultat updateBookBasket(@RequestBody BookBasketDto bookBasketDto, @PathVariable(value = "id") int id) {

		Resultat resultat = new Resultat();
		try {
			BookBasket bookBasket = bookBasketService.getBookBasket(id);
			bookBasket.setCreationDate(bookBasketDto.getCreationDate());
			bookBasket.setDeliveryDate(bookBasketDto.getDeliveryDate());
			bookBasket.setMember(memberService.getMember(bookBasketDto.getMemberId()));
			Set<Book_copy> books = new HashSet<>();
			for (int i = 0; i < bookBasketDto.getBook_copiesId().size(); i++) {
				books.add(bookCopyService.getBookCopy(bookBasketDto.getBook_copiesId().get(i)));
			}
			bookBasket.setBook_copies(books);

			bookBasketService.updateBookBasket(bookBasket);
			resultat.setMessage(ControllerConstants.UPDATE_SUCCESS);
			resultat.setSuccess(true);
		} catch (

		Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.UPDATE_ERRORS);
			e.printStackTrace();
		}

		return resultat;
	}

	@DeleteMapping(value = "bookBasket/delete/{id}")
	public Resultat deleteBookBasket(@PathVariable(value = "id") int id) {

		Resultat resultat = new Resultat();
		try {
			BookBasket bookBasket = bookBasketService.getBookBasket(id);

			bookBasketService.deleteBookBasket(bookBasket);
			resultat.setMessage(ControllerConstants.DELETE_SUCCESS);
			resultat.setSuccess(true);

		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.DELETE_ERRORS);
			e.printStackTrace();
		}

		return resultat;
	}

	@RequestMapping("bookBasket/get/{id}")
	public Resultat getBookBasket(@PathVariable(value = "id") int id) {

		Resultat resultat = new Resultat();
		BookBasketDto viewBookBasket = null;

		try {
			BookBasket bookBasket = bookBasketService.getBookBasket(id);
			List<Integer> booksId = new ArrayList<>();
			bookBasket.getBook_copies().forEach(b -> {
				booksId.add(b.getBook_copyId());
			});
			viewBookBasket = new BookBasketDto(bookBasket.getCreationDate(), bookBasket.getDeliveryDate(),
					bookBasket.getMember().getMemberId(), booksId);
			resultat.setMessage(ControllerConstants.RETRIVE_SUCCESS);
			resultat.setSuccess(true);
			resultat.setPayload(viewBookBasket);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.RETRIVE_ERRORS);
			e.printStackTrace();
		}

		return resultat;
	}

	@RequestMapping("bookBasket/get")
	public Resultat getBookBaskets() {
		
		Resultat resultat = new Resultat();
		List<BookBasketDto> viewBookBaskets = new ArrayList<>();

		try {
			List<BookBasket> bookBaskets = bookBasketService.getAllBookBaskets();
			List<Integer> booksId = new ArrayList<>();
			bookBaskets.forEach(bb -> {
				bb.getBook_copies().forEach(b -> booksId.add(b.getBook_copyId()));
				viewBookBaskets.add(new BookBasketDto(bb.getCreationDate(), bb.getDeliveryDate(),
						bb.getMember().getMemberId(), booksId));
			});
			resultat.setMessage(ControllerConstants.RETRIVE_SUCCESS);
			resultat.setSuccess(true);
			resultat.setPayload(viewBookBaskets);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.RETRIVE_ERRORS);
			e.printStackTrace();
		}
		return resultat;
	}
}
