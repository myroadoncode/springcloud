package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
// 声明该服务是客户端
@EnableEurekaClient
// 声明熔断器
@EnableHystrix
// 对hystrixR熔断机制的支持
@EnableCircuitBreaker
public class DeptProvider8001_App_Hystrix
{
	public static void main(String[] args)
	{
		SpringApplication.run(DeptProvider8001_App_Hystrix.class, args);
	}
}
