package com.example.foo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hellow, %s!";
	private static final String template2 = "teste %s";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
	public Greeting greeting (@RequestParam(value="name", defaultValue = "Word") String name, 
			@RequestParam(value="name2", defaultValue = "Word2") String name2) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name), String.format(template2, name2));
	}
	
}
