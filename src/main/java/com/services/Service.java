package com.services;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import com.domainModel.Note;

public interface Service {
	public JSONObject getNoteList(HttpServletRequest request);
	
	public String addNewNote(String title, String content);
	
	public Note getNoteById(int id);
}
