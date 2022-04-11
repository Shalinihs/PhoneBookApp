package com.jg.tech.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jg.tech.entity.Contact;



public interface ContactRepository extends JpaRepository<Contact,Serializable> {
	
//	For Soft delete based on activatewSW yes or no y/n
//	public Contact findByActivateSW(String activateSW);

}