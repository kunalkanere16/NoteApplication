package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.Dao;
import com.domainModel.Note;
import com.services.ServiceImpl;


@Controller
public class MainController {
	private static final Logger logger = Logger.getLogger(MainController.class);

	@Autowired
	private ServiceImpl service;
	
	/**
	 * Redirect to home page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/")
    public String index(ModelMap model) {
        //add attributes to the web page template through the "ModelMap" object.
        

        //This is four different level of logging
        logger.info("Log4j info is working");
        logger.warn("Log4j warn is working");
        logger.debug("Log4j debug is working");
        logger.error("Log4j error is working");
        model.addAttribute("active", 1);
        //This return value indicates to the web page template under directory "webapp/jsp/"
        return "domain/home";
    }
	
	/**
	 * Redirect to home page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/home.page")
    public String home(ModelMap model) {
        //add attributes to the web page template through the "ModelMap" object.
        model.addAttribute("active", 1);
        //This return value indicates to the web page template under directory "webapp/jsp/"
        return "domain/home";
    }
	
	/**
	 * Redirect to view notes list
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/viewNoteList.page")
    public String viewNoteList(ModelMap model) {
        //add attributes to the web page template through the "ModelMap" object.
        model.addAttribute("active",3);
        //System.out.println("here");
        
        //This return value indicates to the web page template under directory "webapp/jsp/"
        return "domain/notesDatatable";
    }
    
    /**
     * Returns note data-table data in JSON format
     * @param request
     * @return
     */
    @RequestMapping(value="/getNoteList.ajax")
    @ResponseBody
    public String getNoteList(HttpServletRequest request){
    	logger.info("notes request data table called........");
    	JSONObject obj=null;
    	try{
    		obj = service.getNoteList(request);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		
        return obj.toString();
	}
    
    /**
     * To redirect to create new note
     * @param model
     * @return
     */
    @RequestMapping(value = "/createNote.page")
    public String createNote(ModelMap model) {
    	model.addAttribute("active", 2);
    	return "domain/createNote";
    }
    
    /**
     * Add new note AJAX call
     * @param request
     * @return
     */
    @RequestMapping(value="/addNote.ajax")
    @ResponseBody
    public String addNote(HttpServletRequest request,
    		@RequestParam("title") String title, @RequestParam("content") String content){
    //	logger.info("adding new note........");
    	String success = service.addNewNote(title, content);
    //	logger.info(" note added?........ = "+success);
        return success;
	}
    
    /**
     * redirect to view note details
     * @param request
     * @return
     */
    @RequestMapping(value="/viewNote.page")
    public String viewNote(HttpServletRequest request,ModelMap model,
    		@RequestParam("id") int id){
    	
    	Note note = service.getNoteById(id);
    //	logger.info("view note........"+note.getId());
    	model.addAttribute("note", note);
    	model.addAttribute("active", 3);
        return "domain/viewNote";
	}
    
    /**
     * Update notes AJAX call
     * @param request
     * @return
     */
    @RequestMapping(value="/updateNote.ajax")
    @ResponseBody
    public String updateNote(HttpServletRequest request,@RequestParam("id") int id,
    		@RequestParam("title") String title, @RequestParam("content") String content){
    //	logger.info("updating note........");
    	String success = service.updateNote(id, title, content);
    //	logger.info(" note update?........ = "+success);
        return success;
	}
    
    /**
     * Delete note AJAX call
     * @param request
     * @return
     */
    @RequestMapping(value="/deleteNote.ajax")
    @ResponseBody
    public String deleteNote(HttpServletRequest request,@RequestParam("id") int id){
    	logger.info("deleting note........");
    	String success = service.deleteNote(id);
    	logger.info(" note delete?........ = "+success);
        return success;
	}
}
