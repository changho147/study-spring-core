package me.study.studyspringcore.app.v3;

import lombok.RequiredArgsConstructor;
import me.study.studyspringcore.trace.TraceStatus;
import me.study.studyspringcore.trace.logtrace.LogTrace;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {
    private final LogTrace trace;


    public void save(String itemId) {
        TraceStatus status = null;

        try {
            status = trace.begin("OrderRepository.save()");
            if (itemId.equals("ex"))
                throw new IllegalStateException("μμΈλ°μ");

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
