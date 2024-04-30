import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
    private HashMap<String, Customer> customerHashMap = new HashMap();

    //Methods
    public void addCustomer(Customer customer) {
        customerHashMap.put(customer.getPIN(), customer);
    }
    public void removeCustomer(Customer customer){
        customerHashMap.remove(customer.getPIN());
    }
    public Customer getCustomer(String PIN) {
        return customerHashMap.get(PIN);
    }
    public StringBuilder getAllCustomerHashMap(){
        StringBuilder customerStringBuilder = new StringBuilder();
        for (String PIN: customerHashMap.keySet()) {
            customerStringBuilder.append(customerHashMap.get(PIN).toString());

        }
        return customerStringBuilder;
    }
}
