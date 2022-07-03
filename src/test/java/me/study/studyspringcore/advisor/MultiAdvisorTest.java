package me.study.studyspringcore.advisor;

import lombok.extern.slf4j.Slf4j;
import me.study.studyspringcore.common.advice.TimeAdvice;
import me.study.studyspringcore.common.service.ServiceImpl;
import me.study.studyspringcore.common.service.ServiceInterface;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class MultiAdvisorTest {
    @Test
    @DisplayName("여러 프록시")
    public void multiAdvisorTest1() throws Exception {
        ServiceInterface service = new ServiceImpl();
        ProxyFactory proxyFactory1 = new ProxyFactory(service);
        DefaultPointcutAdvisor defaultPointcutAdvisor1 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice1());
        proxyFactory1.addAdvisor(defaultPointcutAdvisor1);
        ServiceInterface proxy1 = (ServiceInterface) proxyFactory1.getProxy();

        ProxyFactory proxyFactory2 = new ProxyFactory(proxy1);
        DefaultPointcutAdvisor defaultPointcutAdvisor2 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice2());
        proxyFactory2.addAdvisor(defaultPointcutAdvisor2);
        ServiceInterface proxy2 = (ServiceInterface) proxyFactory2.getProxy();

        proxy2.save();
        proxy2.find();
    }

    @Test
    public void multiAdvisorTest2() throws Exception {
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);

        DefaultPointcutAdvisor pointcutAdvisor1 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice1());
        DefaultPointcutAdvisor pointcutAdvisor2 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice2());

        proxyFactory.addAdvisors(pointcutAdvisor1, pointcutAdvisor2);

        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();

        proxy.find();
        proxy.save();
    }

    @Slf4j
    static class Advice1 implements MethodInterceptor {

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            log.info("advice1 호출");
            return invocation.proceed();
        }
    }

    @Slf4j
    static class Advice2 implements MethodInterceptor {

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            log.info("advice2 호출");
            return invocation.proceed();
        }
    }
}
