package com.formation.infotel.services.interfaces;

import com.formation.infotel.entity.Editor;

import java.util.List;

public interface EditorService {

    void insertEditor(Editor editor) throws Exception;

    void deleteEditor(Editor editor) throws Exception;

    void updateEditor(Editor editor) throws Exception;

    Editor getEditor(int editorId) throws Exception;

    List<Editor> getAllEditors() throws Exception;

    Editor getEditorByName(String name) throws Exception;
}
