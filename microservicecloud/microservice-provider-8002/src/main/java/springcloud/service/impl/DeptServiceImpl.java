package springcloud.service.impl;

import org.springframework.stereotype.Service;
import springcloud.dao.DeptDao;
import springcloud.entities.Dept;
import springcloud.service.DeptService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService
{
	@Resource
	private DeptDao dao;
	
	@Override
	public boolean add(Dept dept)
	{
		return dao.addDept(dept);
	}

	@Override
	public Dept get(Long id)
	{
		return dao.findById(id);
	}

	@Override
	public List<Dept> list()
	{
		return dao.findAll();
	}

	@Override
	public void del(String id) {
		dao.del(id);
	}

}
