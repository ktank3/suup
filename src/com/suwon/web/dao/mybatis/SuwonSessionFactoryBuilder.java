package com.suwon.web.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SuwonSessionFactoryBuilder {
	
	//한번만 만들어지게 전역화 시킨 후 싱글턴 패턴 적용
	static String src = "com/suwon/web/dao/mybatis/config.xml";
	static SqlSessionFactory ssf = null;
	
	static{		
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(src);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 돌리게 만듬(매퍼컨테이너 만들기 - 매퍼가 담김)
		ssf = new SqlSessionFactoryBuilder().build(is);
	}

	public static SqlSessionFactory getSqlSessionFactory() {		
		return ssf;
	}
	
}
