package me.study.studyspringcore.cglib.code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class TimeMethodInterceptor implements MethodInterceptor {
    private final Object target;

    public TimeMethodInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        log.info("Time Proxy 실행");
        long startMs = System.currentTimeMillis();

        Object invoke = methodProxy.invoke(target, args);

        long endMs = System.currentTimeMillis();
        long resultMs = endMs - startMs;
        log.info("TimeProxy 종료 resultMs={}ms", resultMs);

        return invoke;
    }
}
