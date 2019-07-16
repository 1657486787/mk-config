/**
 * @ProjectName apollo-test <br>
 * @Package: com.suns <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2019-07-15 14:45
 */
package com.suns;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName ApolloApp <br>
 * @Description: TODO <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2019-07-15 14:45
 */

@EnableApolloConfig
@SpringBootApplication
public class ApolloApp {

    public static void main(String[] args) {
        SpringApplication.run(ApolloApp.class,args);
    }
}
