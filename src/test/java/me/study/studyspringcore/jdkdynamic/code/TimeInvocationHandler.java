package me.study.studyspringcore.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class TimeInvocationHandler implements InvocationHandler {
    private final Object target;

    public TimeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("Time Proxy 실행");
        long startMs = System.currentTimeMillis();

        Object invoke = method.invoke(target, args);

        long endMs = System.currentTimeMillis();
        long resultMs = endMs - startMs;
        log.info("TimeProxy 종료 resultMs={}ms", resultMs);

        return invoke;
    }
}
