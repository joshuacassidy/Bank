public class Main {
    public static void main(String[] args){
        Bank bank = new Bank("Irish Bank");

        String[] counties ={"Dublin","Kerry"};

        for(String county: counties) bank.addBranch(county);

        String addCustomers[][] = { {"Dublin","Dublin","Dublin","Kerry"},{"Harry","Henry","Harvey","Bob"},{"50.05","175.34","220.12","220.12"} };
        String customerTransactions[][] = { {"Dublin","Dublin","Kerry"},{"Harry","Henry","Bob"},{"44.22","1.65","44.22"} };

        for(int i = 0; i< addCustomers[0].length; i++)
            // First Parameter is for where branch is, Secound for the name of the customer,third for their initial balance.
            bank.addCustomer(addCustomers[0][i], addCustomers[1][i], Double.parseDouble(addCustomers[2][i]));

        for(int i = 0; i< customerTransactions[0].length; i++)
            // First Parameter is for where branch is, Secound for the name of the customer,third for the transaction balance.
            bank.addCustomerTransaction(customerTransactions[0][i], customerTransactions[1][i], Double.parseDouble(customerTransactions[2][i]));

        for(String county: counties)
            bank.listCustomers(county,true);



    }
}
