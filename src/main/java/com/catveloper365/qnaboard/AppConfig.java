package com.catveloper365.qnaboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Arrays;

/**
 * Application 수동 빈 등록 관리
 */
@Configuration
public class AppConfig {

    private final Environment environment;

    public AppConfig(Environment environment) {
        this.environment = environment;
    }

    /**
     * 주의 : 로컬 개발 단계에서만 확인용으로 사용할 예정, 관리 쉽도록 수동으로 빈 관리
     * 현재 실행된 application-[profile] 정보와 설정 값 확인
     * @return ApplicationRunner
     */
    @Bean
    public ApplicationRunner applicationRunner(){
        return args ->  {
            System.out.println("===================프로파일 실행 정보===================");
            System.out.println("Active profiles : " + Arrays.toString(environment.getActiveProfiles()));
            System.out.println("Server Port : " + environment.getProperty("server.port"));
            System.out.println("Datasource driver : " + environment.getProperty("spring.datasource.driver-class-name"));
            System.out.println("Datasource url : " + environment.getProperty("spring.datasource.url"));
            System.out.println("Datasource username : " + environment.getProperty("spring.datasource.username"));
            System.out.println("Datasource password : " + environment.getProperty("spring.datasource.password"));
            System.out.println("=====================================================");
        };
    }
}
