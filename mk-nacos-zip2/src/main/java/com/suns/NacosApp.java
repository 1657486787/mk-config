/**
 * @ProjectName mk-config <br>
 * @Package: com.suns <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2019-07-16 11:32
 */
package com.suns;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName NacosApp <br>
 * @Description: TODO <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2019-07-16 11:32
 */
@NacosPropertySource(dataId = "example",autoRefreshed = true)
@SpringBootApplication
public class NacosApp {

    public static void main(String[] args) {
        SpringApplication.run(NacosApp.class,args);
    }
}
