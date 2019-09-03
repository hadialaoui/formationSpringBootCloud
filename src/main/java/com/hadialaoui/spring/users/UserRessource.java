package com.hadialaoui.spring.users;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserRessource {

	@Autowired
	private UserDAOService daoService;
	
	@GetMapping("/users")
	public List<User> findAll(){
		return daoService.findAll();
		
	}
	
	@GetMapping("/users/{id}")
	public Resource<User> findOne(@PathVariable int id){
		User user = daoService.findOne(id);
		if(user == null)
			throw new UserNotFoundExeption("id-"+id);
		
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).findAll());
		
		resource.add(linkTo.withRel("all-ussers"));
		return resource;
		
	}
	
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable int id){
		User user = daoService.delete(id);
		if(user == null)
			throw new UserNotFoundExeption("id-"+id);
		
	 }
	
	@PostMapping("/users")
	public ResponseEntity<Object> create(@Valid @RequestBody User user){
		daoService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(location).build(); 
	}
}
