apollo
参考官网：https://github.com/ctripcorp/apollo
快速部署：https://github.com/ctripcorp/apollo/wiki/Quick-Start

一、准备工作
    1.Java:最好jdk1.8
    2.mysql:需要5.6.5以上
    3.下载Quick Start安装包
        从github下载：https://github.com/nobodyiam/apollo-build-scripts
        网盘下载较快：https://pan.baidu.com/s/1HSRkhM8bieYKJV4PEY2DBA  （提取码: 8eh3）  下载到本地后，在本地解压apollo-quick-start.zip
二、安装步骤
    1.创建数据库
        Apollo服务端共需要两个数据库：ApolloPortalDB和ApolloConfigDB，我们把数据库、表的创建和样例数据都分别准备了sql文件，只需要导入数据库即可。
        执行 sql/apolloportaldb.sql即可。
    2.配置数据库连接信息
        修改demo.sh 中的数据库连接信息。Apollo服务端需要知道如何连接到你前面创建的数据库，所以需要编辑demo.sh，修改ApolloPortalDB和ApolloConfigDB相关的数据库连接串信息。

三、启动Apollo配置中心
    1.确保端口未被占用
        Quick Start脚本会在本地启动3个服务，分别使用8070, 8080, 8090端口，请确保这3个端口当前没有被使用
    2.执行启动脚本
        ./demo.sh start   如果是windows可以 右键，使用 Git Bash Here来启动
    3.验证是否安装成功
        1.验证eureke是否安装成功  访问：http://localhost:8080/
        2.验证apollo是否安装成功  访问：http://localhost:8070  账号密码：apollo/admin
    4.运行只带客户端程序
        ./demo.sh client
        输入timeout   看是否有内容
    5.修改配置并发布
        在apollo后台管理页面：http://localhost:8070  修改timeout的值并发布
        再次输入timeout   看是否有变化

四、使用java客户端
    参考 Java客户端使用指南：https://github.com/ctripcorp/apollo/wiki/Java客户端使用指南

    1.新建springboot项目mk-apollo
    2.加入依赖
        <!-- apollo -->
        <dependency>
            <groupId>com.ctrip.framework.apollo</groupId>
            <artifactId>apollo-client</artifactId>
            <version>1.1.0</version>
        </dependency>
    3.增加属性文件
        详见application.yml
            app:
              id: SampleApp
            apollo:
              #meta: http://localhost:8080 #eureka地址  关闭这个，需要指定-Denv ,如-Denv=dev
              cacheDir: d:\opt\settings\server.properties
              bootstrap:
                enabled: true
                namespaces: application,TEST1.ns1,nsp1.yml,nsp2  #application为默认的namespace,TEST1.ns1为公共的namespace,nsp1.yml为私有的namespace
        详见apollo-env.properties  （环境配置文件不一定需要使用）
            dev.meta=http://localhost:8080
            fat.meta=http://apollo.fat.xxx.com
            uat.meta=http://apollo.uat.xxx.com
            pro.meta=http://apollo.xxx.com

            可以通过 -Denv=dev -Dserver.port=9011 -Dapp.id=appid001  指定参数
            如：  java -jar -Denv=dev -Dserver.port=9011 -Dapp.id=appid001  mk-apollo*.jar
    4.增加启动注解
        @EnableApolloConfig
        @SpringBootApplication
        public class ApolloApp {}

    5.增加配置
        @EnableApolloConfig
        @Configuration
        public class AppConfig {

          @Bean("configBean")
          public TestJavaConfigBean javaConfigBean() {
            return new TestJavaConfigBean();
          }
        }

        TestJavaConfigBean 通过@Value给属性赋值  （从apollo配置中心获取具体的参数值）

    项目详见：mk-apollo
    验证：
    1.访问  http://localhost:9010/apollo   观察参数值
    2.查看apollo中的值：如
        http://192.168.56.1:8080/configs/SampleApp/default/application?ip=192.168.56.1
        http://192.168.56.1:8080/configs/SampleApp/default/TEST1.ns1?ip=192.168.56.1
        http://192.168.56.1:8080/configs/appid001/default/application?ip=192.168.56.1

        其中 SampleApp  和  appid001 是appid,   application 和 TEST1.ns1  是namespace


