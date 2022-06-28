package me.study.studyspringcore.app.v1;

import lombok.RequiredArgsConstructor;
import me.study.studyspringcore.trace.TraceStatus;
import me.study.studyspringcore.trace.hellotrace.HelloTraceV1;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {
    private final HelloTraceV1 trace;


    public void save(String itemId) {
        TraceStatus status = null;

        try {
            status = trace.begin("OrderRepository.save()");
            if (itemId.equals("ex"))
                throw new IllegalStateException("예외발생");

            sleep(1000);

            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
