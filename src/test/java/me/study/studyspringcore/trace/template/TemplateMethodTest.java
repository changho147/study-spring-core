package me.study.studyspringcore.trace.template;

import lombok.extern.slf4j.Slf4j;
import me.study.studyspringcore.trace.template.code.AbstractTemplate;
import me.study.studyspringcore.trace.template.code.SubClassLogic1;
import me.study.studyspringcore.trace.template.code.SubClassLogic2;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    public void templateMethodV0() throws Exception {
        logic1();
        logic2();
    }

    @Test
    public void templateMethodV1() throws Exception {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();

        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();
    }

    @Test
    public void templateMethodV2() throws Exception {
        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직1 실행");
            }
        };

        template1.execute();

        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직2 실행");
            }
        };

        template2.execute();
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
