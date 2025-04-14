package banking;

public class NormalAccount extends Account{

	int baseRate;
	int money, deposit;
	int cal=0;
	
	public NormalAccount(String acc_num, String name, int balnc, int baseRate) {
		super(acc_num, name, balnc);
		this.baseRate = baseRate;
	}
	
	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println("기본이자 : "+ baseRate);
		System.out.println("----------------------");
	}
	
	
	@Override
	public int cal_rate(int money, int deposit) {
		return (int)Math.floor(money + ( money * baseRate/100 ) + deposit);
		
	}
	
}
