package com.jg.tech.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jg.tech.entity.Contact;
import com.jg.tech.exception.ContactNotFoundException;
import com.jg.tech.repository.ContactRepository;
import com.jg.tech.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public Integer createContact(Contact contact) {
		contact=contactRepo.save(contact);
		return contact.getContactId();
	}

	@Override
	public List<Contact> findAllContact() {
		
//		contactRepo.findByActivateSW("Y");
		
		
		List<Contact> list=contactRepo.findAll();
		return list;
	}

	@Override
	public Contact findOneContact(Integer id) {
		Optional<Contact> opt=contactRepo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new ContactNotFoundException("Contact "+id+" not exist");
		}
		
	}

	@Override
	public void deleteOneContact(Integer id) {
//		For Soft Delete
		
//		Contact contact=contactRepo.findById(id).get();
//		contact.setActivateSW("N");
//		contactRepo.save(contact);
//		
		contactRepo.delete(findOneContact(id));
		
	}

	@Override
	public void updateContact(Contact contact) {
		Integer id=contact.getContactId();
		if(id!=null && contactRepo.existsById(id)) {
			contactRepo.save(contact);
		}else {
			throw new ContactNotFoundException("Contact "+id+" Does not exist");
		
		}
		
	}

	@Override
	public int updateContactName(String ename, Long eid) {
		//Todo
		return 0;
	}

	

}
