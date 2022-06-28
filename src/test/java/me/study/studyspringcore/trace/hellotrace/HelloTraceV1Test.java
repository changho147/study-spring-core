package me.study.studyspringcore.trace.hellotrace;

import me.study.studyspringcore.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class HelloTraceV1Test {

    @Test
    public void beginEnd() throws Exception {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");

        trace.end(status);
    }

    @Test
    public void beginEx() throws Exception {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");

        trace.exception(status, new IllegalStateException());
    }
}