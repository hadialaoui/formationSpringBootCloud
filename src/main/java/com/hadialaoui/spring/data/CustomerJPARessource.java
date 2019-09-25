package com.hadialaoui.spring.data;

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
public class CustomerJPARessource {

	@Autowired
	private CustomerMetierRepository  repositoryService;
	
	@GetMapping(path= "/customers", produces="application/json")
	public List<Customer> findAll(){
		return repositoryService.findAll();
		
	}
	
	@GetMapping("/customers/{id}")
	public Resource<Customer> findOne(@PathVariable int id){
		Optional<Customer> user = repositoryService.findById(id);
		if(!user.isPresent())
			throw new CustomerNotFoundExeption("id-"+id);
		
		Resource<Customer> resource = new Resource<Customer>(user.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).findAll());
		
		resource.add(linkTo.withRel("all-customers"));
		return resource;
		
	}
	
	@DeleteMapping("/customers/{id}")
	public void delete(@PathVariable int id){
		 repositoryService.deleteById(id);
    }
	
	@PostMapping("/customers")
	public ResponseEntity<Object> create(@Valid @RequestBody Customer user){
		repositoryService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(location).build(); 
	}
	
	@GetMapping("/customers/{id}/posts")
	public List<Post> getPostsByUser(@PathVariable int id){
		Optional<Customer> user = repositoryService.findById(id);
		if(!user.isPresent())
			throw new CustomerNotFoundExeption("id-"+id);
		
		
		return user.get().getPosts();
		
	}
}
