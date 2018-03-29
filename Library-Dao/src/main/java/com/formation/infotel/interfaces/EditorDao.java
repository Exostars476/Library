package com.formation.infotel.interfaces;

import com.formation.infotel.entity.Editor;

public interface EditorDao {

    Editor getEditorByName(String editorname);
}
