package app.study;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/s6")
public class Study06 {
	
	@Autowired
	private Study06Service service;

	/******************************************************************************
	 * log level    설명
	 * trace		debug 보다 세분화된 정보
	 * debug		디버깅하는데 유용한 세분화된 정보
	 * info			진행상황 같은 일반 정보
	 * warn			오류는 아니지만 잠재적인 오류 원인이 될 수 있는 경고성 정보
	 * error		요청을 처리하는 중 문제가 발생한 오류 정보
	 * 
	 * trace > debug > info > warn > error
	 *
	 ******************************************************************************/
	
	// Service에서 연산 호출하여 결과값 받아 오기
	@GetMapping("/{type:[1-4]}/{a:[0-9]+}/{b:[0-9]+}/{e:[0-9]+}")
	public void url(
			@PathVariable int type, 
			@PathVariable int a, 
			@PathVariable int b, 
			@PathVariable int e
			) {
		int value = service.run(type, a, b);
		log.info("run() : {} {}", value, (e == value));
	}
	
	@Autowired
	Study06Dao study06dao;
	
	@GetMapping(value = {"/findList/{accept:[0-1]}", "/findList"})
	public String url(@PathVariable(required = false) Object accept, Model model) {
		List<Map> list = study06dao.findList(accept);
		model.addAttribute("list", list);
		return "study/s6/list";
	}
	
	@GetMapping("/detail/{no:[0-9]+}")
	public String detail(@PathVariable int no, Model model) {
		if(no > 0) {
			Map map = study06dao.findOne(no);
			model.addAttribute("map", map);
			return "study/s6/detail";
		}
		return "redirect:/s6/findList";
	}
	
	@PostMapping("/edit/{no:[0-9]+}")
	public String edit(@PathVariable int no, @RequestParam Map map) {
		log.info("no : {}", no);
		log.info("Map : {}", map);
		service.edit(no, map);
		return "redirect:/s6/detail/" + no;
	}
	
	@GetMapping("/edit/{no:[0-9]+}/{accept:[0-1]}")
	public String edit(@PathVariable int no, @PathVariable int accept) {
		log.info("no : {}", no);
		log.info("Accept : {}", accept);
		service.edit(no, accept);
		return "redirect:/s6/detail/" + no;
	}
	
	
	@GetMapping("/new")
	public String newPage() {
		return "study/s6/new";
	}
	
	@PostMapping("/save")
	public String save(@RequestParam Map map) {
		log.info("Map : {}", map);
		int no = service.save(map);
		return "redirect:/s6/detail/" + no;
	}
	
	
}
