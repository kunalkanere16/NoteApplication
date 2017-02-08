package com.services;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import com.domainModel.Note;

public interface Service {
	public JSONObject getNoteList(HttpServletRequest request);
	
	public String addNewNote(String title, String content);
	
	public String updateNote(int id, String title, String content);
	
	public String deleteNote(int id);
	
	public Note getNoteById(int id);
}
