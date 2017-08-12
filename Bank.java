import java.util.ArrayList;
public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName){
        if(findBranch(branchName) == null){
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount){
        Branch branch = findBranch(branchName);
        if(branch != null){
            return branch.newCustomer(customerName,initialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName,double amount){
        Branch branch = findBranch(branchName);
        if(branch != null){
            return branch.addCustomerTransaction(customerName,amount);
        }
        return false;
    }

    private Branch findBranch(String branchName){
        for(Branch checkedBranch: branches){
            if(checkedBranch.getName().equals(branchName)){
                return checkedBranch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions){
        Branch branch = findBranch(branchName);
        if (branch != null){
            System.out.printf("Customer details for %s\n",  branch.getName());
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for(Customer branchCustomer: branchCustomers) {
                System.out.printf("Customer: %s\n", branchCustomer.getName());
                if (showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for(double transaction: transactions){
                        System.out.printf("Amount: %s\n", transaction);
                    }
                }
            }
            return true;
        }
        return false;
    }


}
