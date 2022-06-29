package me.study.studyspringcore.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import me.study.studyspringcore.trace.strategy.code.strategy.ContextV2;
import me.study.studyspringcore.trace.strategy.code.strategy.Strategy;
import me.study.studyspringcore.trace.strategy.code.strategy.StrategyLogic1;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {
    @Test
    public void strategyV0() throws Exception {
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직3 실행");
            }
        });

        context.execute(() -> log.info("비즈니스 로직4 실행"));
    }
}
