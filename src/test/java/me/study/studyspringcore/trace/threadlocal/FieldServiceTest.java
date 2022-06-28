package me.study.studyspringcore.trace.threadlocal;

import lombok.extern.slf4j.Slf4j;
import me.study.studyspringcore.trace.threadlocal.code.FieldService;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

    private final FieldService service = new FieldService();

    @Test
    public void field() throws Exception {
        log.info("main start");

        Thread threadA = new Thread(() -> service.logic("userA"));
        threadA.setName("thread-A");

        Thread threadB = new Thread(() -> service.logic("userB"));
        threadB.setName("thread-B");

        threadA.start();
        sleep(100);

        threadB.start();
        sleep(2000);

        log.info("main exit");
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
