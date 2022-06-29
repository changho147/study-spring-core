package me.study.studyspringcore.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2 {
    public void execute(Strategy strategy) {
        long startMs = System.currentTimeMillis();

        strategy.call();

        long endMs = System.currentTimeMillis();

        long resultMs = endMs - startMs;
        log.info("resultMs={}", resultMs);
    }
}
