package me.study.studyspringcore.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV1 {
    private final Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        long startMs = System.currentTimeMillis();

        strategy.call();

        long endMs = System.currentTimeMillis();

        long resultMs = endMs - startMs;
        log.info("resultMs={}", resultMs);
    }
}
