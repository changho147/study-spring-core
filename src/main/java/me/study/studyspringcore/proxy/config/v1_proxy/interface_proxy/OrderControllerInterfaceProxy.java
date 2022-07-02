package me.study.studyspringcore.proxy.config.v1_proxy.interface_proxy;

import lombok.RequiredArgsConstructor;
import me.study.studyspringcore.proxy.app.v1.OrderControllerV1;
import me.study.studyspringcore.trace.TraceStatus;
import me.study.studyspringcore.trace.logtrace.LogTrace;

@RequiredArgsConstructor
public class OrderControllerInterfaceProxy implements OrderControllerV1 {

    private final OrderControllerV1 orderControllerV1;
    private final LogTrace logTrace;

    @Override
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderRepository.request()");

            String result = orderControllerV1.request(itemId);
            logTrace.end(status);

            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

    @Override
    public String noLog() {
        return orderControllerV1.noLog();
    }
}
