package com.simpleci.web.service;

import java.time.Duration;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class HelloService {

	public Flux<Integer> getNumber(int bound) {
		final Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));
		final Flux<Integer> integerFlux = Flux.fromStream(IntStream.rangeClosed(0, bound).boxed());
		return Flux.zip(integerFlux, interval, (integer, aLong) -> integer);
	}
}
