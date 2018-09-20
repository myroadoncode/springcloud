package springcloud.controller;

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

//	@Resource
//	private DiscoveryClient discoveryClient;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept)
	{
		return service.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id)
	{
		return service.get(id);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Dept> list()
	{
		return service.list();
	}

//	@RequestMapping(value = "/dept/del/{id}")
//	public void del(@PathVariable String id){
//		service.del(id);
//	}

//	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
//	public Object discovery()
//	{
//		List<String> list = discoveryClient.getServices();
//		System.out.println("**********" + list);
//
//		List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
//		for (ServiceInstance element : srvList) {
//			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
//					+ element.getUri());
//		}
//		return this.discoveryClient;
//	}
}
