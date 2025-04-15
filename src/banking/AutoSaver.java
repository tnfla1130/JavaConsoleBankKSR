package banking;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;

public class AutoSaver extends Thread{
	private final AccountManager manager;

    public AutoSaver(AccountManager manager) {
        this.manager = manager;
    }
	@Override
	public void run() {

		while(true) {
			try {
				PrintWriter out = new PrintWriter(
		                new FileWriter("src/banking/AutoSaveAccount.txt"));
				
				HashSet<Account> importedAccounts = manager.getAccounts();
				for (Account acc : importedAccounts) {
                    out.println(acc.toString());
                }
				out.flush();
                out.close();
				Thread.sleep(5000);
			}
			catch (Exception e){
				
			}
		}
	}
}
