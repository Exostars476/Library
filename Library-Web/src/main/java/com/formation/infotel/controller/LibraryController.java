package com.formation.infotel.controller;

import java.util.ArrayList;
import java.util.List;

import com.formation.infotel.entity.MemLibId;
import com.formation.infotel.entity.Registration;
import com.formation.infotel.services.interfaces.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.formation.infotel.controller.dto.LibraryDto;
import com.formation.infotel.entity.Library;
import com.formation.infotel.services.interfaces.LibraryService;

@RestController
public class LibraryController {

	@Autowired
	LibraryService libraryService;
	@Autowired
	RegistrationService registrationService;

	@PutMapping(value = "library/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Resultat addLibrary(@RequestBody LibraryDto libraryDto) {
		Resultat resultat = new Resultat();


		Library library = new Library(libraryDto.getLibraryName(), libraryDto.getLibraryAddress());
		List<Registration> registrations = new ArrayList<>();
		for (int i = 0; i < libraryDto.getRegistrationsId().size(); i++) {
			try {
				registrations.add(registrationService.getRegistration(libraryDto.getRegistrationsId().get(i)));

				library.setRegistrations(registrations);

				libraryService.insertLibrary(library);
				resultat.setMessage(ControllerConstants.INSERT_SUCCESS);
				resultat.setSuccess(true);
			} catch (Exception e) {
				resultat.setSuccess(false);
				resultat.setMessage(ControllerConstants.INSERT_ERRORS);
				e.printStackTrace();
			}
		}
		return resultat;

	}

	@PostMapping(value = "library/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Resultat updateLibrary(@RequestBody LibraryDto libraryDto, @PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();


		Library library;
		try {
			library = libraryService.getLibrary(id);

			library.setLibraryName(libraryDto.getLibraryName());
			library.setLibraryAddress(libraryDto.getLibraryAddress());
			List<Registration> registrations = new ArrayList<>();
			for (int i = 0; i < libraryDto.getRegistrationsId().size(); i++) {
				registrations.add(registrationService.getRegistration(libraryDto.getRegistrationsId().get(i)));
			}
			library.setRegistrations(registrations);

			libraryService.updateLibrary(library);
			resultat.setMessage(ControllerConstants.UPDATE_SUCCESS);
			resultat.setSuccess(true);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.UPDATE_ERRORS);
			e.printStackTrace();
		}
		
		return resultat;
	}

	@DeleteMapping(value = "library/delete/{id}")
	public Resultat deleteLibrary(@PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();


		Library library;
		try {
			library = libraryService.getLibrary(id);
			libraryService.deleteLibrary(library);
			resultat.setMessage(ControllerConstants.RETRIVE_SUCCESS);
			resultat.setSuccess(true);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.RETRIVE_ERRORS);
			e.printStackTrace();
		}
		return resultat;

	}

	@RequestMapping("library/get/{id}")
	public Resultat getLibrary(@PathVariable(value = "id") int id) {
		Resultat resultat = new Resultat();

		Library library;
		LibraryDto viewLibrary = null;
		try {
			library = libraryService.getLibrary(id);

			List<MemLibId> registrationsId = new ArrayList<>();
			library.getRegistrations().forEach(r -> {
				registrationsId.add(r.getId());
			});
			viewLibrary = new LibraryDto(library.getLibraryName(), library.getLibraryAddress(), registrationsId);
			resultat.setMessage(ControllerConstants.RETRIVE_SUCCESS);
			resultat.setSuccess(true);
			resultat.setPayload(viewLibrary);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.RETRIVE_ERRORS);
			e.printStackTrace();
		}
		return resultat;
	}

	@RequestMapping("library/get")
	public Resultat getLibraries() {
		
		Resultat resultat = new Resultat();

		List<LibraryDto> viewLibraries = new ArrayList<>();
		List<Library> libraries;
		try {
			libraries = libraryService.getAllLibraries();
	
		List<MemLibId> registrationsId = new ArrayList<>();
		libraries.forEach(l -> {
			l.getRegistrations().forEach(r -> registrationsId.add(r.getId()));
			viewLibraries.add(new LibraryDto(l.getLibraryName(), l.getLibraryAddress(), registrationsId));
		});
		resultat.setMessage(ControllerConstants.RETRIVE_SUCCESS);
		resultat.setSuccess(true);
		resultat.setPayload(viewLibraries);
		} catch (Exception e) {
			resultat.setSuccess(false);
			resultat.setMessage(ControllerConstants.RETRIVE_ERRORS);
			e.printStackTrace();
		}
		return resultat;
	}

}
