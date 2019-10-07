package com.simpleci.frontend.controller;

import com.simpleci.frontend.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {

	private HelloService helloService;

	public HelloController(HelloService helloService) {
		this.helloService = helloService;
	}

	@GetMapping
	private Mono<String> getHello() {
		return Mono.just("Hello From FrontEnd");
	}

	@GetMapping(value = "/internal", produces = "text/event-stream")
	private Flux<String> getToInternalService() {
		return helloService.internalServiceCall(2);
	}

	@GetMapping(value = "/external")
	private Mono<String> getToExternalService() {
		return helloService.externalService();
	}
}
