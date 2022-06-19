package toyProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemberManager {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	MemberDAO dao = new MemberDAO();
	Member member = new Member();

	public void readMenu() throws IOException {
		while (true) {
			
			System.out.println("목록을 원하시면 1번을 입력하세요");
			System.out.println("등록을 원하시면 2번을 입력하세요");
			System.out.println("수정을 원하시면 3번을 입력하세요");
			System.out.println("삭제을 원하시면 4번을 입력하세요");
			System.out.println("종료을 원하시면 0번을 입력하세요");

			String n = br.readLine();

			if (n.equals("0")) {
				break;
			}

			else if (n.equals("1")) {
				dao.getMemberList();
			}

			else if (n.equals("2")) {
				System.out.println("아이디를 입력하세요 (형식 M-00001): ");
				member.setMemberId(br.readLine());
				
				System.out.println("이름을 입력하세요 : ");
				member.setName(br.readLine());
				
				System.out.println("전화번호를 입력하세요 : ");
				member.setPhoneNumber(br.readLine());
				
				dao.insertMember(member.getMemberId(), member.getName(), member.getPhoneNumber());
				
				System.out.println("---> 회원가입에 성공하셨습니다.");
			}
			
			else if(n.equals("3")) {
				System.out.println("수정할 아이디를 입력하세요 (형식 M-00001)");
				member.setMemberId(br.readLine());
				
				System.out.println("수정할 전화번호를 입력하세요 : ");
				member.setPhoneNumber(br.readLine());
				
				System.out.println("---> 회원수정에 성공하셨습니다.");
				dao.updateMember(member.getPhoneNumber(), member.getMemberId());
			}
			
			else if(n.equals("4")) {
				System.out.println("삭제할 아이디를 입력하세요 : ");
				String memberID = br.readLine();
				
				dao.deleteMember(memberID);
				
				System.out.println("---> " + memberID +"회원 삭제에 성공하셨습니다.");
			}
			
		}

	}
}
