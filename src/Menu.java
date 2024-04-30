import java.util.Scanner;
public class Menu {

    //Instances
    private Scanner myScan = new Scanner(System.in);
    private Bank bank = new Bank();

    //Methods
    public void displayMenu() {
        while (true) {
            String selection;
            System.out.printf("\n%s Menu %s\n", "*".repeat(9), "*".repeat(9));
            System.out.print("Please Make A Selection:\n" +
                    "1) Access Account\n" +
                    "2) Open A New Account\n" +
                    "3) Close All Accounts\n" +
                    "4) Exit\n" +
                    " >> ");
            selection = myScan.nextLine();
            if (selection.equals("1")) {
                accessAccount();

            } else if (selection.equals("2")) {
                createAccount();

            } else if (selection.equals("3")) {
                closeAccount();

            } else if (selection.equals("4")) {
                System.out.println("Thank you for using BSU Banking App" +
                        "\nGoodbye. Exiting...");
                break;
            } else {
                System.out.println("Invalid Entry, Try Again Or Exit!");
            }
        }
    }


    //Access Account Method
    private void accessAccount() {
        String PIN;
        String Balance;
        Customer customer;
        Account account;

        System.out.println("Please enter your PIN: ");
        PIN = myScan.nextLine();

        customer = bank.getCustomer(PIN);
        if (customer == null) {
            System.out.println("PIN is invalid.");
            return;

        }

        System.out.println("***Active Accounts***\n");
        System.out.println(customer.getAllAccountArrayList());
        System.out.println("Enter in the account number ");
        int acn = Integer.parseInt(myScan.nextLine());
        account = customer.getAccount(acn);
        if (account == null) {
            System.out.println("Account number invalid.");
            return;
        }
        while (true) {
            System.out.printf("\n%s MENU %s\n", "*".repeat(9), "*".repeat(9));
            System.out.print("Please make a selection:\n" +
                    "1) Make a deposit\n " +
                    "2) Make a withdrawn\n" +
                    "3) See account balance\n " +
                    "4) Close account\n" +
                    "5) Exit\n" +
                    ">>");
            String selection = myScan.nextLine();
            if (selection.equals("1")) {
                System.out.println("Enter the deposit: ");
                double amount = Double.parseDouble(myScan.nextLine());
                account.deposit(amount);
            } else if (selection.equals("2")) {
                System.out.println("Enter the amount you would like: ");
                double amount = Double.parseDouble(myScan.nextLine());
                account.withdraw(amount);
            } else if (selection.equals("3")) {
                System.out.println(account);
            } else if (selection.equals("4")) {
                customer.removeAccount(account);
                System.out.println("Account has been closed " + account.getAccountNumber());
            } else if (selection.equals("5")) {
                break;

            } else {
                System.out.println("Invalid Entry.");
            }
        }
    }

    // Create new Customer
    private Customer createNewCustomer() {
        String firstName;
        String lastName;
        String PIN;
        System.out.println("Please enter your first name: ");
        firstName = myScan.nextLine();
        System.out.println("Please enter your last name: ");
        lastName = myScan.nextLine();
        System.out.println("Please enter a 4 digit PIN: ");
        PIN = myScan.nextLine();
        Customer customer = new Customer(firstName, lastName, PIN);
        bank.addCustomer(customer);
        return customer;
    }


    //Open Account Method
    private void createAccount() {
        String firstName;
        String lastName;
        String PIN;
        double deposit;
        String customerR;
        Customer customer;
        Account account;


        System.out.println("Are you a new customer?\n1) Yes\n2) No");
        customerR = myScan.nextLine();
        if (customerR.equals("1")) {
            customer = createNewCustomer();
            customerR = myScan.nextLine();
        } else {
            System.out.println("Please enter a 4 digit PIN: ");
            PIN = myScan.nextLine();
            customer = bank.getCustomer(PIN);
            if (customer == null) {
                System.out.println("PIN is invalid");
                return;
            }
            System.out.println("Please enter deposit amount: ");
            deposit = Double.parseDouble(myScan.nextLine());
            System.out.println("Do you want to add Interest to your account?");
            String input = myScan.nextLine();
            if (input.equals("Yes")) {
                System.out.println("How much interest do you want to add?");
                double interest = Double.parseDouble(myScan.nextLine());
                account = new InterestAccount(deposit, interest/100);
            } else {
                account = new Account(deposit);
            }
            customer.addAccount(account);
            System.out.println("New account open! " + account.getAccountNumber());
        }
    }
        //Delete Account Method
        private void closeAccount () {
            Customer customer;
            String PIN;

            System.out.print("Please enter your PIN: ");
            PIN = myScan.nextLine();
            customer = bank.getCustomer(PIN);
            if (customer == null) {
                System.out.println("PIN is invalid.");
            } else {
                bank.removeCustomer(customer);
                System.out.print("You have been removed from the bank registry.");
            }


        }
    }













