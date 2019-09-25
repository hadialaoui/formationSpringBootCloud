package com.hadialaoui.spring.data;

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
public class CustomerRessource {

	@Autowired
	private CustomerDAOService daoService;
	
	@GetMapping(path= "/customers", produces="application/json")
	public List<Customer> findAll(){
		return daoService.findAll();
		
	}
	
	@GetMapping("/customers/{id}")
	public Resource<Customer> findOne(@PathVariable int id){
		Customer user = daoService.findOne(id);
		if(user == null)
			throw new CustomerNotFoundExeption("id-"+id);
		
		Resource<Customer> resource = new Resource<Customer>(user);
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).findAll());
		
		resource.add(linkTo.withRel("all-ussers"));
		return resource;
		
	}
	
	@DeleteMapping("/customers/{id}")
	public void delete(@PathVariable int id){
		Customer user = daoService.delete(id);
		if(user == null)
			throw new CustomerNotFoundExeption("id-"+id);
		
	 }
	
	@PostMapping("/customers")
	public ResponseEntity<Object> create(@Valid @RequestBody Customer user){
		daoService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(location).build(); 
	}
}
