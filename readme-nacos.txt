nacos
参考官网：https://nacos.io/zh-cn/docs/what-is-nacos.html
快速部署：https://nacos.io/zh-cn/docs/quick-start.html

一、nacos服务运行
1.预备环境准备
    jdk1.8+  maven3.2.x+
2.下载源码或者安装包
    方式一：从 Github 上下载源码方式
        git clone https://github.com/alibaba/nacos.git
        cd nacos/
        mvn -Prelease-nacos clean install -U
        ls -al distribution/target/

        // change the $version to your actual path
        cd distribution/target/nacos-server-$version/nacos/bin
    方式二：您可以从 https://github.com/alibaba/nacos/releases 下载 nacos-server-$version.zip 包
         unzip nacos-server-$version.zip 或者 tar -xvf nacos-server-$version.tar.gz
         cd nacos/bin
3.启动服务器
    linux环境:  sh startup.sh -m standalone
    windows环境:  cmd startup.cmd     或者双击 startup.cmd

    #关闭
    linux环境:  sh shutdown.sh
    windows环境:  cmd shutdown.cmd    或者双击 shutdown.cmd

4.验证：
    访问 http://127.0.0.1:8848/nacos  账号密码：nacos/nacos

二、java客户端（springboot整合nacos）
    1.新建项目mk-nacos
    2.依赖
        <!-- https://mvnrepository.com/artifact/com.alibaba.boot/nacos-config-spring-boot-starter -->
        <dependency>
            <groupId>com.alibaba.boot</groupId>
            <artifactId>nacos-config-spring-boot-starter</artifactId>
            <version>0.2.1</version>
        </dependency>

    3.在application.yml配置文件中增加
        #nacos
        nacos:
          config:
            server-addr: 127.0.0.1:8848
    4.在启动类中增加
        使用 @NacosPropertySource 加载 dataId 为 example 的配置源，并开启自动更新：
        @NacosPropertySource(dataId = "example", autoRefreshed = true)

    5.在ConfigController中定义@NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)

    6.访问：http://localhost:9001/config/get   ==>获取useLocalCache的值
           http://localhost:9001/config/getK1   ==>获取k1的值

    7.单元测试：详见NacosTest

    详见：mk-nacos

