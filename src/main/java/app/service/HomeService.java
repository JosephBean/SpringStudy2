package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.dto.ParamDTO;

@Service
public class HomeService {
	
	public void page2(Model model, ParamDTO pdto) 
	{
		int s = 1;
		int d = 0;
		if(pdto.isState()) 
		{
			Object param = pdto.getResultMap().get("dan");
			if(param != null) 
			{
				String dan = param.toString();
				switch (dan) 
				{
					case "A":
						d = 10;
						break;
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
			}
		} else {
			data(model, s, 10);
		}
		
	}
	
	private void data(Model model, int s, int d) {
		List<List<String>> list = new ArrayList<List<String>>(); 
		for(int i = s; i < d; i++ )
		{
			List<String> list2 = new ArrayList<String>();
			for(int j = 1; j < 10; j++) 
			{
				String str = i + " * " + j + " = " + (i * j);
				list2.add(str);
			}
			list.add(list2);
		}
		model.addAttribute("dan", s);
		model.addAttribute("list", list);
	}

}
