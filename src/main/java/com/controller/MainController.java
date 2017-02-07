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
import com.dao.DaoImpl;
import com.domainModel.Note;
import com.services.ServiceImpl;


@Controller
public class MainController {
	private static final Logger logger = Logger.getLogger(MainController.class);

	@Autowired
	private ServiceImpl service;
	
	@RequestMapping(value = "/")
    public String index(ModelMap model) {
        //add attributes to the web page template through the "ModelMap" object.
        model.addAttribute("message", "My Notes");
        //System.out.println("here");
        //This is four different level of logging
        logger.info("Log4j info is working");
        logger.warn("Log4j warn is working");
        logger.debug("Log4j debug is working");
        logger.error("Log4j error is working");
        //This return value indicates to the web page template under directory "webapp/jsp/"
        return "domain/notesDatatable";
    }
	
    @RequestMapping(value = "/viewNoteList.page")
    public String viewNoteList(ModelMap model) {
        //add attributes to the web page template through the "ModelMap" object.
        model.addAttribute("message", "My Notes");
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
     * To redirect to view list of doctor requests in table format
     * @param model
     * @return
     */
    @RequestMapping(value = "/createNote.page")
    public String createNote(ModelMap model) {
    	
    	return "domain/createNote";
    }
    
    /**
     * 
     * @param request
     * @return
     */
    @RequestMapping(value="/addNote.ajax")
    @ResponseBody
    public String addNote(HttpServletRequest request,
    		@RequestParam("title") String title, @RequestParam("content") String content){
    	logger.info("adding new note........");
    	String success = service.addNewNote(title, content);
    	logger.info(" note added?........ = "+success);
        return success;
	}
    
    /**
     * 
     * @param request
     * @return
     */
    @RequestMapping(value="/viewNote.page")
    public String viewNote(HttpServletRequest request,ModelMap model,
    		@RequestParam("id") int id){
    	
    	Note note = service.getNoteById(id);
    	logger.info("view note........"+note.getId());
    	model.addAttribute("note", note);
        return "domain/viewNote";
	}
}
