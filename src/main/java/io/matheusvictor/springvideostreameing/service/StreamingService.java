package io.matheusvictor.springvideostreameing.service;

import org.springframework.core.io.Resource;
import reactor.core.publisher.Mono;

public interface StreamingService {

    Mono<Resource> getVideo(String title);
}
