package banking;



public class AccountManager {
	
	private Account[] acc;
	//정보 카운트용 변수 생성 
	private int numAcc;
	
	//생성자 
	public AccountManager(int num) {
		acc = new Account[num];	
		//카운트용 변수는 0으로 초기화 
		numAcc = 0;
	}
 
	public void makeAccount() {
		int choice;
		System.out.println("***신규계좌개설***");
		System.out.println("-----계좌선택------");
		System.out.println("1.보통계좌");
		System.out.println("2.신용신뢰계좌");
		choice = BankingSystemMain.scan.nextInt();
		BankingSystemMain.scan.nextLine();
		switch(choice) {
		case 1:
			makeNormalAccount();
			break;
		case 2:
			makeHighAccount();
			break;
		}
		
	}
	public void makeNormalAccount() {
		String acc_num, name;
		int balnc, rate;
		
		System.out.println("계좌번호 : ");
		acc_num = BankingSystemMain.scan.nextLine();
		System.out.println("이름 : ");
		name = BankingSystemMain.scan.nextLine();
		System.out.println("잔고 : ");
		balnc = BankingSystemMain.scan.nextInt();
		System.out.print("기본이자%(정수형태로입력):"); 
		rate = BankingSystemMain.scan.nextInt();
		NormalAccount normal = new NormalAccount(acc_num, name, balnc, rate);
		acc[numAcc++] = normal;
		System.out.println("계좌개설이 완료되었습니다.");
	}
	
	public void makeHighAccount() {
		String acc_num, name;
		int balnc, rate;
		char grade;
		
		System.out.println("계좌번호 : ");
		acc_num = BankingSystemMain.scan.nextLine();
		System.out.println("이름 : ");
		name = BankingSystemMain.scan.nextLine();
		System.out.println("잔고 : ");
		balnc = BankingSystemMain.scan.nextInt();
		System.out.print("기본이자%(정수형태로입력):"); 
		rate = BankingSystemMain.scan.nextInt();
		System.out.print("신용등급(A,B,C등급):"); 
		grade = BankingSystemMain.scan.next().charAt(0);
		HighCreditAccount high = 
				new HighCreditAccount(acc_num, name, balnc, rate, grade);
		acc[numAcc++] = high;
		System.out.println("계좌개설이 완료되었습니다.");
	}
		
 
	public void showAccInfo() {
		for(int i=0 ; i<numAcc ; i++) {
			acc[i].showAccInfo();			
		}
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}
	
	public void depositMoney() {
		String accNum;
		int Money;
		System.out.println("***입  금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요.");
		System.out.print("계좌번호 : ");
		accNum = BankingSystemMain.scan.nextLine();
		System.out.print("입금액 : ");
		Money = BankingSystemMain.scan.nextInt();
		BankingSystemMain.scan.nextLine();
		if(Money<0) 
		for(Account account : acc) {
			if (account == null) continue;
			if(accNum.equals(account.acc_num)) {
				
				if(account instanceof NormalAccount) {
					NormalAccount normal = (NormalAccount) account;
					account.balnc = normal.cal_rate(account.balnc,Money);
				}
				
				else if (account instanceof HighCreditAccount) {
					HighCreditAccount high = (HighCreditAccount) account;
					account.balnc = high.cal_rate(account.balnc,Money);
				}
			}
		}
	}
	
	public void withdrawMoney() {
		String accNum;
		int Money;
		System.out.println("***출  금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요.");
		System.out.print("계좌번호 : ");
		accNum = BankingSystemMain.scan.nextLine();
		System.out.print("출금액 : ");
		Money = BankingSystemMain.scan.nextInt();
		
		if (Money > 0) {
			for(int i=0 ; i<numAcc ; i++) {
				if(accNum.compareTo(acc[i].acc_num)==0) {	 
					acc[i].balnc -= Money;			
					System.out.println("출금이 완료되었습니다.");
				}
			}
		}
	}
	
}


























