package me.study.studyspringcore.app.v4;

import lombok.RequiredArgsConstructor;
import me.study.studyspringcore.trace.logtrace.LogTrace;
import me.study.studyspringcore.trace.template.AbstractTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 repository;
    private final LogTrace trace;

    public void orderItem(String itemId) {
        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                repository.save(itemId);

                return null;
            }
        };

        template.execute("OrderService.orderItem()");
    }
}
