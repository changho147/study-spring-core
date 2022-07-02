package me.study.studyspringcore.pureproxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeProxy extends ConcreteLogic {

    private ConcreteLogic concreteLogic;

    public TimeProxy(ConcreteLogic concreteLogic) {
        this.concreteLogic = concreteLogic;
    }

    @Override
    public String operation() {
        long startMs = System.currentTimeMillis();
        String result = concreteLogic.operation();
        long endMs = System.currentTimeMillis();

        long resultMs = endMs - startMs;

        log.info("TimeProxy 종료 resultTime={}ms", resultMs);

        return result;
    }
}
