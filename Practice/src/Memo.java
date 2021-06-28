import java.util.ArrayList;
import java.util.List;

public class Memo {

	public static void main(String[] args) {
		
		Member member = new Member(null, 0, null);
		
		List<Member> list = new ArrayList<>();
		list.add(member.getName(), member.getAge(), member.getAddress());
	}

}
