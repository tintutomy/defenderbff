package com.gov.hack.dao;
import com.gov.hack.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
public interface VolunteerRepository extends JpaRepository<VolunteerProfile,Integer>{

	List<VolunteerProfile> findByCategory(String category);

	
	

}
