package com.ibm.healthplanner.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.ibm.healthplanner.model.GetPatientResponse;
import com.ibm.healthplanner.model.Patient;
import com.ibm.healthplanner.service.HealthPlannerService;


import io.swagger.annotations.Api;
@RestController
@CrossOrigin(origins="*")
@RequestMapping(value={"/","/healthplanner"})
@Api(value="onlinestore", description="Operations pertaining to Health Advisor")
public class HealthPlannerController {
	
	private static final Logger log = LoggerFactory.getLogger(HealthPlannerController.class);
	
	@Autowired
	HealthPlannerService healthplannerService;
	@GetMapping(value="/",produces = MediaType.APPLICATION_JSON_VALUE)
	public String get(){
		return "Please give url as Spring-Boot-Rest/patient/get";
		
	}
	
    
	 @PostMapping(value="/create/patient",headers="Accept=application/json")
	 public ResponseEntity<?> createUser(@RequestBody Patient patient){
	     
		 log.debug("Creating User {}",patient.getName().getFirstName() + " " + patient.getName().getLastName());
	    
	     healthplannerService.createUser(patient);
	     return new ResponseEntity<>("User " +patient.getName().getFirstName() + " " + patient.getName().getLastName()
	    		 		+ " Created Successfully!!", HttpStatus.CREATED);
	 }

	 @GetMapping(value="/get/patient", headers="Accept=application/json")
	 public GetPatientResponse getAllUser() {		 
		GetPatientResponse patientList = healthplannerService.getAllUser();
		return patientList;
	
	 }
	 
	 @GetMapping(value="/get/patient/{id}", headers="accept=application/json")
	 public Optional<Patient> findPatientById(@PathVariable("id") String id){
		 Optional<Patient> patient= healthplannerService.findPatientById(id);
		 return patient;
	 }

	
	  @PutMapping(value="/update/patient/{id}", headers="Accept=application/json") 
	  public ResponseEntity<Patient> updateUser(@RequestBody Patient currentUser,@PathVariable("id") String id) {
	  
		  log.info("Current UserId is : {} ",currentUser.getId());
		  healthplannerService.update(currentUser, id);
		  return new ResponseEntity<Patient>(HttpStatus.OK); 
	  }
	  
	  @DeleteMapping(value="/delete/patient/{id}", headers ="Accept=application/json") 
	  public ResponseEntity<Patient> deleteUser(@PathVariable("id") String id){
		  
		  log.info(" UserId to delete is : {} ",id);		  
		  healthplannerService.deleteUserById(id);
		  return new ResponseEntity<Patient>(HttpStatus.NO_CONTENT); 
	  }
	 
	
}
