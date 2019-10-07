package com.simpleci.frontend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HelloService {

    @Value("${internal-uri}")
    private String internalUri;

    @Value("${external-uri}")
    private String externalUri;

    private WebClient webClient;

    public HelloService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Flux<String> internalServiceCall(int bound) {
        return webClient.get().uri(internalUri + "/fluxStream")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .retrieve()
                .bodyToFlux(String.class);
    }

    public Mono<String> externalService() {
        return webClient.get().uri(externalUri).retrieve()
                .bodyToMono(String.class);
    }
}

