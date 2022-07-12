package test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/")
	public String sayHello() {
		return "<h1> Welcome to Spring Boot </h1>";
	}
	
	@RequestMapping("/abc")
	public String sayHello1() {
		return "<h2> Hello </h2>";
	}

}