package com.suwon.web.dao;

import java.util.List;

import com.suwon.web.entities.Member;

public interface MemberDao {
	Member get(String mid);
	List<Member> getList(int page, String field, String query);
	int insert(Member member);
	int update(Member member);
	int delete(String mid);
}
