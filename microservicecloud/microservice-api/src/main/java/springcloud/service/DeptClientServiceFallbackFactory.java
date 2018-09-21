package springcloud.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import springcloud.entities.Dept;

import java.util.List;

// 不要忘记添加，不要忘记添加
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>
{
	@Override
	public DeptClientService create(Throwable throwable)
	{
		return new DeptClientService() {
			@Override
			public Dept get(long id)
			{
				Dept dept = new Dept();
				dept.setDeptno(id);
				dept.setDname("该ID ：" + id + "没有没有对应的信息,null--@HystrixCommand");
				dept.setDb_source("no this database in MySQL");

				return dept;
			}

			@Override
			public List<Dept> list()
			{
				return null;
			}

			@Override
			public boolean add(Dept dept)
			{
				return false;
			}
		};
	}
}
