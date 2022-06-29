package me.study.studyspringcore.app.v5;

import me.study.studyspringcore.trace.callback.TraceTemplate;
import me.study.studyspringcore.trace.logtrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 service;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 service, LogTrace trace) {
        this.service = service;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {
        return template.execute("OrderController.request()", () -> {
            service.orderItem(itemId);
            return "ok";
        });
    }
}
