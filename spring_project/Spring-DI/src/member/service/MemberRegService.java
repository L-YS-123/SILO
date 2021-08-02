package member.service;

import java.util.Date;

import member.dao.Dao;
import member.domain.Member;
import member.domain.RegRequest;

public class MemberRegService {
	//Dao dao = new MemberDao(); <- 이렇게 하지 않는다
	Dao dao;	//Dao는 인터페이스
	
	public MemberRegService(Dao dao) {
		this.dao = dao;
	}
	
	public void regMember(RegRequest request) throws Exception {
		// 중복 이메일을 체크하고 예외를 발생
		Member member = dao.selectByEmail(request.getEmail()); 
		
		if(member != null) {
			throw new Exception("이메일이 중복되었습니다");
		}
		
		Member newMember = new Member(0, request.getEmail(), request.getPassword(), request.getName(), new Date());
		
		
		dao.insert(newMember);
		System.out.println("이메일이 등록되었습니다");
	}
}
