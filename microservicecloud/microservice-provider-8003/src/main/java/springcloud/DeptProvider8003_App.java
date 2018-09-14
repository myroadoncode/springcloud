package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
// 声明该服务是客户端
@EnableEurekaClient
// 声明该服务能自动被注册中心发现
//@EnableDiscoveryClient
public class DeptProvider8003_App
{
	public static void main(String[] args)
	{
		SpringApplication.run(DeptProvider8003_App.class, args);
	}
}
