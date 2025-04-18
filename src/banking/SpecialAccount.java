package banking;

import java.io.PrintWriter;

public class SpecialAccount extends NormalAccount{


	public SpecialAccount(String acc_num, String name, int balnc, int baseRate) {
		super(acc_num, name, balnc, baseRate);
	}
	
	@Override
	public void printAcc(PrintWriter out) {
		super.printAcc(out);
	}
	
	@Override
	public void showAccInfo() {
		super.showAccInfo();
	}
	
	@Override
	public int cal_rate(int money, int deposit) {
		return (int)Math.floor(money + ( money * getBaseRate()/100 ) + deposit);
		
	}

}
