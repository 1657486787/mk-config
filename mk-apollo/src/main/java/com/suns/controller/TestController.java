/**
 * @ProjectName apollo-test <br>
 * @Package: com.suns.controller <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2019-07-15 14:50
 */
package com.suns.controller;

import com.suns.config.TestJavaConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName TestController <br>
 * @Description: TODO <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2019-07-15 14:50
 */
@RestController
public class TestController {

    @Qualifier("configBean")
    @Autowired
    private TestJavaConfigBean testJavaConfigBean;


    @RequestMapping("/test")
    public Object test(){
        return new Date();
    }

    @RequestMapping("/apollo")
    public Object apollo(){
        return "apollo:"+testJavaConfigBean.toString();
    }

}
