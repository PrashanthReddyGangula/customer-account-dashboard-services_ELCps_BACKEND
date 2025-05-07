package com.simulation.dashboard_service.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DoctorsPIManipulator2", url = "localhost:8081")
public interface NotificationsServerProxy {
	
	    @GetMapping("/notifications/{doctorId}")
		public List<String> retrieveNotifications(@PathVariable("doctorId") String doctorId);
}
