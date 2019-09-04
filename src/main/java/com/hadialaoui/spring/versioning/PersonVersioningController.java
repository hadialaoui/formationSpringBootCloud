package com.hadialaoui.spring.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	// URI versioning 
	@GetMapping("/v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("HADI ALAOUI Abdelhakim");
	}
	@GetMapping("/v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("HADI ALAOUI","Abdelhakim"));
	}
	
	//Parametre versioning
	@GetMapping(value = "/person", params = "version=1")
	public PersonV1 getPersonV1Param() {
		return new PersonV1("HADI ALAOUI Abdelhakim");
	}
	@GetMapping(value = "/person", params = "version=2")
	public PersonV2 getPersonV2Param() {
		return new PersonV2(new Name("HADI ALAOUI","Abdelhakim"));
	}
	
	//MEDIA TYPE / HEADER VERSIONING
	@GetMapping(value = "/person", headers = "X-API-VERSION=1")
	public PersonV1 getPersonV1Header() {
		return new PersonV1("HADI ALAOUI Abdelhakim");
	}
	@GetMapping(value = "/person", headers = "X-API-VERSION=2")
	public PersonV2 getPersonV2Header() {
		return new PersonV2(new Name("HADI ALAOUI","Abdelhakim"));
	}
	
	//produces versioning : Accept
	@GetMapping(value = "/person", produces = "application/v1+json")
	public PersonV1 getPersonV1Produces() {
		return new PersonV1("HADI ALAOUI Abdelhakim");
	}
	@GetMapping(value = "/person", produces = "application/v2+json")
	public PersonV2 getPersonV2Produces() {
		return new PersonV2(new Name("HADI ALAOUI","Abdelhakim"));
	}
}
