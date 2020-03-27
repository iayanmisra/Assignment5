package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.StudentDao;
import com.cognizant.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public String insert(Student s) {
		return studentDao.insert(s);
	}

	@Override
	public String update(Student s) {
		return studentDao.update(s);
	}

	@Override
	public String delete(Student s) {
		return studentDao.delete(s);
	}

	@Override
	public List<Student> getAll() {
		return studentDao.getAll();
	}

}
