package com.atguigu.springmvc.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@ResponseBody
@Controller
public class SpringMVCHandler {
	
/*	@RequestMapping("/testRequestBody")
	public String testRequestBody (@RequestBody String body) {
		System.out.println("上传文件信息是" + body);
		return "success";
	}*/
	
	// 文件上传
	@RequestMapping(value="/testUpload",method=RequestMethod.POST)
	public String testUpload(@RequestParam("desc") String desc, @RequestParam("file") MultipartFile multipartFile,HttpSession session) throws Exception {
		// 获取文件的描述信息
		System.out.println("上传文件的信息是：" + desc);
		// 获取表单项name的值
		System.out.println("表单项的name属性名为：" + multipartFile.getName());
		// 获取文件名
		String name = multipartFile.getOriginalFilename();
		System.out.println("文件名为：" + name);
		// 获取文件的类型
		String contentType = multipartFile.getContentType();
		System.out.println("文件的类型是：" + contentType);
		// 获取文件的大小
		long size = multipartFile.getSize();
		System.out.println("文件的大小是：" + size);
		// 将文件写到G盘的根目录
		// multipartFile.transferTo(new File("E:/" + name));
		// 将文件上传的服务器的upload目录下
		// 获取upload的真实路径
		ServletContext servletContext = session.getServletContext();
		String realPath = servletContext.getRealPath("/upload");
		// 判断服务器中是否有upload目录，如果没有自动创建
		File file = new File(realPath);
		if(!file.exists()) {
			// 如果不存在，自动创建
			file.mkdirs();
		}
		// 将文件上传到upload目录中
		multipartFile.transferTo(new File(realPath + "/" + name));
		return "success";
	}
	        
	/*@RequestMapping("/testResponseEntity")
	public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws Exception {
		
		// 获取ServletContext
		ServletContext servletContext = session.getServletContext();
		
		//获取要下载的文件的真实路径
		String realPath = servletContext.getRealPath("/download/when.jpg");
		
		//获取一个输入流
		InputStream is = new FileInputStream(realPath);
		
		byte[] body = new byte[is.available()];
		
		// 将流读到数组中
		is.read(body);
		
		// 创建HttpHeaders对象
		HttpHeaders headers = new HttpHeaders();
		
		// 告诉浏览器如果处理要下载的文件
		headers.add("Content-Desposition", "attachment;filename=when.jpg");
		
		// 设置响应状态码
		HttpStatus statusCode = HttpStatus.OK;
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(body, headers, statusCode);
		is.close();
		return responseEntity;
	}*/
	
	// 测试国际化
	@RequestMapping("/testI18n")
	public String testI18n() {
		System.out.println("测试国际化");
		return "show";
	}
	
	// 测试自定义拦截器
	@RequestMapping("/testMyInterceptor")
	public String testMyInterceptor() {
		System.out.println("3测试自定义拦截器");
		return "success";
	}
	
	// 使用@requestBody测试文件上传
	@RequestMapping(value="/testRequestBody",method=RequestMethod.POST)
	public String testRequestBody(@RequestBody String body) {
		System.out.println("你上传的信息是：" + body);
		return "success";
	}
	
	// 实现文件下载
	@RequestMapping("/testResponseEntity")
	public ResponseEntity<byte[]> testResponseEntity1(HttpSession session) throws Exception {
		// 获取ServletContext
		ServletContext servletContext = session.getServletContext();
		// 获取下载文件的真实路径
		String realPath = servletContext.getRealPath("/download/when.jpg");
		// 获取输入流
		FileInputStream is = new FileInputStream(realPath);
		byte[] body = new byte[is.available()];
		// 读取流到数组中
		is.read(body);
		// 创建httpHeaders对象
		HttpHeaders headers = new HttpHeaders();
		// 告诉浏览器要下载的文件
		headers.add("Content-Disposition", "attachment;filename=when.jpg");
		// 设置响应状态码
		HttpStatus statusCode = HttpStatus.OK;
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(body, headers, statusCode);
		// 关闭流
		is.close();
		return responseEntity;
	}
}
