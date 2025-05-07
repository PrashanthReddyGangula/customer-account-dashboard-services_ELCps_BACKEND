package com.simulation.doctors_pi_manipulator.persist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simulation.doctors_pi_manipulator.persist.entity.Details;

@Repository
public interface DoctorsRepository extends JpaRepository<Details, String> {
	
	//@Query("SELECT d FROM Details d WHERE (SELECT COUNT(a) FROM Activity a WHERE a.doctorId = d.id) > 3")
	//@Query("SELECT d FROM Details d JOIN d.Activity a GROUP BY d.id HAVING COUNT(a) > 3")
	@Query("SELECT d FROM Details d JOIN Activity a ON d.id = a.doctorId GROUP BY d HAVING COUNT(a) >= 3")
	//@Query("SELECT d FROM Details d")
    List<Details> findDoctorsWithActivitiesAboveThreshold();

}

