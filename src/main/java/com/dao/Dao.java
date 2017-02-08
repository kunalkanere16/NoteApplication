package com.dao;

import java.util.ArrayList;

import org.json.JSONObject;

import com.domainModel.Note;

public interface Dao {
	public ArrayList<Note> getNoteList(String wherePart, String orderByPart, String rowNumPart);
	
	public String addNewNote(String title, String content);
	
	public String updateNote(int id, String title, String content);
	
	public String deleteNote(int id);
	
	public Note getNoteById(int id);
	
	public int getNotesCount(String wherePart);
}
