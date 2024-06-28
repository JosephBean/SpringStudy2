package app.study;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Study06Dao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<Map> findList(Object accept) {
		return sqlSession.selectList("temp1.findList", accept);
	}

}
