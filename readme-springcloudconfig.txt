一、spring cloud config
参考：https://www.kancloud.cn/fymod/springcloud2/784134
分为配置中心服务端config-server, 客户端（应用程序）config-client
1.config-server
    1.依赖
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-server</artifactId>
        </dependency>
    2.启动类加上@EnableConfigServer
        @EnableConfigServer
        @SpringBootApplication
        public class ConfigServerApp {public static void main(String[] args) {SpringApplication.run(ConfigServerApp.class,args);}
    3.配置文件application.yml增加：
        spring:
          application:
            name: config-server
          cloud:
            config:
              server:
                git:
                  uri: https://github.com/1657486787/mk-config   或者  https://github.com/1657486787/mk-config.git
                  username:
                  password:

    4.访问：  http://localhost:9001/datasource-dev.yml    或者  http://localhost:9001/datasource/dev

2.config-client
    1.依赖
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
    2.新建配置文件bootstrap.xml,增加如下内容
        spring:
          application:
            #name: config-client
            name: datasource  #注意这里的名字一定要和github上面 datasource-dev.properties 前缀的名称一样，否则会找不到使用的属性值java.lang.IllegalArgumentException: Could not resolve placeholder 'profile' in value "${profile}"
          cloud:
            config:
              uri: http://localhost:9001/
              profile: dev  #指令
              #label: master  #master分支
              label: dev002  #dev分支
              name: ${spring.application.name},redis  #多个配置文件使用,分开
    3.新建项目自己的配置文件applicatin.yml
        server:
          port: 9002
    4.新建测试类，获取git服务器上的属性值如：default.url   redis.host
        @RestController
        public class TestController {

            @GetMapping("/test")
            public Object test(){
                return new Date();
            }

            @Value("${default.url}")
            private String defaultUrl;//对应datasource-${profile}.properties配置文件中的属性

            @GetMapping("/defaultUrl")
            public String getDefaultUrl() {
                return this.defaultUrl;
            }

            @Value("${redis.host}")
            private String redisHost;//对应redis-${profile}.properties配置文件中的属性

            @GetMapping("/redisHost")
            public String redisHost(){
                return redisHost;
            }
        }
    5.访问：   http://localhost:9002/defaultUrl    http://localhost:9002/redisHost

3.动态刷新 config-client-bus
    1.拷贝config-client
    2.增加依赖
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-bus-amqp</artifactId>
        </dependency>
    3.在bootstrap.yml中增加配置
        rabbitmq:
            host: localhost
            port: 5672
            username: guest
            password: guest
    4.在application.yml中增加配置
        management:
          endpoints:
            web:
              exposure:
                include: bus-refresh
    5.修改redis-dev.properties 中redis.host=localhost-refresh-002
    6.使用postman 执行 post方法   http://localhost:9003/actuator/bus-refresh
    7.http://localhost:9003/redisHost
    windows安装rabbitmq参考：https://www.cnblogs.com/5ishare/p/6716142.html