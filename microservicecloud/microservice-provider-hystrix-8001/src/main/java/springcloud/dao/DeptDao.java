package springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import springcloud.entities.Dept;

import java.util.List;

@Mapper
public interface DeptDao
{
	public boolean addDept(Dept dept);

	public Dept findById(Long id);

	public List<Dept> findAll();

	public void del(String id);
}
