package com.formation.infotel.interfaces;

import com.formation.infotel.entity.Library;

public interface LibraryDao {

    Library  getLibraryByName(String libraryname);
}
