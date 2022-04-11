package com.jg.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jg.tech.entity.Contact;
import com.jg.tech.exception.ContactNotFoundException;
import com.jg.tech.service.ContactService;

@RestController
@RequestMapping(value="/contact")
@CrossOrigin("http://localhost:4200")
public class ContactRestController {

	@Autowired
	private ContactService contactService;
	
	@PostMapping(value="/create")
	public ResponseEntity<String> createContact(@RequestBody Contact contact){
		Integer id=contactService.createContact(contact);
		String message="Contact "+id+" Created";
		return new ResponseEntity<String>(message,HttpStatus.OK);
		
	}
	
	@GetMapping(value="/all")
	public ResponseEntity<List<Contact>> findAllContact(){
		List<Contact> list=contactService.findAllContact();
		return new ResponseEntity<List<Contact>>(list,HttpStatus.OK);
		
	}
	@GetMapping(value="/find/{id}")
	public ResponseEntity<?> findOneContact(@PathVariable Integer id){
		
		ResponseEntity<?> resp=null;
		try {
			Contact contact=contactService.findOneContact(id);
			resp=new ResponseEntity<Contact>(contact,HttpStatus.OK);
			
		}catch(ContactNotFoundException e) {
			e.printStackTrace();
			throw e;
			
			
		}
		return resp;
 		
	}
	@PutMapping(value="/modify")
	public ResponseEntity<String> updateOneContact(@RequestBody Contact contact){
		ResponseEntity<String> resp=null;
		try {
			contactService.updateContact(contact);
			resp=new ResponseEntity<String>("Contact Updated ",HttpStatus.OK);
			
		}catch(ContactNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return resp;
		
	}

	@DeleteMapping(value="/remove/{id}")
	public ResponseEntity<String> deleteContact(@PathVariable Integer id){
		ResponseEntity<String> resp=null;
		try {
			contactService.deleteOneContact(id);
			resp=new ResponseEntity<String>("Contact "+id+" Deleted",HttpStatus.OK);
			
		}catch(ContactNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return resp;
	}

}
