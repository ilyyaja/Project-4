import java.util.ArrayList;

public class Customer {

    private ArrayList<Account> accountArrayList = new ArrayList<>();


    //Instances
    private String firstName;
    private String lastName;
    private String PIN;


    //Constructors
    public Customer(String firstName, String lastName,
                    String PIN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.PIN = PIN;

    }

    //Methods
    public void addAccount(Account account) {
        accountArrayList.add(account);
    }

    public void removeAccount(Account account) {
        accountArrayList.remove(account);
    }

    public Account getAccount(int accountNumber) {
        Account foundAccount = null;
        for (Account account : accountArrayList) {
            if (account.getAccountNumber()==(accountNumber)) {
                foundAccount = account;
                break;
                //return account;

            }

        }
        return foundAccount;
    }
    public StringBuilder getAllAccountArrayList() {
        StringBuilder accountStringBuilder = new StringBuilder();
        for (Account account: accountArrayList) {
            accountStringBuilder.append(account.toString());

        }
        return accountStringBuilder;
    }
    //to String()
    @Override
    public String toString() {
        return String.format("Name: %s %s\nPIN:%s\n:",
                firstName, lastName, PIN);
    }



    //Getters & Setters
    public String getPIN() {
        return PIN;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    }







