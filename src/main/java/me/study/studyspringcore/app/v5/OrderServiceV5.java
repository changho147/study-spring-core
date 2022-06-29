package me.study.studyspringcore.app.v5;

import me.study.studyspringcore.trace.callback.TraceTemplate;
import me.study.studyspringcore.trace.logtrace.LogTrace;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 repository;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 repository, LogTrace trace) {
        this.repository = repository;
        this.template = new TraceTemplate(trace);
    }


    public void orderItem(String itemId) {
        template.execute("OrderService.orderItem()", () -> {
            repository.save(itemId);

            return null;
        });
    }
}
