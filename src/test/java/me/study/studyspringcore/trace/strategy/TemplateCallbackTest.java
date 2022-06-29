package me.study.studyspringcore.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import me.study.studyspringcore.trace.strategy.code.callback.Callback;
import me.study.studyspringcore.trace.strategy.code.callback.TimeLogTemplate;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {
    @Test
    public void callbackV1() throws Exception {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(new Callback() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });
    }

    @Test
    public void callbackV2() throws Exception {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(() -> log.info("비즈니스 로직1 실행"));
    }

}
