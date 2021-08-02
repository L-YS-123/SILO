package member.dao;

import java.util.Collection;

import member.domain.Member;

public interface Dao {
	// 회원 데이터를 email로 검색해서 Member객체로 반환하는 메소드
	Member selectByEmail(String email);
	
	// 데이터 저장
	void insert(Member member);
	
	// 패스워드 수정
	void update(Member member);
	
	// 전체 데이터 출력
	Collection<Member> selectAll(Member member);
}
