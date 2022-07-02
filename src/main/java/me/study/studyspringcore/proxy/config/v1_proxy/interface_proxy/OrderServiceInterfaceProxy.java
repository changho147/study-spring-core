package me.study.studyspringcore.proxy.config.v1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import me.study.studyspringcore.proxy.app.v1.OrderServiceV1;
import me.study.studyspringcore.trace.TraceStatus;
import me.study.studyspringcore.trace.logtrace.LogTrace;

@RequiredArgsConstructor
public class OrderServiceInterfaceProxy implements OrderServiceV1 {

    private final OrderServiceV1 orderServiceV1;
    private final LogTrace logTrace;

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderService.orderItem()");

            orderServiceV1.orderItem(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);

            throw e;
        }
    }
}
