package springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springcloud.entities.Dept;

import java.util.List;

@RestController
public class ConsumerController {
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
//    ribbon配置后可以直接调用服务
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @GetMapping(value = "/consumer/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list" , List.class);
    }

    @RequestMapping(value = "/consumer/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping(value = "/consumer/delete/{id}")
    public void del(@PathVariable("id") String id) {
        restTemplate.delete(REST_URL_PREFIX + "/dept/del/" + id);
    }
}
