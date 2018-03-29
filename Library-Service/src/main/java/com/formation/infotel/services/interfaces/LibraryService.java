package com.formation.infotel.services.interfaces;

import com.formation.infotel.entity.Library;

import java.util.List;

public interface LibraryService {

    void insertLibrary(Library library) throws Exception;

    void deleteLibrary(Library library) throws Exception;

    void updateLibrary(Library library) throws Exception;

    Library getLibrary(int libraryId) throws Exception;

    List<Library> getAllLibraries() throws Exception;
}
