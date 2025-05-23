package banking;

import java.io.PrintWriter;

public class SpecialAccount extends NormalAccount{

	int depositNum = 0;
	public SpecialAccount(String acc_num, String name, int balnc, int baseRate) {
		super(acc_num, name, balnc, baseRate);
		this.baseRate = baseRate;
	}
	
	@Override
	public void printAcc(PrintWriter out) {
		super.printAcc(out);
	}
	
	@Override
	public void showAccInfo() {
		System.out.println("----------------------");
		super.showAccInfo();
	}
	
	@Override
	public void deposit(Account account, int money, int deposit) {

		int cal_rate =  (int)Math.floor(money + ( money * getBaseRate()/100 ) 
					+ deposit);
		account.setBalnc(cal_rate);
		depositNum++;
		System.out.println("SpecialAccount");
		if (depositNum%2 ==0) {
			account.setBalnc(account.getBalnc()+500);
			System.out.printf("%d번째 입금. 축하금 500원을 지급합니다.",depositNum);
			System.out.println("입금이 완료되었습니다.");
		}
		else {							
			System.out.println(depositNum);
			System.out.printf("%d번째 입금.",depositNum);
			System.out.println("입금이 완료되었습니다.");
		}
	}

}
