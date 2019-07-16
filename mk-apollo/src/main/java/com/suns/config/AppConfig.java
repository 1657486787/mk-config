package com.suns.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableApolloConfig
@Configuration
public class AppConfig {

  @Bean("configBean")
  public TestJavaConfigBean javaConfigBean() {
    return new TestJavaConfigBean();
  }
}