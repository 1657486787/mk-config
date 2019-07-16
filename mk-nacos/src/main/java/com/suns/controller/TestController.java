/**
 * @ProjectName mk-config <br>
 * @Package: com.suns.controller <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2019-07-16 11:33
 */
package com.suns.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName TestController <br>
 * @Description: TODO <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2019-07-16 11:33
 */
@RestController
public class TestController {


    @RequestMapping("/test")
    public Object test(){
        return new Date();
    }
}
