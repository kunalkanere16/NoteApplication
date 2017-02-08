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
	
	/**
	 * Datatable service
	 */
	public JSONObject getNoteList(HttpServletRequest request) {
		JSONObject obj=new JSONObject();
		ArrayList<Note> noteList = null;
		try{
			String[] columnSearch = {"title", "content"};
			
		    String[] columnSort = {"title", "content"};
		    
			String wherePart="", orderByPart="", rowNumPart="";
			
			//for datatable internal
			String startStr = request.getParameter("iDisplayStart");
			int start = -1;
			if(startStr != null)
				start = Integer.parseInt(startStr);
			
			int noOfRecords = Integer.parseInt(request.getParameter("iDisplayLength"));
			
			if(startStr != null && noOfRecords != -1)
			{
				rowNumPart = "where rownum between "+(start + 1)+" and "+(start+noOfRecords);
			}
			
			// sorting part
			
			if(request.getParameter("iSortCol_0") != null)
			{
				orderByPart = " ORDER BY ";
				
				//System.out.println("no of sortable columns are "+request.getParameter("iSortingCols"));
				for(int i = 0;i< Integer.parseInt(request.getParameter("iSortingCols"));i++)
				{
					
					if(request.getParameter("bSortable_"+Integer.parseInt(request.getParameter("iSortCol_"+i))).equals("true") )
					{
						orderByPart+= columnSort[Integer.parseInt(request.getParameter("iSortCol_"+i))]+" "+request.getParameter("sSortDir_"+i)+" ";
	                }
		        }
			}
			
			//search part
			
			if(!request.getParameter("sSearch").equals(""))
			{
				wherePart += " and ( ";
				for(int i = 0;i<columnSearch.length;i++)
				{
					wherePart+=" lower("+columnSearch[i]+") LIKE '%"+request.getParameter("sSearch").toLowerCase()+"%' OR ";
				}
				wherePart = wherePart.substring(0,wherePart.length()-3);
				wherePart+=") ";
			}
			
			//total records
			int echo = Integer.parseInt(request.getParameter("sEcho"));
			int totalRecords = 1;
			totalRecords = dao.getNotesCount("");
			obj.put("sEcho",new Integer(echo));
			obj.put("iTotalRecords",new Integer(totalRecords));
			
			noteList = dao.getNoteList(wherePart, orderByPart, rowNumPart);
			System.out.println("list size = "+noteList.size());
			JSONArray parentObj = new JSONArray();
			JSONArray childList = null;
			for(int i=0; i<noteList.size(); i++){
				childList = new JSONArray();
				childList.put(noteList.get(i).getTitle());
				childList.put(noteList.get(i).getContent());
				childList.put("<a href='viewNote.page?id="+noteList.get(i).getId()+"'>Edit</a> / <a href='javascript:deleteNote("+noteList.get(i).getId()+")'>Delete</a>");
				parentObj.put(childList);
			}
			obj.put("aaData", parentObj);
			
			//filtered records
			int totalFilteredRecords = 0;
			if(!wherePart.equals("") ){
				totalFilteredRecords = dao.getNotesCount(wherePart);
			}else{
				totalFilteredRecords = totalRecords;
			}
			obj.put("iTotalDisplayRecords",new Integer(totalFilteredRecords));
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * add new note service
	 */
	public String addNewNote(String title, String content) {
		return dao.addNewNote(title, content);
	}
	/**
	 * update note by ID service
	 */
	public String updateNote(int id, String title, String content) {
		return dao.updateNote(id,title, content);
	}
	/**
	 * Get note object by ID service
	 */
	public Note getNoteById(int id) {
		
		return dao.getNoteById(id);
	}
	/**
	 * Delete note by ID service
	 */
	public String deleteNote(int id) {
		return dao.deleteNote(id);
	}

}
