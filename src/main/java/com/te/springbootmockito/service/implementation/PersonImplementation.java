package com.te.springbootmockito.service.implementation;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.te.springbootmockito.entity.Person;
import com.te.springbootmockito.entity.dto.PersonDto;
import com.te.springbootmockito.repository.PersonRepository;
import com.te.springbootmockito.service.PersonService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonImplementation implements PersonService {

	public final PersonRepository personRepository;

	@Override
	public PersonDto getPerson(String personId) {
		PersonDto personDto = new PersonDto();
		BeanUtils.copyProperties(personRepository.findById(personId), personDto);
		return personDto;
	}

	@Override
	public PersonDto savePerson(PersonDto personDto) {
		Person person = new Person();
		BeanUtils.copyProperties(personDto, person);
		personRepository.save(person);
		return personDto;
	}

	@Override
	public PersonDto updatePerson(String personId, PersonDto personDto) {
		Optional<Person> optional = personRepository.findById(personId);
		if (optional.isPresent()) {
			Person person = optional.get();
			BeanUtils.copyProperties(personDto, person);
			personRepository.save(person);
		}
		return null;
	}

	@Override
	public boolean deletePerson(String personId) {
		Optional<Person> optional = personRepository.findById(personId);
		if(optional.isPresent()) {
			Person person = optional.get();
			personRepository.delete(person);
			return true;
		}
		return false;
	}

}
