package app.study;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class Study06Dao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<Map> findList(Object accept) {
		return sqlSession.selectList("temp1.findList", accept);
	}
	
	public Map findOne(int no) {
		return sqlSession.selectOne("temp1.findOne", no);
	}
	
	public int edit(Map map) {
		return sqlSession.update("temp1.edit", map);
	}
	
	public int editAccept(Map map) {
		return sqlSession.update("temp1.editAccept", map);
	}
	
	public Map save(Map map) {
		sqlSession.insert("temp1.save", map);
		return map;
	}

}
