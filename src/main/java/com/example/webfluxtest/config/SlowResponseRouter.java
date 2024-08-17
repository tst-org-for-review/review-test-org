package com.example.webfluxtest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * Router for slow responses.
 * Response time could be up to 4 seconds and determined randomly.
 * Average response time - 2 seconds
 */
@Configuration
public class SlowResponseRouter {

    @Bean
    public RouterFunction<ServerResponse> routes() {
        return RouterFunctions.route(RequestPredicates.GET("/test"), request ->
                Mono.delay(Duration.ofSeconds(4))
                        .then(ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).bodyValue("OK"))
        );
        // ㅅㅁㄴㅅㅁㄴㅅ
        // ㄴㅅㄴㅅ
    }

}