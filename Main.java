import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Bank bank = new Bank("Irish Bank");

        try(BufferedReader customerFile = new BufferedReader(new FileReader("src/Customers.txt"));
            BufferedReader transactions = new BufferedReader(new FileReader("src/Transactions.txt"))) {
            String customersData,transactionsData;
            customersData = customerFile.readLine();
            transactionsData = transactions.readLine();
            while(true) {
                if(customersData != null){
                    String[] data = customersData.split(",");
                    bank.addBranch(data[0]);
                    bank.addCustomer(data[0], data[1], Double.parseDouble(data[2]));
                    customersData = customerFile.readLine();
                }
                else if(transactionsData != null) {
                    String[] data = transactionsData.split(",");

                    bank.addCustomerTransaction(data[0], data[1], Double.parseDouble(data[2]));
                    transactionsData = transactions.readLine();
                }
                else {
                    break;
                }
            }

        }

        String customers[][] = { {"Dublin","Dublin","Dublin","Kerry"},{"Harry","Henry","Harvey","Bob"},{"50.05","175.34","220.12","220.12"} };
        String customerTransactions[][] = { {"Dublin","Dublin","Kerry"},{"Harry","Henry","Bob"},{"44.22","1.65","44.22"} };

        for(Branch county: bank.getBranches()) {
            bank.listCustomers(county.getName(), true);
        }

        try(FileWriter customerFile = new FileWriter("src/Customers.txt");
            FileWriter TransactionsFile = new FileWriter("src/Transactions.txt")) {
            for(int i = 0; i< customers[0].length; i++) {
                customerFile.write(String.format("%s, %s, %s\n",customers[0][i],customers[1][i],customers[2][i]));
            }
            for(int i = 0; i< customerTransactions[0].length; i++) {
                TransactionsFile.write(String.format("%s, %s, %s\n",customerTransactions[0][i], customerTransactions[1][i], customerTransactions[2][i]));
            }
        }


    }
}



