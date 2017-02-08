package com.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.domainModel.Note;

@Service("dao")
public class DaoImpl implements Dao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**
	 * Get List of notes
	 */
	public ArrayList<Note> getNoteList(String wherePart, String orderByPart, String rowNumPart) {
		String sql="select * from ( "
				+ "select  id, title, content ,  ROWNUM() as rownum from notes "
				+ " where 1=1 "+wherePart+" "+orderByPart+ " ) x "+rowNumPart;
		ArrayList<Note> noteList = new ArrayList<Note>();
		try{
			SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
			Note note = null;
			while(rs.next()){
				note = new Note();
				note.setId(rs.getInt("id"));
				
				note.setTitle(rs.getString("title"));
				String temp = rs.getString("content");
				note.setContent(temp.length()>30?temp.substring(0, 29)+"...":temp);
				//System.out.println("title = "+rs.getString("title"));
				noteList.add(note);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return noteList;
	}
	
	/**
	 * Create new note
	 */
	public String addNewNote(final String title, final String content) {
		String sql = "insert into notes (title, content) values (?,?)";
		int create=0;
		
		try{
			
			create=jdbcTemplate.update(sql, new Object[]{title,content});
			
		}catch(Exception e){
			e.printStackTrace();
		}
	//	System.out.println("create value = "+create);		
		return create==1?"success":"fail";
	}

	/**
	 * Get note details by ID
	 */
	public Note getNoteById(int id) {
		String sql = "select id, title, content from notes where id = ?";
		Note note = null;
		try{
			SqlRowSet rs = jdbcTemplate.queryForRowSet(sql,new Object[]{id});
			
			if(rs.next()){
				note = new Note();
				note.setId(rs.getInt("id"));
				note.setTitle(rs.getString("title"));
				note.setContent(rs.getString("content"));
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return note;
	}

	/**
	 * Update note by ID
	 */
	public String updateNote(int id, String title, String content) {
		String sql = "update notes set title = ?, content = ? where id = ?";
		int update=0;
		
		try{
			
			update=jdbcTemplate.update(sql, new Object[]{title,content, id});
			
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("update value = "+update);		
		return update==1?"success":"fail";
	}

	/**
	 * Delete note by ID
	 */
	public String deleteNote(int id) {
		String sql = "delete from notes where id = ?";
		int delete=0;
		
		try{
			
			delete=jdbcTemplate.update(sql, new Object[]{id});
			
		}catch(Exception e){
			e.printStackTrace();
		}
	//	System.out.println("create value = "+delete);		
		return delete==1?"success":"fail";
	}

	public int getNotesCount(String wherePart) {
		int count=0;
		String sql= "select count(*) totalCount from notes where 1=1 "+wherePart;
//		System.out.println("getDoctorCount sql = "+sql);
		try{
			count = jdbcTemplate.queryForInt(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
}
