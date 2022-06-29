package me.study.studyspringcore.trace.strategy.code.callback;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {
    public void execute(Callback callback) {
        long startMs = System.currentTimeMillis();

        callback.call();

        long endMs = System.currentTimeMillis();

        long resultMs = endMs - startMs;
        log.info("resultMs={}", resultMs);
    }
}
