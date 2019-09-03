package  com.hadialaoui.spring.Hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;
	
	//@RequestMapping(method = RequestMethod.GET, path = "/helloWorld" )
	@GetMapping (path = "/helloWorld")
	public String helloWorld() {
		return "Hello world";
	}
	
	@GetMapping(path = "/helloWorldBean")
	public HelloBean helloWorldBean() {
		 return new HelloBean("Hello world bean");
	}
	@GetMapping(path = "/helloWorldBean/path-var/{name}")
	public HelloBean helloWorldBeanPathVar(@PathVariable String name) {
		 return new HelloBean(String.format("Hello world bean, %s", name));
	}
	
	@GetMapping(path = "/helloWorldInter")
	public String helloWorldBeaninternationlized(@RequestHeader(name="Accept-Language", required=false) Locale  local) {
		 return messageSource.getMessage("good.morning.message",null, local);
	}
}
