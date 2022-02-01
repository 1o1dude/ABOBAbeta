package io.denery.vadimbin.routers;

import io.denery.vadimbin.handlers.BinHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration(proxyBeanMethods = false)
public class BinRouter {
    private static final Logger logger = LoggerFactory.getLogger("VadimBin");

    @Bean
    public RouterFunction<ServerResponse> route(
            @Value("classpath:/public/index.html") Resource index,
            @Value("classpath:/public/edit-page.html") Resource edit,
            BinHandler binHandler
    ) {
        return RouterFunctions.route(
                        RequestPredicates.GET("/"),
                        binHandler::redirectToAbout
                ).andRoute(
                        RequestPredicates.GET("/about"),
                        request -> binHandler.showSimplePage(request, index)
                ).andRoute(
                        RequestPredicates.GET("/edit"),
                        request -> binHandler.showSimplePage(request, edit)
                ).andRoute(
                        RequestPredicates.POST("/edit"),
                        request -> ServerResponse.ok().build(s -> {
                            logger.info("POST Test request: " + request.path());
                            s.onComplete();
                        })
                );
    }
}
