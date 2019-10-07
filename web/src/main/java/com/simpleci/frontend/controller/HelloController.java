package com.simpleci.frontend.controller;

import com.simpleci.frontend.service.HelloService;
import org.springframework.http.MediaType;
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
		return Mono.just("Hello From WEB");
	}

	@GetMapping(value = "/fluxStream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	private Flux<Integer> getStreamFluxOfNumber(
		@RequestParam(required = false, defaultValue = "2") int b) {
		return helloService.getNumber(b);
	}
}
