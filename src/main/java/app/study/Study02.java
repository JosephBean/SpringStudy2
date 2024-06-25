package app.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/s2")
public class Study02 {

	// 첫 화면 출력
	@GetMapping("/")
	public String page1() {
		return "study/s2/page1";
	}
	
	// 데이터 요청 후 정보를 돌려 보내는 메소드
	@GetMapping("/data")
	public String data(RedirectAttributes ra) {

		return "redirect:/s2/";
	}
	
}
