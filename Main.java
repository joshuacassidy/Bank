import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Bank bank = new Bank("Irish Bank");

        try(BufferedReader customerFile = new BufferedReader(new FileReader("src/Customers.txt"));
            BufferedReader transactions = new BufferedReader(new FileReader("src/Transactions.txt"))) {
            String customersData = customerFile.readLine();
            String transactionsData = transactions.readLine();
            while(customersData != null || transactionsData != null) {
                if(customersData != null){
                    String[] data = customersData.split(",");
                    bank.addBranch(data[0]);
                    bank.addCustomer(data[0], data[1], Double.parseDouble(data[2]));
                    customersData = customerFile.readLine();
                }
                else {
                    String[] data = transactionsData.split(",");
                    bank.addCustomerTransaction(data[0], data[1], Double.parseDouble(data[2]));
                    transactionsData = transactions.readLine();
                }

            }

        }

        for(Branch county: bank.getBranches()) {
            bank.listCustomers(county.getName(), true);
        }

    }
}



