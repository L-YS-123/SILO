package member.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import member.domain.Member;

public class MemberDao implements Dao {
	
	private static int nextId = 0;
	private Map<String, Member> map = new HashMap<>();
	// email, Member

	@Override
	public Member selectByEmail(String email) {
		// TODO Auto-generated method stub
		return map.get(email); //email=key
	}

	@Override
	public void insert(Member member) {
		// TODO Auto-generated method stub
		member.setId(nextId++);
		map.put(member.getEmail(), member);
	}

	@Override
	public void update(Member member) {
		// TODO Auto-generated method stub
		map.put(member.getEmail(), member);
	}

	@Override
	public Collection<Member> selectAll(Member member) {
		// TODO Auto-generated method stub
		return map.values();
	}

}
