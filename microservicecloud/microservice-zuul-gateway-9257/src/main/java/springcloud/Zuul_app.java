package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
// 声明zuul
@EnableZuulProxy
public class Zuul_app {
    public static void main(String[] args)
    {
        SpringApplication.run(Zuul_app.class, args);
    }
}
