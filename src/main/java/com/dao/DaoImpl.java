package com.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hsqldb.jdbc.JDBCPreparedStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.domainModel.Note;

@Service("dao")
public class DaoImpl implements Dao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void test() {
		// TODO Auto-generated method stub
		String sql="select * from notes";
		try{
			SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
			while(rs.next()){
				System.out.println("title = "+rs.getString("title"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public ArrayList<Note> getNoteList() {
		String sql="select id, title, content from notes";
		ArrayList<Note> noteList = new ArrayList<Note>();
		try{
			SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
			Note note = null;
			while(rs.next()){
				note = new Note();
				note.setId(rs.getInt("id"));
				note.setTitle(rs.getString("title"));
				note.setContent(rs.getString("content"));
				//System.out.println("title = "+rs.getString("title"));
				noteList.add(note);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return noteList;
	}

	public String addNewNote(final String title, final String content) {
		String sql = "insert into notes (title, content) values (?,?)";
		int create=0;
		
		try{
			
			create=jdbcTemplate.update(sql, new Object[]{title,content});
			
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("create value = "+create);		
		return create==1?"success":"fail";
	}

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
}
