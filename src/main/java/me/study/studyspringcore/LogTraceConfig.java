package me.study.studyspringcore;

import me.study.studyspringcore.trace.logtrace.LogTrace;
import me.study.studyspringcore.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
