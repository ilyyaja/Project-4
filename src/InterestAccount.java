
public class InterestAccount extends Account {

    //Instance
    private double percentage;


    //Constructor
    public InterestAccount(double intialDeposit, double percentage) {
        super(intialDeposit);
        this.percentage = percentage;
    }

    @Override
    public void deposit(double amount) {
        double interest = percentage * amount;
        super.deposit(amount + interest);

    }
}
