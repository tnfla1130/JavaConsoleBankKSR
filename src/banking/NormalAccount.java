package banking;

import java.io.PrintWriter;

public class NormalAccount extends Account{

	private int baseRate;
	int money, deposit;
	
	public NormalAccount(String acc_num, String name, int balnc, int baseRate) {
		super(acc_num, name, balnc);
		this.baseRate = baseRate;
	}
	public int getBaseRate() {
		return baseRate;
	}
	@Override
	public void printAcc(PrintWriter out) {
		super.printAcc(out);
		out.println("기본이자 : "+ baseRate+ "%");
		out.println("----------------------");
	}
	
	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println("기본이자 : "+ baseRate+ "%");
		
	}
	
	
	@Override
	public int cal_rate(int money, int deposit) {
		return (int)Math.floor(money + ( money * baseRate/100 ) + deposit);
		
	}

	
}
