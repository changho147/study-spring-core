package me.study.studyspringcore;

import me.study.studyspringcore.proxy.config.AppV1Config;
import me.study.studyspringcore.proxy.config.AppV2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//@Import(AppV1Config.class)
@Import({AppV1Config.class, AppV2Config.class})
@SpringBootApplication(scanBasePackages = {"me.study.studyspringcore.proxy.app"})
public class StudySpringCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudySpringCoreApplication.class, args);
    }
}
