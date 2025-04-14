package banking;

public class Account {

	String acc_num;
	String name;
	int balnc;
	
	//생성자
	public Account(String acc_num, String name, int balnc) {
		this.acc_num = acc_num;
		this.name = name;
		this.balnc = balnc;
	}
	
	public void showAccInfo() {
		System.out.println("----------------------");
		System.out.println("계좌번호 : "+acc_num);
		System.out.println("고객이름 : "+ name);
		System.out.println("잔고 : "+ balnc);
	}
	
	public int cal_rate(int money, int deposit) {
		int cal=0;
		return cal;
	}
	
}
