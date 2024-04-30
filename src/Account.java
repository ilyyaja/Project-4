public class Account {
    //Instance Variables
    private double balance;
    private int accountNumber;
    private static int numberOfAccounts = 1000;

    //Constructor
    public Account(double intialDeposit) {
        this.balance = intialDeposit;
        this.accountNumber = Account.numberOfAccounts++;
    }
    //Methods
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Your current Balance  " + balance);
        System.out.printf("You have deposited $%s",amount);
    }
    public void withdraw(double amount) {
        if(amount > balance){
            System.out.println("Insufficient funds. ");
        } else {
            balance -= amount;
            System.out.printf("You have withdrawn $%s\n",amount);
            System.out.printf("Your new balance is $%s\n",balance);
        }

    }

    //to String()
    @Override
    public String toString() {
        return String.format("Balance: %s\nAccount Number:%s\n:",
                balance, accountNumber);
    }
    //Getters & Setters
    public int getAccountNumber() {
        return Account.numberOfAccounts;
    }
}

