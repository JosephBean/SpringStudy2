package app.service;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.dto.ParamDTO;
import app.util.ParameterUtil;

@Service
public class HomeService {
	
	public void page2(Model model, ParamDTO pdto) {
		int s = 1;
		int d = 0;
		
		if(pdto.isState()) { // 구구단 데이터 가져와야 함
		
			Map map = pdto.getResultMap();
			String dan = map.get("dan").toString();
			
			if("A".equals(dan)) {
				d = 10;
			}
			
			switch (dan) {
				case "1":
				case "2":
				case "3":
				case "4":
				case "5":
				case "6":
				case "7":
				case "8":
				case "9":
					s = Integer.parseInt(dan);
					d = s + 1;
					break;
			}
			data(model, s, d);
		} else {
			data(model, s, 10);
		}
		
	}
	
	private void data(Model model, int s, int d) {
		List<List<String>> list = new ArrayList<List<String>>(); 
		for(int i = s; i < d; i++ )
		{
			List<String> list2 = new ArrayList<String>();
			for(int j = 1; j < 10; j++) {
				String str = i + " * " + j + " = " + (i * j);
				list2.add(str);
			}
			list.add(list2);
		}
		model.addAttribute("dan", s);
		model.addAttribute("list", list);
	}

}
