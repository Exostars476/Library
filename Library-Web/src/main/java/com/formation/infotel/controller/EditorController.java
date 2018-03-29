package com.formation.infotel.controller;

import com.formation.infotel.controller.dto.EditorDto;
import com.formation.infotel.entity.Book;
import com.formation.infotel.entity.Editor;
import com.formation.infotel.services.interfaces.BookService;
import com.formation.infotel.services.interfaces.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class EditorController {

	@Autowired
	EditorService editorService;
	@Autowired
	BookService bookService;

	@PutMapping(value = "editor/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Resultat addEditor(@RequestBody EditorDto editorDto) {
		Resultat resultat = new Resultat();

		try {
			Editor editor = new Editor(editorDto.getName(), editorDto.getEditorAddress());
			Set<Book> books = new HashSet<>();
			for (int i = 0; i < editorDto.getBooksId().size(); i++) {

				books.add(bookService.getBookById(editorDto.getBooksId().get(i)));

			}
			editor.setBooks(books);
			resultat.setMessage(ControllerConstants.INSERT_SUCCESS);
			resultat.setSuccess(true);

			editorService.insertEditor(editor);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.INSERT_ERRORS);
			e.printStackTrace();
		}
		return resultat;
	}

	@PostMapping(value = "editor/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Resultat updateEditor(@RequestBody EditorDto editorDto, @PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();

		try {
			Editor editor = editorService.getEditor(id);
			editor.setName(editorDto.getName());
			editor.setEditorAddress(editorDto.getEditorAddress());
			Set<Book> books = new HashSet<>();
			for (int i = 0; i < editorDto.getBooksId().size(); i++) {
				books.add(bookService.getBookById(editorDto.getBooksId().get(i)));
			}
			editor.setBooks(books);

			editorService.updateEditor(editor);
			resultat.setMessage(ControllerConstants.UPDATE_SUCCESS);
			resultat.setSuccess(true);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.UPDATE_ERRORS);
			e.printStackTrace();
		}
		return resultat;
	}

	@DeleteMapping(value = "editor/delete/{id}")
	public Resultat deleteEditor(@PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();

		Editor editor;
		try {
			editor = editorService.getEditor(id);
		
			resultat.setMessage(ControllerConstants.DELETE_SUCCESS);
			resultat.setSuccess(true);
		editorService.deleteEditor(editor);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.DELETE_ERRORS);
			e.printStackTrace();
		}
		return resultat;

	}

	@RequestMapping("editor/get/{id}")
	public Resultat getEditor(@PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();

		Editor editor;
		EditorDto viewEditor = null;
		try {
			editor = editorService.getEditor(id);
		
		List<Integer> booksId = new ArrayList<>();
		editor.getBooks().forEach(b -> {
			booksId.add(b.getIsbn());
		});
		viewEditor = new EditorDto(editor.getName(), editor.getEditorAddress(), booksId,editor.getEditorId());
		resultat.setMessage(ControllerConstants.RETRIVE_SUCCESS);
		resultat.setSuccess(true);
		resultat.setPayload(viewEditor);
		
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.RETRIVE_ERRORS);
			e.printStackTrace();
		}
		return resultat;
	}

	@RequestMapping("editor/get")
	public Resultat getEditors() {
		
		Resultat resultat = new Resultat();

		List<EditorDto> viewEditors = new ArrayList<>();
		List<Editor> editors;
		try {
			editors = editorService.getAllEditors();
	
		List<Integer> booksId = new ArrayList<>();
		editors.forEach(e -> {
			e.getBooks().forEach(b -> booksId.add(b.getIsbn()));
			viewEditors.add(new EditorDto(e.getName(), e.getEditorAddress(), booksId,e.getEditorId()));
		});
		resultat.setMessage(ControllerConstants.RETRIVE_SUCCESS);
		resultat.setSuccess(true);
		resultat.setPayload(viewEditors);
		} catch (Exception e1) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.RETRIVE_ERRORS);
			e1.printStackTrace();
		}
		return resultat;
	}
}
