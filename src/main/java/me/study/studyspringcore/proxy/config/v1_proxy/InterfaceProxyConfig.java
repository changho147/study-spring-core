package me.study.studyspringcore.proxy.config.v1_proxy;

import me.study.studyspringcore.proxy.app.v1.*;
import me.study.studyspringcore.proxy.config.v1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import me.study.studyspringcore.proxy.config.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import me.study.studyspringcore.proxy.config.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import me.study.studyspringcore.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {

    @Bean
    public OrderControllerV1 orderController(LogTrace logTrace) {
        return new OrderControllerInterfaceProxy(new OrderControllerV1Impl(orderService(logTrace)), logTrace);
    }

    @Bean
    public OrderServiceV1 orderService(LogTrace logTrace) {
        return new OrderServiceInterfaceProxy(new OrderServiceV1Impl(orderRepository(logTrace)), logTrace);
    }

    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace logTrace) {
        return new OrderRepositoryInterfaceProxy(new OrderRepositoryV1Impl(), logTrace);
    }
}
