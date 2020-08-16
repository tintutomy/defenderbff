package com.gov.hack.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gov.hack.dao.VolunteerRepository;
import com.gov.hack.model.VolunteerProfile;

@RestController
public class DisasterResponseController {
	//one event for registration
	// event for sending the message - (send message to people under category message)
	@Autowired
	private VolunteerRepository repository;
	@PostMapping("/saveVolunteerDetails")
	public String saveVoluteerDetails(@RequestBody VolunteerProfile volunteerProfile)
	{
		repository.save(volunteerProfile);
		return "Volunteer Information saved";
	}
	@GetMapping("/getAllVoluteerInfo")
	public List<VolunteerProfile> getAll()
	{
		return repository.findAll();
		 
	}
	@GetMapping("/getAllVoluteersByCategory")
	public List<VolunteerProfile> getVolunteerByCategory(@PathVariable String category)
	{
		return repository.findByCategory(category);
		 
	}
	

}
