package me.study.studyspringcore.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("TimeProxy 실행");
        long startMs = System.currentTimeMillis();

        Object invoke = invocation.proceed();

        long endMs = System.currentTimeMillis();
        long resultMs = endMs - startMs;
        log.info("TimeProxy 종료 resultMs={}ms", resultMs);

        return invoke;
    }
}
