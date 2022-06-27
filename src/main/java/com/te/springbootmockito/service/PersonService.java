package com.te.springbootmockito.service;

import org.springframework.stereotype.Service;

import com.te.springbootmockito.entity.dto.PersonDto;

@Service
public interface PersonService {
	
  public abstract PersonDto getPerson(String personId);
  
  public abstract PersonDto savePerson(PersonDto personDto);
  
  public abstract PersonDto updatePerson(String personId,PersonDto personDto);
  
  public abstract boolean deletePerson(String personId);
  
}
