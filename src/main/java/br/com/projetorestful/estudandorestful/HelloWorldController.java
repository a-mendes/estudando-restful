package br.com.projetorestful.estudandorestful;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

private static final String template = "Hello World, %s!";
	
	@RequestMapping("/HelloWorld")
	public HelloWorld helloWorld(@RequestParam(value="name", defaultValue="Ana") String name) {
		return new HelloWorld(String.format(template, name));		
	}
}
