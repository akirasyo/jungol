package Client;
import Common.*;
public class SignUpCheck {
	private String str;
	private Member member;
	private NetworkO netout = new NetworkO();
	public SignUpCheck(Member member) {
		this.member = member;
		idCheck();
	}
	public void idCheck(){
		netout.search(member);
	}
}
