package app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		System.out.println("안녕");
		model.addAttribute("name", "홍길동");
		return "home";
	}
	
	@GetMapping("/page1")
	public String page1() {
		
		
		
		return "page1";
	}
	
	@GetMapping("/page2")
	public String page2(Model model, HttpServletRequest req) {
		
		String dan = req.getParameter("dan");
		System.out.println(dan);
		
		int s = 1;
		int d = 0;
		
		if(dan == null || "A".equals(dan)) {
			s = 1;
			d = 10;
		}else if("1".equals(dan)) {
			s = 1;
			d = 2;
		}else if("2".equals(dan)) {
			s = 2;
			d = 3;
		}else if("3".equals(dan)) {
			s = 3;
			d = 4;
		}else if("4".equals(dan)) {
			s = 4;
			d = 5;
		}else if("5".equals(dan)) {
			s = 5;
			d = 6;
		}else if("6".equals(dan)) {
			s = 6;
			d = 7;
		}else if("7".equals(dan)) {
			s = 7;
			d = 8;
		}else if("8".equals(dan)) {
			s = 8;
			d = 9;
		}else if("9".equals(dan)) {
			s = 9;
			d = 10;
		}
		
		List list = new ArrayList<>(); 
		for(int i = s; i < d; i++ )
		{
			List list2 = new ArrayList<>();
			for(int j = 1; j < 10; j++) {
				String str = i + " * " + j + " = " + (i * j);
//				System.out.println();
				list2.add(str);
			}
			list.add(list2);
		}
		model.addAttribute("dan", s);
		model.addAttribute("list", list);
		return "page2";
	}
	
}
