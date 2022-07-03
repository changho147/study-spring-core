package me.study.studyspringcore.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import me.study.studyspringcore.jdkdynamic.code.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

@Slf4j
public class JdkDynamicProxyTest {

    @Test
    public void dynamicA() throws Exception {
        AInterface target = new AImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        AInterface proxyInstance = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, handler);

        proxyInstance.call();
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxyInstance.getClass());
    }

    @Test
    public void dynamicB() throws Exception {
        BInterface target = new BImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        BInterface proxyInstance = (BInterface) Proxy.newProxyInstance(BInterface.class.getClassLoader(), new Class[]{BInterface.class}, handler);

        proxyInstance.call();
        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxyInstance.getClass());
    }
}
