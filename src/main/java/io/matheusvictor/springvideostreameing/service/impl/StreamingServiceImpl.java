package io.matheusvictor.springvideostreameing.service.impl;

import io.matheusvictor.springvideostreameing.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StreamingServiceImpl implements StreamingService {

    private static final String FORMAT = "classpath:video/%s.mp4";

    private final ResourceLoader resourceLoader;

    public StreamingServiceImpl(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public Mono<Resource> getVideo(String title) {
        return Mono.fromSupplier(() -> resourceLoader.getResource(String.format(FORMAT, title)));
    }
}
