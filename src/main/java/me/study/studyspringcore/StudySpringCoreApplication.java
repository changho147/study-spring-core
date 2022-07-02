package me.study.studyspringcore;

import me.study.studyspringcore.proxy.config.v1_proxy.ConcreteProxyConfig;
import me.study.studyspringcore.trace.logtrace.LogTrace;
import me.study.studyspringcore.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(AppV1Config.class)
//@Import({AppV1Config.class, AppV2Config.class}
//@Import(InterfaceProxyConfig.class)
@Import(ConcreteProxyConfig.class)
@SpringBootApplication(scanBasePackages = {"me.study.studyspringcore.proxy.app"})
public class StudySpringCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudySpringCoreApplication.class, args);
    }

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
