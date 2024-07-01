package app.study;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Study06Service {
	
	public int run(int type, int a, int b) {
		// 합 , 빼기 , 곱 , 나누기
		if(type == 1) {
			return 합(a, b);
		} 
		if (type == 2) {
			return 빼기(a, b);
		}
		if(type == 3) {
			return 곱(a, b);
		}
		if(type == 4) {
			return 나누기(a, b);
		}
		return 0;
	}
	
	private int 합(int a, int b) {
		return a + b;
	}
	
	private int 곱(int a, int b) {
		return a * b;
	}
	
	private int 빼기(int a, int b) {
		return a - b;
	}
	
	private int 나누기(int a, int b) {
		return a / b;
	}
	
	@Autowired
	private Study06Dao dao;
	
	public void edit(int no, Map map) {
		if(no > 0) {
			map.put("no", no);
			if(dao.edit(map) == 1) {
				// 내용 정의 여기서 할 수 있다. (성공)
			}
		}
	}
	
	public void edit(int no, int accept) {
		if(no > 0) {
			Map map = new HashMap<>();
			map.put("no", no);
			map.put("accept", accept);
			if(dao.editAccept(map) == 1) {
				// 내용 정의 여기서 할 수 있다. (성공)
			}
		}
	}
	
	public int save(Map map) {
		map = dao.save(map);
		Object obj = map.get("no");
		if(obj != null) {
			int no = Integer.parseInt(obj.toString()); 
			log.info("no : {}", no);
			return no;
		}
		return 0;
	}

}
