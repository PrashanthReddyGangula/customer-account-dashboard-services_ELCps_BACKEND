package com.simulation.doctors_pi_manipulator.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simulation.doctors_pi_manipulator.persist.entity.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    // No custom methods for now; basic CRUD provided
}