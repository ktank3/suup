	package com.suwon.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.suwon.web.dao.NoticeDao;
import com.suwon.web.entities.Notice;
import com.suwon.web.model.NoticeModel;

public class MyBatisNoticeDao implements NoticeDao{

	SqlSessionFactory ssf;
	public MyBatisNoticeDao() {
		ssf = SuwonSessionFactoryBuilder.getSqlSessionFactory();
	}
	
	@Override
	public Notice get(String code){

		SqlSession session = ssf.openSession();
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);

		Notice result = noticeDao.get(code);
		session.close();
		
		return result;
	}

	@Override
	public List<NoticeModel> getList(int page, String field, String query){
		
		SqlSession session = ssf.openSession();
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		
		return noticeDao.getList(page, field, query);
	}

	@Override
	public List<NoticeModel> getList(int page){
		
		return getList(page, "TITLE", "");
	}

	@Override
	public List<NoticeModel> getList(){
		
		return getList(1, "TITLE", "");
	}

	@Override
	public int insert(Notice notice){

		SqlSession session = ssf.openSession();
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		int result = noticeDao.insert(notice);
		
		session.commit();
		session.close();
		
		
		return result;
	}

	@Override
	public int update(Notice notice){

		SqlSession session = ssf.openSession();
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		int result = noticeDao.update(notice);
		
		//mybatis´Â auto-commit¾Æ´Ï¶ó ½áÁà¾ßµÊ
		session.commit();
		session.close();
		
		return result;
	}

	@Override
	public int delete(String code){

		SqlSession session = ssf.openSession();
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		int result = noticeDao.delete(code);
		
		session.commit();
		session.close();
		
		
		return result;
	}

	@Override
	public int getCount(String field, String query) {
		SqlSession session = ssf.openSession();
		NoticeDao noticeDao = session.getMapper(NoticeDao.class);
		
		int result = noticeDao.getCount(field,query);
		session.close();
		
		return result;
	}
	
}
