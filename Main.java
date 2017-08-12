public class Main {
    public static void main(String[] args){
        Bank bank = new Bank("Irish Bank");


        bank.addBranch("Dublin");
        bank.addBranch("Kerry");

        bank.addCustomer("Dublin", "Harry", 50.05);
        bank.addCustomer("Dublin", "Henry", 175.34);
        bank.addCustomer("Dublin", "Harvey", 220.12);

        bank.addCustomer("Kerry", "Bob", 220.12);
        bank.addCustomerTransaction("Kerry", "Bob", 44.22);


        bank.addCustomerTransaction("Dublin", "Harry", 44.22);
        bank.addCustomerTransaction("Dublin", "Henry", 1.65);

        bank.listCustomers("Dublin", true);
        bank.listCustomers("Kerry", true);


    }
}
