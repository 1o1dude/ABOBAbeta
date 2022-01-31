package io.denery.vadimbin.handlers;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public final class BinHandler {

    public Mono<ServerResponse> startPage(ServerRequest request, Resource html) {
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_HTML)
                .body(BodyInserters.fromResource(html));
    }
}
