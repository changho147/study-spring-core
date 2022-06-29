package me.study.studyspringcore.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

    public void execute() {
        long startMs = System.currentTimeMillis();

        call();

        long endMs = System.currentTimeMillis();

        long resultMs = endMs - startMs;
        log.info("resultMs={}", resultMs);
    }

    protected abstract void call();
}
