package springcloud.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import springcloud.entities.Dept;
import springcloud.service.DeptService;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptController
{
	@Resource
	private DeptService service;

	@Resource
	private DiscoveryClient discoveryClient;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept)
	{
		return service.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	// 服务熔断
//	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Dept get(@PathVariable("id") Long id) throws Exception {
        Dept dept = service.get(id);
        // 异常情况以null为例
        if (null == dept) {
            throw new Exception();
        }
        return dept;
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list()
	{
		return service.list();
	}

//	public Dept processHystrix_Get(@PathVariable("id") Long id)
//	{
//        Dept dept = new Dept();
//        dept.setDeptno(id);
//        dept.setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand");
//        dept.setDb_source("no this database in MySQL");
//
//        return dept;
//	}

	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery()
	{
		List<String> list = discoveryClient.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.discoveryClient;
	}
}
