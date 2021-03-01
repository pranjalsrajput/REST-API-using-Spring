package com.rest.restservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.restservice.GraphUtilities.GraphInput;
import com.rest.restservice.algorithm01.Algorithm01Main;
import com.rest.restservice.algorithm02.Algorithm02;

@RestController
public class TaskController {
	


//	private static final String template = "Hello, %s!";
//	private final AtomicLong counter = new AtomicLong();

//	@GetMapping("/greetings")
//	public Greeting greetings(@RequestParam(value = "name", defaultValue = "World") String name) {
//		return new Greeting(counter.incrementAndGet(), String.format(template, name));
//	}
	
	@PostMapping("/greeting")
	public String[][] greeting(@RequestParam(value="ids", defaultValue="{}") String[][] idsf) {
		return idsf;
	}
	
	@PostMapping("/algorithm01")
	public String algorithm01(@RequestBody GraphInput input) {
		var result = "";
		try {
			System.out.println(input.toString());
			var graphInput = new GraphInput(input.getInputArray(), input.getNodePair());
			graphInput = graphInput.processInput(graphInput);
			var algorithm01 = new Algorithm01Main();
			result = algorithm01.main(graphInput);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	@PostMapping("/algorithm02")
	public boolean algorithm02(@RequestBody GraphInput input) {
		var result = false;
		try {
			System.out.println(input.toString());
			var graphInput = new GraphInput(input.getInputArray(), input.getNodePair());
			graphInput = graphInput.processInput(graphInput);
			var algorithm02 = new Algorithm02();
			result = algorithm02.main(graphInput);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
//	@PostMapping("/algorithm01")
//	public String algorithm01Post(@RequestParam(value = "input", defaultValue = "{}") String input) {
//		
//		return new Greeting(counter.incrementAndGet(), input));
//	}

}
