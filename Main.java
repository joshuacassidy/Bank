import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Bank bank = new Bank("Irish Bank");

        try(BufferedReader locFile = new BufferedReader(new FileReader("src/Customers.txt"));
            BufferedReader dirFile = new BufferedReader(new FileReader("src/CustomersTransactions.txt"))) {
            String addCustomersData,addCustomersTransactionsData;
            addCustomersData = locFile.readLine();
            addCustomersTransactionsData = dirFile.readLine();
            while(true) {
                if(addCustomersData != null){
                    String[] data = addCustomersData.split(",");
                    bank.addBranch(data[0]);
                    bank.addCustomer(data[0], data[1], Double.parseDouble(data[2]));
                    addCustomersData = locFile.readLine();
                }
                else if(addCustomersTransactionsData != null) {
                    String[] data2 = addCustomersTransactionsData.split(",");

                    bank.addCustomerTransaction(data2[0], data2[1], Double.parseDouble(data2[2]));
                    addCustomersTransactionsData = dirFile.readLine();
                }
                else {
                    break;
                }
            }

        }

        String addCustomers[][] = { {"Dublin","Dublin","Dublin","Kerry"},{"Harry","Henry","Harvey","Bob"},{"50.05","175.34","220.12","220.12"} };
        String customerTransactions[][] = { {"Dublin","Dublin","Kerry"},{"Harry","Henry","Bob"},{"44.22","1.65","44.22"} };

        for(Branch county: bank.getBranches()) {
            bank.listCustomers(county.getName(), true);
        }

        try(FileWriter locFile = new FileWriter("src/Customers.txt");
            FileWriter dirFile = new FileWriter("src/CustomersTransactions.txt")) {
            for(int i = 0; i< addCustomers[0].length; i++) {
                locFile.write(String.format("%s, %s, %s\n",addCustomers[0][i],addCustomers[1][i],addCustomers[2][i]));
            }
            for(int i = 0; i< customerTransactions[0].length; i++) {
                dirFile.write(String.format("%s, %s, %s\n",customerTransactions[0][i], customerTransactions[1][i], customerTransactions[2][i]));
            }
        }


    }
}



