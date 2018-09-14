package springcloud;

import myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
// 添加自定义Ribbon规则(自定义规则配置不能放在ComponentScan扫描包及子包下即不能让主启动类扫描到)
@RibbonClient(name = "MICROSERVICECLOUD" , configuration = MySelfRule.class)
public class Consumer80 {
    public static void main(String[] args) {
        SpringApplication.run(Consumer80.class , args);
    }
}
