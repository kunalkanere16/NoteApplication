package com.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.domainModel.Note;

public class TestNoteClassProperty {
	
	
	/**
	 * To test property of class Note
	 */
	@Test
	public void testClassProperty() {
		Note note = new Note();
		
		note.setId(1);
		note.setTitle("my title");
		note.setContent("test content");
		
		Assert.assertNotNull(note);
		Assert.assertEquals("my title", note.getTitle());
		Assert.assertEquals("test content", note.getContent());
	}

}
