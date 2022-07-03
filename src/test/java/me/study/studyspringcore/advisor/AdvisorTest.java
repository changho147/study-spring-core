package me.study.studyspringcore.advisor;

import lombok.extern.slf4j.Slf4j;
import me.study.studyspringcore.common.advice.TimeAdvice;
import me.study.studyspringcore.common.service.ServiceImpl;
import me.study.studyspringcore.common.service.ServiceInterface;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import java.lang.reflect.Method;

public class AdvisorTest {
    @Test
    public void advisorTest1() throws Exception {
        ServiceInterface service = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(service);
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor(Pointcut.TRUE, new TimeAdvice());
        proxyFactory.addAdvisor(defaultPointcutAdvisor);

        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        proxy.find();
        proxy.save();
    }

    @Test
    @DisplayName("직접만든 포인트컷")
    public void advisorTest2() throws Exception {
        ServiceInterface service = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(service);
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor(new MyPointCut(), new TimeAdvice());
        proxyFactory.addAdvisor(defaultPointcutAdvisor);

        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        proxy.find();
        proxy.save();
    }

    @Test
    @DisplayName("스프링이 제공하는 포인트컷")
    public void advisorTest3() throws Exception {
        ServiceInterface service = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(service);
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedName("save");

        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor(pointcut, new TimeAdvice());
        proxyFactory.addAdvisor(defaultPointcutAdvisor);

        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        proxy.find();
        proxy.save();
    }

    static class MyPointCut implements Pointcut {

        @Override
        public ClassFilter getClassFilter() {
            return ClassFilter.TRUE;
        }

        @Override
        public MethodMatcher getMethodMatcher() {
            return new MyMethodMatcher();
        }
    }

    @Slf4j
    static class MyMethodMatcher implements MethodMatcher {

        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            String matchName = "save";
            boolean result = method.getName().equals(matchName);
            log.info("포인트컷 호출 method={} targetClass={}", method, targetClass);
            log.info("포인트컷 결과 result={}", result);

            return result;
        }

        @Override
        public boolean isRuntime() {
            return false;
        }

        @Override
        public boolean matches(Method method, Class<?> targetClass, Object... args) {
            return false;
        }
    }
}
