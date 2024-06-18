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
		
		if(pdto.isState()) { // 구구단 데이터 가져와야 함
		
			Map map = pdto.getResultMap();
			String dan = map.get("dan").toString();
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

}
