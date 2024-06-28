package app.study;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public void url(@PathVariable(required = false) Object accept) {
		log.info("accept : {}", accept);
		List<Map> list = study06dao.findList(accept);
		log.info("temp1 LIST SIZE : {}", list.size());
		for(Map map : list) {
//			int check = 0;
//			if((boolean) map.get("accept")) {
//				// 참
//				check = 1;
//			}
//			if(accept == check) {
				log.info("ROW : {}", map);
//			}
		}
	}
	
}
