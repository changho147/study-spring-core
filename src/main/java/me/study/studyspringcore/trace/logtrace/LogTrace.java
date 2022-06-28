package me.study.studyspringcore.trace.logtrace;

import me.study.studyspringcore.trace.TraceStatus;

public interface LogTrace {
    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);
}
