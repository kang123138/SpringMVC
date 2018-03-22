package com.atguigu.springmvc.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.springmvc.entity.Employee;
import com.atguigu.springmvc.entity.User;

@Controller
// 添加session域中
//@SessionAttributes(value="user",types=String.class)
public class SpringMVCHandler {
	
	private static final String SUCCESS = "success";
	
	@RequestMapping("/testPOJO")
	public String testPOJO(Employee employee) {
		 System.out.println("员工的信息是" + employee);
		return SUCCESS;
	}
	
	@RequestMapping("/testServletAPI")
	public String testServletAPI(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request);
		System.out.println(response);
		return SUCCESS;
	}
	
	@RequestMapping("/testModel")
	public ModelAndView testModel() {
		String viewName = "success";
		ModelAndView mv = new ModelAndView(viewName);
		mv.addObject("user", new User(1, "d", "d", "dsf@qq.com"));
		return mv;
	}
	
	// 处理模型数据方式一：返回值是ModelAndView对象
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		// 创建ModelAndView对象
		ModelAndView mv = new ModelAndView();
		
		// 设置模型数据
		mv.addObject("user", new User(1, "李玉婷", "123456", "lyt@han.com"));
		
		// 设置视图名
		mv.setViewName("show");
		return mv;
	}
	
	// 处理模型数据方式二：Handler的方法的入参中传入Map、Model获取ModelMap
	@RequestMapping("/testMap")
	public String testModel(Map<String, Object> map) {
		System.out.println(map.getClass());
		// 向map中添加数据，最终会放到request域中
		map.put("user", new User(2, "张无忌", "666666", "zwj@mjst.com"));		
		return "show";
	}
	
	// 放入Session域中
	@RequestMapping("/testSession")
	public String testSession(Map<String, Object> map) {
		// 向map中添加模型数据
		// map.put("user", new User(3, "李小璐", "111111", "lxl@jnl.com"));
		map.put("person", "PGOne");
		return "show";
	}
	
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(User user) {
		System.out.println("更新后的数据是：" + user);
		return SUCCESS;
	}
	
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id,Map<String, Object> map) {
		if(id != null) {
			//从数据库中查询出要更新的用户的信息，在此我们假设new的User对象就是从数据库中查询出来的
			User user = new User(1, "Xugang", "222222", "xugang@dym.com");
			//将user放到map中
			map.put("user", user);
		}
	}
}
