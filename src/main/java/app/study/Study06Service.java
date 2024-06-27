package app.study;

import org.springframework.stereotype.Service;

@Service
public class Study06Service {
	
	public int run(int type) {
		// 합 , 빼기 , 곱 , 나누기
		if(type == 1) {
			return 합();
		} 
		if (type == 2) {
			return 빼기();
		}
		if(type == 3) {
			return 곱();
		}
		if(type == 4) {
			return 나누기();
		}
		return 0;
	}
	
	private int 합() {
		return 1 + 3;
	}
	
	private int 곱() {
		return 1 * 3;
	}
	
	private int 빼기() {
		return 1 - 3;
	}
	
	private int 나누기() {
		return 1 / 3;
	}

}
