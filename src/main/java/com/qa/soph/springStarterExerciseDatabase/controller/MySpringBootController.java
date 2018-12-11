package com.qa.soph.springStarterExerciseDatabase.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.soph.springStarterExerciseDatabase.exception.ResourceNotFoundException;
import com.qa.soph.springStarterExerciseDatabase.model.MySpringBootDataModel;
import com.qa.soph.springStarterExerciseDatabase.repository.PersonRepository;

@RestController
@RequestMapping("/api")

public class MySpringBootController {
	
	@Autowired
	PersonRepository myRepository;
	
	// method to create a person
	@PostMapping("/person")
	public MySpringBootDataModel createPerson(@Valid @RequestBody MySpringBootDataModel mSDM) {
		return myRepository.save(mSDM);
	}
	
	// method to get a person
	@GetMapping("/person/{id}")
	public MySpringBootDataModel getPersonbyID(@PathVariable(value = "id")Long personID) {
		return myRepository.findById(personID).orElseThrow(()-> new ResourceNotFoundException("MySpringBootDataModel","id", personID));
	}
	
	//method to get all people
	@GetMapping("/person")
	public List<MySpringBootDataModel> getAllPeople(){
		return myRepository.findAll();
	}
	 
	//method to update a person
	@PutMapping("/person/{id}")
	public MySpringBootDataModel updatePerson(@PathVariable(value = "id") Long personID, @Valid @RequestBody MySpringBootDataModel personDetails) {
		MySpringBootDataModel mSDM = myRepository.findById(personID).orElseThrow(()-> new ResourceNotFoundException ("Person", "id", personID));
		
		mSDM.setName(personDetails.getName());
		mSDM.setAddress(personDetails.getAddress());
		mSDM.setAge(personDetails.getAge());
		
		MySpringBootDataModel updateData = myRepository.save(mSDM);
		return updateData;
	}
	// method to remove a person
	@DeleteMapping("/person/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable(value = "id") Long personID){
		MySpringBootDataModel mSDM = myRepository.findById(personID).orElseThrow(()-> new ResourceNotFoundException ("Person", "id", personID));
	myRepository.delete(mSDM);
	return ResponseEntity.ok().build();
	}
	
	

}
