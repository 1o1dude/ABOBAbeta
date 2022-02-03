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
    public Mono<ServerResponse> showSimplePage(ServerRequest request, Resource html) {
        return ServerResponse
                .ok()
                .body(BodyInserters.fromResource(html));
    }

    public Mono<ServerResponse> redirectToAbout(ServerRequest request) {
        return ServerResponse
                .temporaryRedirect(request.uriBuilder().pathSegment("about").build())
                .build();
    }

    public Mono<ServerResponse> saveBin(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_HTML)
                .build();
    }
}
