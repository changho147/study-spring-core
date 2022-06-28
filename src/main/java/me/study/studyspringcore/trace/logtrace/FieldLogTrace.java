package me.study.studyspringcore.trace.logtrace;

import lombok.extern.slf4j.Slf4j;
import me.study.studyspringcore.trace.TraceId;
import me.study.studyspringcore.trace.TraceStatus;

@Slf4j
public class FieldLogTrace implements LogTrace {
    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX = "<X-";

    private TraceId traceIdHolder;

    @Override
    public TraceStatus begin(String message) {
        syncTraceId();

        TraceId traceId = traceIdHolder;
        long startTimeMs = System.currentTimeMillis();

        log.info("[{}] {}{}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message);

        return new TraceStatus(traceId, startTimeMs, message);
    }

    @Override
    public void end(TraceStatus status) {
        complete(status, null);
    }

    @Override
    public void exception(TraceStatus status, Exception e) {
        complete(status, e);
    }

    private void complete(TraceStatus status, Exception e) {
        Long stopTimeMs = System.currentTimeMillis();
        long resultTimeMs = stopTimeMs - status.getStartTimeMs();
        TraceId traceId = status.getTraceId();

        if (e == null)
            log.info("[{}] {}{} time={}ms", traceId.getId(), addSpace(COMPLETE_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs);
        else
            log.info("[{}] {}{} time={}ms ex={}", traceId.getId(), addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(), resultTimeMs, e.getClass());

        releaseTraceId();
    }

    private void syncTraceId() {
        if (traceIdHolder == null)
            traceIdHolder = new TraceId();
        else
            traceIdHolder = traceIdHolder.createNextId();
    }

    private void releaseTraceId() {
        if (traceIdHolder.isFirstLevel())
            traceIdHolder = null;
        else
            traceIdHolder = traceIdHolder.createPrevId();
    }

    private static String addSpace(String prefix, int level) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < level; i++)
            stringBuilder.append((i == level - 1) ? "|" + prefix : "|   ");

        return stringBuilder.toString();
    }
}
