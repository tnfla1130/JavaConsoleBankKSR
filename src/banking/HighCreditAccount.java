package banking;

public class HighCreditAccount extends Account{

	int baseRate;
	int money, deposit;
	char grade;
	int cal=0;
	
	public HighCreditAccount(String acc_num, String name, int balnc, 
				int baseRate , char grade) {
		super(acc_num, name, balnc);
		this.baseRate = baseRate;
		this.grade = grade;
	}
	
	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println("기본이자 : "+ baseRate);
		System.out.println("신용등급 : " + grade);
		System.out.println("----------------------");

		
	}
	
	@Override
	public int cal_rate(int money, int deposit) {
		switch(grade) {
		case 'A':
			cal = (int)Math.floor(money + ( money * baseRate/100 ) + 
					(money * 0.07) + deposit);
		case 'B':
			cal = (int)Math.floor(money + ( money * baseRate/100 ) + 
					(money * 0.04) + deposit);
		
		case 'C':
			cal = (int)Math.floor(money + ( money * baseRate/100 ) + 
					(money * 0.02) + deposit);
		default:
			System.out.println("A,B,C중 하나를 입력하세요.");
			break;
		}	
		return cal;
	}
	
	
}
