package me.study.studyspringcore.app.v4;

import lombok.RequiredArgsConstructor;
import me.study.studyspringcore.trace.logtrace.LogTrace;
import me.study.studyspringcore.trace.template.AbstractTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

    private final OrderServiceV4 service;
    private final LogTrace trace;

    @GetMapping("/v4/request")
    public String request(String itemId) {
        AbstractTemplate<String> template = new AbstractTemplate<>(trace) {
            @Override
            protected String call() {
                service.orderItem(itemId);

                return "ok";
            }
        };

        return template.execute("OrderController.request()");
    }
}
