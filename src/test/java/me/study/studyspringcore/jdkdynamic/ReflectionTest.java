package me.study.studyspringcore.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {
    @Test
    public void reflection0() throws Exception {
        Hello target = new Hello();

        //Common Logic1 Start
        log.info("start");
        String result1 = target.callA();
        log.info("result={}", result1);

        //Common Logic2 Start
        log.info("start");
        String result2 = target.callB();
        log.info("result={}", result2);
    }

    @Test
    public void reflection1() throws Exception {
        //클래스 정보
        Class<?> classHello = Class.forName("me.study.studyspringcore.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();

        // 메소드 정보
        Method methodCallA = classHello.getMethod("callA");
        Object result1 = methodCallA.invoke(target);
        log.info("result1={}", result1);

        Method methodCallB = classHello.getMethod("callB");
        Object result2 = methodCallB.invoke(target);
        log.info("result2={}", result2);

    }

    @Test
    public void reflection2() throws Exception {
        //클래스 정보
        Class<?> classHello = Class.forName("me.study.studyspringcore.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();

        // 메소드 정보
        Method methodCallA = classHello.getMethod("callA");
        dynamicCall(methodCallA, target);

        Method methodCallB = classHello.getMethod("callB");
        dynamicCall(methodCallB, target);
    }

    private void dynamicCall(Method method, Object target) throws Exception {
        log.info("start");
        Object invoke = method.invoke(target);
        log.info("result={}", invoke);
    }

    @Slf4j
    static class Hello {
        public String callA() {
            log.info("callA");
            return "A";
        }

        public String callB() {
            log.info("callB");
            return "B";
        }
    }
}
