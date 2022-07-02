package me.study.studyspringcore.proxy.config.v1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import me.study.studyspringcore.proxy.app.v1.OrderRepositoryV1;
import me.study.studyspringcore.trace.TraceStatus;
import me.study.studyspringcore.trace.logtrace.LogTrace;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {

    private final OrderRepositoryV1 orderRepositoryV1;
    private final LogTrace logTrace;

    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderRepository.request()");

            orderRepositoryV1.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);

            throw e;
        }
    }
}
