package com.formation.infotel.services.impl;

import com.formation.infotel.entity.Editor;
import com.formation.infotel.exception.ErrorConstants;
import com.formation.infotel.interfaces.Dao;
import com.formation.infotel.interfaces.EditorDao;
import com.formation.infotel.services.interfaces.EditorService;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditorServiceImpl implements EditorService{

    @Autowired
    private EditorDao editorDao;
    @Autowired
    private Dao dao;

    @Override
    public void insertEditor(Editor editor)  throws Exception {
        dao.save(editor);
    }

    @Override
    public void deleteEditor(Editor editor)  throws Exception{
        dao.delete(editor);
    }

    @Override
    public void updateEditor(Editor editor) throws Exception {
        dao.saveOrUpdate(editor);
    }

    @Override
    public Editor getEditor(int editorId) throws Exception {
        return dao.get(Editor.class, editorId);
    }

    @Override
    public List<Editor> getAllEditors()  throws Exception{
    	
    	List<Editor> editor = null;
    	editor =dao.getAll(Editor.class);
    	
    	if (editor.isEmpty())
			throw new ServiceException(ErrorConstants.EDITOR_EMPTY);

        return editor;
    }

    @Override
    public Editor getEditorByName(String name) throws Exception {
        return editorDao.getEditorByName(name);
    }
}
