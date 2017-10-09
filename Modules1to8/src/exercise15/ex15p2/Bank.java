package exercise15.ex15p2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class Bank
{
	public void sendMoney(int amount, String fromAccount, String toAccount) throws IOException {
		//String logstr = "";
		int paymentCost = calculatePaymentCost(amount, fromAccount, toAccount);
		System.out.println("Payment cost: " + paymentCost);

		Receipt receipt = new Receipt();
		receipt.getReceipt(amount, fromAccount, toAccount, paymentCost);

		Logging logging = new Logging();
		logging.writeLogg(amount, fromAccount, toAccount, paymentCost);
	}

	private int calculatePaymentCost(final int amount, final String fromAccount, final String toAccount) throws IOException {
		int paymentCost = 10;
		if (amount > 1000) {
			paymentCost = 50;
		}
		return paymentCost;
	}
}

class Receipt {
	public void getReceipt(final int amount, final String fromAccount, final String toAccount, final int paymentCost)
				throws IOException
		{
			//save a receipt to disk
			String reciept =
					"Bank transfer reciept\r\n" +
					"\r\nDate: " + LocalDateTime.now() +
					"\r\nAmount:" + amount +
					"\r\nCost: " + paymentCost +
					"\r\nFrom account:" + fromAccount +
					"\r\nTo account:" + toAccount +
					"\r\n";

			Files.write(Paths.get("./confirmation.txt"), reciept.getBytes(), StandardOpenOption.CREATE);
		}
}

class Logging
{
	public void writeLogg(final int amount, final String fromAccount, final String toAccount, final int paymentCost)
			throws IOException
	{
		String logstr;//Write to a log file for debugging purposes
		logstr = "Bank auditlog" + "\r\n";
		Files.write(Paths.get("./log.txt"), logstr.getBytes(), StandardOpenOption.CREATE);
		logstr = "Doing a desposit of " + amount + " Sek from " + fromAccount + " to " + toAccount + "\r\n";
		Files.write(Paths.get("./log.txt"), logstr.getBytes(), StandardOpenOption.APPEND);
		logstr = "Payment cost" + paymentCost + "\r\n";
		Files.write(Paths.get("./log.txt"), logstr.getBytes(), StandardOpenOption.APPEND);
		System.out.printf("Payment cost " + paymentCost);
	}
}

