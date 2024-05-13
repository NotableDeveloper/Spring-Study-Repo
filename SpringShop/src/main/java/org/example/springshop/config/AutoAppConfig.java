package org.example.springshop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
/*
    같은 패키지 내에 있는 AppConfig를 컴포넌트 스캔의
    대상에서 제외하기 위한 설정.
*/
@ComponentScan(
        excludeFilters = @Filter(type = FilterType.ANNOTATION,
                classes = Configuration.class))
public class AutoAppConfig {

}
