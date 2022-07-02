package com.te.springbootmockito.service.implementation;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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
		Optional<Person> findById = personRepository.findById(personId);
		if (findById.isPresent()) {
			PersonDto personDto = new PersonDto();
			Person person = findById.get();
			BeanUtils.copyProperties(person, personDto);
			return personDto;
		}
		return null;
	}

	@Override
	public PersonDto savePerson(PersonDto personDto) {
		Person person = new Person();
		BeanUtils.copyProperties(personDto, person);
		personRepository.save(person);
		BeanUtils.copyProperties(person, personDto);
		return personDto;
	}

	@Override
	public PersonDto updatePerson(String personId, PersonDto personDto) {
		Optional<Person> optional = personRepository.findById(personId);
		if (optional.isPresent()) {
			Person person = optional.get();
			BeanUtils.copyProperties(personDto, person);
			person= personRepository.save(person);
			BeanUtils.copyProperties(person, personDto);
			return personDto;
		}
		return null;
	}

	@Override
	public boolean deletePerson(String personId) {
		Optional<Person> optional = personRepository.findById(personId);
		if (optional.isPresent()) {
			Person person = optional.get();
			personRepository.delete(person);
			return true;
		}
		return false;
	}
}
