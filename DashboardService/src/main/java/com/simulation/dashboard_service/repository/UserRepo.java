package com.simulation.dashboard_service.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.simulation.dashboard_service.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{
	
	User findByUsername(String username);

}
