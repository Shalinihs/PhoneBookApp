package com.jg.tech.service;

import java.util.List;

import com.jg.tech.entity.Contact;

public interface ContactService {
	
public Integer createContact(Contact contact);
	
	public List<Contact> findAllContact();
	
	public Contact findOneContact(Integer id);
	
	public void deleteOneContact(Integer id);
	
	public void updateContact(Contact employee);
	
	int updateContactName(String ename,Long eid);


}

