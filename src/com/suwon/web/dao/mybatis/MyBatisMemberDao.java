package com.suwon.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import com.suwon.web.dao.MemberDao;
import com.suwon.web.entities.Member;

public class MyBatisMemberDao implements MemberDao{
	
	SqlSessionFactory ssf; 

	// 생성자
	public MyBatisMemberDao() {
		ssf = SuwonSessionFactoryBuilder.getSqlSessionFactory(); 
	}

	@Override
	public Member get(String mid) {
		SqlSession session = ssf.openSession();
		MemberDao dao = session.getMapper(MemberDao.class);
		
		Member member = dao.get(mid);
		session.close();

		return member;
	}

	@Override
	public List<Member> getList(int page, String field, String query) {
		SqlSession session = ssf.openSession();
		MemberDao dao = session.getMapper(MemberDao.class);
		
		List<Member> list = dao.getList(page,field,query);
		session.close();

		return list;
	}

	@Override
	public int insert(Member member) {
		SqlSession session = ssf.openSession();
		MemberDao dao = session.getMapper(MemberDao.class);

		int result = dao.insert(member);
		session.commit();
		session.close();

		return result;
	}

	@Override
	public int update(Member member) {
		SqlSession session = ssf.openSession();
		MemberDao dao = session.getMapper(MemberDao.class);

		int result = dao.update(member);
		session.commit();
		session.close();

		return result;
	}

	@Override
	public int delete(String mid) {
		SqlSession session = ssf.openSession();
		MemberDao dao = session.getMapper(MemberDao.class);

		int result = dao.delete(mid);
		session.commit();
		session.close();

		return result;
	}
	


}
