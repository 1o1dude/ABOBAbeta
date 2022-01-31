package io.denery.vadimbin.routers;


import io.denery.vadimbin.handlers.BinHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class BinRouter {
    @Bean
    public RouterFunction<ServerResponse> route(
            @Value("classpath:/public/index.html") Resource html,
            BinHandler binHandler
    ) {
        return RouterFunctions.route(
                        RequestPredicates.GET("/"),
                        request -> binHandler.startPage(request, html)
                ).andRoute(
                    GET("/about").and(accept(MediaType.TEXT_PLAIN)),
                    serverReq -> ServerResponse.ok()
                            .contentType(MediaType.TEXT_PLAIN)
                            .body(BodyInserters.fromValue("aboba"))
                );
    }
}
