/**
 * @ProjectName testconfig <br>
 * @Package: com.suns <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2019-07-01 17:02
 */
package com.suns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @ClassName ConfigServerApp <br>
 * @Description: TODO <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2019-07-01 17:02
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApp {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApp.class,args);
    }
}
