package com.formation.infotel.services.impl;

import com.formation.infotel.entity.Library;
import com.formation.infotel.exception.ErrorConstants;
import com.formation.infotel.interfaces.Dao;
import com.formation.infotel.services.interfaces.LibraryService;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private Dao dao;

    @Override
    public void insertLibrary(Library library)  throws Exception{
        dao.save(library);
    }

    @Override
    public void deleteLibrary(Library library)  throws Exception{
        dao.delete(library);
    }

    @Override
    public void updateLibrary(Library library)  throws Exception{
        dao.saveOrUpdate(library);
    }

    @Override
    public Library getLibrary(int libraryId)  throws Exception{
        return dao.get(Library.class, libraryId);
    }

    @Override
    public List<Library> getAllLibraries() throws Exception {
    	
    	List<Library> library = null;
    	library = dao.getAll(Library.class);
    	 if(library.isEmpty())
 			throw new ServiceException(ErrorConstants.LIBRARY_EMPTY);

    	
        return library;
    }
}
