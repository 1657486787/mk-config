分布式配置中心：
一、spring cloud config
    springcloud中的一组件
    项目：mk-springcloud-config
    详见说明：readme-springcloudconfig.txt
二、apollo
    携程开原的分布式配种中心
    项目：mk-apollo
    详见说明：readme-apollo.txt
三、nacos
    阿里开原nacos
    详见说明：readme-nacos.txt

四、Spring Boot项目使用maven-assembly-plugin根据不同环境打包成tar.gz或者zip 并自动生成start.bat start.sh shutdown.sh脚本
    参考：https://yq.aliyun.com/articles/679578
         https://github.com/geekidea/spring-boot-assembly
    详见mk-nacos-zip2
    注意点：
    1.pom.xml中 <finalName>mk-nacos-zip2</finalName>  指定打包名称
    2.pom.xml中 <mainClass>com.suns.NacosApp</mainClass>   指定启动类
    3.pom.xml中  <!-- 解决：Caused by: java.lang.IllegalStateException: Attempted to load applicationConfig: [file:/usr/local/soft/temp/nacos/mk-nacos-zip2/config/application.yml] but snakeyaml was not found on the classpath -->
              <dependency>
                  <groupId>org.yaml</groupId>
                  <artifactId>snakeyaml</artifactId>
              </dependency>
    4.assembly.xml中
            <format>tar.gz</format>
            <format>zip</format>  指定打包的类型，可以多个