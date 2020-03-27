package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.model.Student;
import com.cognizant.service.StudentServiceImpl;

@Controller
public class StudentController 
{
	@Autowired
	private StudentServiceImpl studentService;

	public void setStudentService(StudentServiceImpl studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping(value="insert",method = RequestMethod.GET)
	public ModelAndView insertPage()
	{
		ModelAndView mv=new ModelAndView("insert");
		Student student=new Student();
		mv.addObject("student", student);
		return mv;
	}
	
	@RequestMapping(value = "insert",method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("student") Student student)
	{
		String result=studentService.insert(student);
		ModelAndView mv=new ModelAndView("insert");
		System.out.println("Model Attribute:"+student);
		if(result.equals("Success"))
		{
			mv.addObject("msg","Record Inserted Successfully");
		}
		else
		{
			mv.addObject("msg","Record Not Inserted Successfully");
		}
		return mv;
		
	}
	
	@RequestMapping(value="update",method = RequestMethod.GET)
	public ModelAndView updatePage()
	{
		ModelAndView mv=new ModelAndView("update");
		Student student=new Student();
		mv.addObject("student", student);
		return mv;
	}
	
	@RequestMapping(value = "update",method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("student") Student student)
	{
		String result=studentService.update(student);
		ModelAndView mv=new ModelAndView("update");
		System.out.println("Model Attribute:"+student);
		if(result.equals("Success"))
		{
			mv.addObject("msg","Record Updated Successfully");
		}
		else
		{
			mv.addObject("msg","Record Not Updated Successfully");
		}
		return mv;
		
	}
	@RequestMapping(value="delete",method = RequestMethod.GET)
	public ModelAndView deletePage()
	{
		ModelAndView mv=new ModelAndView("delete");
		Student student=new Student();
		mv.addObject("student", student);
		return mv;
	}
	
	@RequestMapping(value = "delete",method = RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute("student") Student student)
	{
		String result=studentService.delete(student);
		ModelAndView mv=new ModelAndView("delete");
		System.out.println("Model Attribute:"+student);
		if(result.equals("Success"))
		{
			mv.addObject("msg","Record Deleted Successfully");
		}
		else
		{
			mv.addObject("msg","Record Not Deleted Successfully");
		}
		return mv;
		
	}

	
	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public ModelAndView getAll(HttpServletRequest request) {
		List<Student> list = studentService.getAll();
		System.out.println(list);
		ModelAndView mv=new ModelAndView("getAll");
		mv.addObject("list", list);
		return mv;
	}
}
