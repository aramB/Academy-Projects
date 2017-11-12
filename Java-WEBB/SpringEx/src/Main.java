public class Main
{
	public static void main(String[] args) {

		Logger logger = new Logger();
		DBLogger dbLogger = new DBLogger();
		XMLLogger xmlLogger = new XMLLogger();

		Bank bank = new Bank(dbLogger);
		bank.deposit(100);
	}
}


class Bank
{
	private ILogger logger;

	public Bank(ILogger logger) {
		this.logger = logger;
	}

	public void deposit(int amount) {
		logger.logMessage("Deposited " + amount + " Sek");
		System.out.println("Deposited " + amount + " Sek");
	}
}


class Logger implements ILogger
{
	public void logMessage(String message) {
		System.out.println("Logged: " + message);
	}
}


class DBLogger implements ILogger
{
	public void logMessage(String message) {
		System.out.println("DBLogged: " + message);
	}
}

class XMLLogger implements ILogger
{
	public void logMessage(String message){
		System.out.println("XML Logged: " + message);
	}
}