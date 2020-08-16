package com.gov.hack.demo.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gov.hack.demo.model.*;

@Repository
public interface VolunteerRepository extends JpaRepository<VolunteerProfile,Integer>{

	List<VolunteerProfile> findByCategory(String category);

	
	

}
