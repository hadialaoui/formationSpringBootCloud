package com.hadialaoui.spring.users;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/jpa")
public class UserJPARessource {

	@Autowired
	private UserRepository  repositoryService;
	
	@GetMapping(path= "/users", produces="application/json")
	public List<Utilisateur> findAll(){
		return repositoryService.findAll();
		
	}
	
	@GetMapping("/users/{id}")
	public Resource<Utilisateur> findOne(@PathVariable int id){
		Optional<Utilisateur> user = repositoryService.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundExeption("id-"+id);
		
		Resource<Utilisateur> resource = new Resource<Utilisateur>(user.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).findAll());
		
		resource.add(linkTo.withRel("all-ussers"));
		return resource;
		
	}
	
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable int id){
		 repositoryService.deleteById(id);
    }
	
	@PostMapping("/users")
	public ResponseEntity<Object> create(@Valid @RequestBody Utilisateur user){
		repositoryService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(location).build(); 
	}
	
	@GetMapping("/users/{id}/posts")
	public List<Post> getPostsByUser(@PathVariable int id){
		Optional<Utilisateur> user = repositoryService.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundExeption("id-"+id);
		
		
		return user.get().getPosts();
		
	}
}
