/**
 * @ProjectName mk-config <br>
 * @Package: com.suns <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2019-07-16 14:16
 */
package com.suns;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @ClassName NacosTest <br>
 * @Description: TODO <br>
 * @Author sunguangyishenzhenjav@dingtalk.com <br>
 * @Date 2019-07-16 14:16
 */
public class NacosTest {

    private RestTemplate restTemplate = new RestTemplate();

    /**
     * 通过post修改dataId 为 example 的 useLocalCache 为true
     */
    @Test
    public void test1(){
        String url = "http://127.0.0.1:8848/nacos/v1/cs/configs?dataId=example&group=DEFAULT_GROUP&content=useLocalCache=true";
        String result = restTemplate.postForObject(url, null, String.class);
        System.out.println("result:"+result);
    }

    /**
     * 获取nacos中的参数-（通过自己的项目获取参数）,如果nacos服务挂掉，本地还是有缓存的
     */
    @Test
    public void testGet() throws URISyntaxException {
        System.out.println("------------------------------通过自己的项目获取参数------------------------------------");
        System.out.println("------------------------------url------------------------------------");
        String url = "http://localhost:9001/config/get";
        ResponseEntity<String> result = restTemplate.getForEntity(url,String.class);
        System.out.println("result:"+result.getBody());

        System.out.println("------------------------------uri------------------------------------");
        URI uri = new URI(url);
        ResponseEntity<String> forEntity = restTemplate.getForEntity(uri, String.class);
        System.out.println("result2:"+forEntity.getBody());
    }

    /**
     * 获取nacos中的参数-（通过nacos）
     */
    @Test
    public void testGet2() throws URISyntaxException {
        System.out.println("------------------------------通过nacos------------------------------------");

        System.out.println("------------------------------uri------------------------------------");
        String url = "http://127.0.0.1:8848/nacos/v1/cs/configs?dataId=example&group=DEFAULT_GROUP";
        URI uri = new URI(url);
        ResponseEntity<String> forEntity = restTemplate.getForEntity(uri, String.class);
        System.out.println("result:"+forEntity.getBody());
    }


}
