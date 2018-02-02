package fi.haaga.hellothyme.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import fi.haaga.hellothyme.domain.Student;


@Controller
public class ThymeController {
	
	private static List<String> friendList = null;
	

	 @RequestMapping(value="/hello", method=RequestMethod.GET)
	    public String greetingForm(@RequestParam(name ="name")String name, @RequestParam(name="age")int age, Model model) {
	    	model.addAttribute("name", name);
	    	model.addAttribute("age", age);
	        return "hello";
	}
	 
	 
	 @RequestMapping(value="/main", method=RequestMethod.GET)
	    public String printStudents(@ModelAttribute Student student,Model model) {
		 Student student1 = new Student("Kate","Cole", "kate.cole@hh.com");
		 Student student2 = new Student("Dan","Brown", "dan.brown@hh.com");
		 Student student3 = new Student("Mike","Mars", "mike.mars@hh.com");
		 
		 List <Student> studentList = new ArrayList<Student>();	
		 
		 
		 studentList.add(student1);
		 studentList.add(student2);
		 studentList.add(student3);
		 model.addAttribute(studentList);
	    	
	     return "main";
	}
	 
	 @RequestMapping(value="/index", method=RequestMethod.GET)
	    public String addFriends(@RequestParam(name="name")String name, Model model) {
		 
		 if(friendList == null)
		 {
			 friendList = new ArrayList<String>();
		 }
		
		 friendList.add(name); 
		 model.addAttribute("friendList",friendList);
		 System.out.print(friendList);
	     return "index";
	    }
 
	 
}
