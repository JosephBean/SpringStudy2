package app.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@GetMapping("")
	public void url() {
		System.out.println(service.run(1));
	}	
}
