package com.simulation.dashboard_service.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.simulation.dashboard_service.entity.Details;

@FeignClient(name = "DoctorsPIManipulator", url = "localhost:8081")
public interface DoctorsServerProxy {
	
	    @GetMapping("/doctors/{id}")
		public String retrieveDoctorFullName(@PathVariable("id") String id);
	    
	    @GetMapping("/doctors/details/{id}")
		public Details retrieveDoctorDetails(@PathVariable("id") String id);

}

