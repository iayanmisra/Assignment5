package com.cognizant.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String insert(Student s) {
		String sql="insert into sdetails values(?,?)";
		int result=jdbcTemplate.update(sql, s.getId(),s.getName());
		if(result>0)
		{
			return "Success";
		}
		return "Fail";
	}

	public String update(Student s) {
		String sql="update sdetails set name=? where id=?";
		int result=jdbcTemplate.update(sql, s.getName(),s.getId());
		if(result>0)
		{
			return "Success";
		}
		return "Fail";
	}

	public String delete(Student s) {
		String sql="delete from sdetails where id=?";
		int result=jdbcTemplate.update(sql, s.getId());
		if(result>0)
		{
			return "Success";
		}
		return "Fail";
	}

	public List<Student> getAll() {
		List<Student> list=jdbcTemplate.query("select * from sdetails", new BeanPropertyRowMapper(Student.class));
		return list;
	}
	
	

}
