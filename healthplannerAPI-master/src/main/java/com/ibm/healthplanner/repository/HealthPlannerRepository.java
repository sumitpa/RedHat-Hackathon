package com.ibm.healthplanner.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ibm.healthplanner.model.Patient;
import com.ibm.healthplanner.model.PatientName;


@Repository
public interface HealthPlannerRepository extends MongoRepository<Patient, String>{

	public Optional<Patient> findPatientByName(PatientName name);

	
}
