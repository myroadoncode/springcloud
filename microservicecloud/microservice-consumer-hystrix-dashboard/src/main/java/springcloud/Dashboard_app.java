package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
// 声明监控板
@EnableHystrixDashboard
public class Dashboard_app {
    public static void main(String[] args)
    {
        SpringApplication.run(Dashboard_app.class, args);
    }
}
