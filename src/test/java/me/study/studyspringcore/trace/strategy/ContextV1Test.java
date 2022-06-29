package me.study.studyspringcore.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import me.study.studyspringcore.trace.strategy.code.strategy.ContextV1;
import me.study.studyspringcore.trace.strategy.code.strategy.Strategy;
import me.study.studyspringcore.trace.strategy.code.strategy.StrategyLogic1;
import me.study.studyspringcore.trace.strategy.code.strategy.StrategyLogic2;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {
    @Test
    public void strategyV0() throws Exception {
        logic1();
        logic2();
    }

    @Test
    public void strategyV1() throws Exception {
        ContextV1 context1 = new ContextV1(new StrategyLogic1());
        context1.execute();

        ContextV1 context2 = new ContextV1(new StrategyLogic2());
        context2.execute();
    }

    @Test
    public void strategyV2() throws Exception {
        Strategy logic1 = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        };

        ContextV1 context1 = new ContextV1(logic1);
        context1.execute();

        Strategy logic2 = () -> log.info("비즈니스 로직2 실행");
        ContextV1 context2 = new ContextV1(logic1);
        context2.execute();
    }

    @Test
    public void strategyV3() throws Exception {
        ContextV1 context1 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });
        context1.execute();

        ContextV1 context2 = new ContextV1(() -> log.info("비즈니스 로직2 실행"));
        context2.execute();
    }

    private void logic1() {
        long startMs = System.currentTimeMillis();

        log.info("비즈니스 로직1 실행");

        long endMs = System.currentTimeMillis();

        long resultMs = endMs - startMs;
        log.info("resultMs={}", resultMs);
    }

    private void logic2() {
        long startMs = System.currentTimeMillis();

        log.info("비즈니스 로직2 실행");

        long endMs = System.currentTimeMillis();

        long resultMs = endMs - startMs;
        log.info("resultMs={}", resultMs);
    }
}
