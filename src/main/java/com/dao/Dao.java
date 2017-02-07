package com.dao;

import java.util.ArrayList;

import org.json.JSONObject;

import com.domainModel.Note;

public interface Dao {
	public void test();
	
	public ArrayList<Note> getNoteList();
	
	public String addNewNote(String title, String content);
	
	public Note getNoteById(int id);
}
