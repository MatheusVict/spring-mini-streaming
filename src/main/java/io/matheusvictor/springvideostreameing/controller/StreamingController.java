package io.matheusvictor.springvideostreameing.controller;

import io.matheusvictor.springvideostreameing.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class StreamingController {

    private final StreamingService streamingService;

    public StreamingController(StreamingService streamingService) {
        this.streamingService = streamingService;
    }

    @GetMapping(value = "video/{title}", produces = "video/mp4")
    public Mono<Resource> getVideos(@PathVariable String title, @RequestHeader("Range") String range) {
        System.out.println("range in bytes: " + range);
        System.out.println("title of video: " + title);
        return streamingService.getVideo(title);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
