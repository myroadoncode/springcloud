package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
// 声明该服务是服务器端
@EnableEurekaServer
public class Eureka7002 {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7002.class , args);
    }
}
