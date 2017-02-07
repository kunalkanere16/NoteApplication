package com.services;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DaoImpl;
import com.domainModel.Note;

@Service("service")
public class ServiceImpl implements com.services.Service{
	
	@Autowired
	private DaoImpl dao;
	
	public JSONObject getNoteList(HttpServletRequest request) {
		JSONObject obj=new JSONObject();
		ArrayList<Note> noteList = null;
		try{
			
			//for datatable internal
			String startStr = request.getParameter("iDisplayStart");
			int start = -1;
			if(startStr != null)
				start = Integer.parseInt(startStr);
			
			int noOfRecords = Integer.parseInt(request.getParameter("iDisplayLength"));
			
			
			
			//total records
			int echo = Integer.parseInt(request.getParameter("sEcho"));
			int totalRecords = 1;
			totalRecords = 10;
			obj.put("sEcho",new Integer(echo));
			obj.put("iTotalRecords",new Integer(totalRecords));
			
			noteList = dao.getNoteList();
			System.out.println("list size = "+noteList.size());
			JSONArray parentObj = new JSONArray();
			JSONArray childList = null;
			for(int i=0; i<noteList.size(); i++){
				childList = new JSONArray();
				childList.put(noteList.get(i).getTitle());
				childList.put(noteList.get(i).getContent());
				childList.put("<a href='viewNote.page?id="+noteList.get(i).getId()+"'>View</a>");
				parentObj.put(childList);
			}
			obj.put("aaData", parentObj);
			
			//filtered records
			int totalFilteredRecords = 0;
			
			obj.put("iTotalDisplayRecords",new Integer(totalFilteredRecords));
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return obj;
	}

	public String addNewNote(String title, String content) {
		return dao.addNewNote(title, content);
	}

	public Note getNoteById(int id) {
		
		return dao.getNoteById(id);
	}

}
