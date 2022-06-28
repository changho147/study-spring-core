package me.study.studyspringcore.app.v2;

import lombok.RequiredArgsConstructor;
import me.study.studyspringcore.trace.TraceId;
import me.study.studyspringcore.trace.TraceStatus;
import me.study.studyspringcore.trace.hellotrace.HelloTraceV2;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {
    private final HelloTraceV2 trace;


    public void save(TraceId traceId, String itemId) {
        TraceStatus status = null;

        try {
            status = trace.beginSync(traceId, "OrderRepository.save()");
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
