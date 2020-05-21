package com.ibm.healthplanner.service;

import java.util.Optional;

import com.ibm.healthplanner.model.GetPatientResponse;
import com.ibm.healthplanner.model.Patient;

public interface HealthPlannerService {
	
	public void createUser(Patient user);
	
	public GetPatientResponse getAllUser();
	
	public Optional<Patient> findPatientById(String id);
	
	public void update(Patient patient, String id);
	
	public void deleteUserById(String id);
	
}
