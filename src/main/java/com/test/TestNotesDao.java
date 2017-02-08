package com.test;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.dao.DaoImpl;
import com.domainModel.Note;

public class TestNotesDao {
	private static EmbeddedDatabase database;
	private static JdbcTemplate jdbcTemplate;

	@BeforeClass
	public static void init() {
	  database = new EmbeddedDatabaseBuilder()
		.setType(EmbeddedDatabaseType.HSQL)
		.addScript("db/sql/create-db.sql")
		.addScript("db/sql/insert-data.sql")
		.build();

	  jdbcTemplate = new JdbcTemplate(database);
	}

	/**
	 * Test to search note by id
	 */
	@Test
	public void testFindNotesById() {
		DaoImpl dao = new DaoImpl();
		dao.setJdbcTemplate(jdbcTemplate);
		Note note = dao.getNoteById(1);
		
		Assert.assertNotNull(note);
		Assert.assertEquals(1, note.getId());
    	Assert.assertEquals("My Story", note.getTitle());
    	

	}
	
	
	/**
	 * Test to add new note
	 */
	@Test
	public void testAddNewNote() {
		DaoImpl dao = new DaoImpl();
		dao.setJdbcTemplate(jdbcTemplate);
		
		String status = dao.addNewNote("title 4", "content 4");
		Note note = dao.getNoteById(4);
		Assert.assertEquals("success", status);
		Assert.assertNotNull(note);
		Assert.assertEquals(4, note.getId());
    	Assert.assertEquals("title 4", note.getTitle());
	}
	
	/**
	 * Test get all notes list
	 */
	@Test
	public void testGetAllNotes() {
		DaoImpl dao = new DaoImpl();
		dao.setJdbcTemplate(jdbcTemplate);
		
		ArrayList<Note> list = dao.getNoteList("", "", " where rownum between 1 and 5");
		Assert.assertEquals(4, list.size());
    	
	}
	
	/**
	 * Test to update note
	 */
	@Test
	public void testUpdateNote() {
		DaoImpl dao = new DaoImpl();
		dao.setJdbcTemplate(jdbcTemplate);
		
		String status = dao.updateNote(2, "update 2", "update content 2");
		Note note = dao.getNoteById(2);
		Assert.assertEquals("success", status);
		Assert.assertNotNull(note);
		Assert.assertEquals(2, note.getId());
    	Assert.assertEquals("update 2", note.getTitle());
	}
	
	/**
	 * Test to delete note
	 */
	@Test
	public void testDeleteNote() {
		DaoImpl dao = new DaoImpl();
		dao.setJdbcTemplate(jdbcTemplate);
		
		String status = dao.deleteNote(3);
		Note note = dao.getNoteById(3);
		Assert.assertEquals("success", status);
		Assert.assertNull(note);
		
	}
	

}
