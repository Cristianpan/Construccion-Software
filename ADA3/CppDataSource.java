import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CppDataSource {
    private File dataFile;

    public CppDataSource(String dataFilePath) {
        this.dataFile = new File(dataFilePath);
    }

    public void loadData() throws IOException {
        Scanner input = new Scanner(this.dataFile);

        if (dataFile.exists()) {
            System.out.println("Existe");
            int customerCount = input.nextInt();

            for (int i = 0; i < customerCount; i++) {
                String firstName = input.next();
                String lastName = input.next();
                Bank.addCustomer(firstName, lastName);

                Customer customer = Bank.getCustomer(i);
                System.out.println(customerCount);
                
                int accountCount = input.nextInt();
                while (accountCount-- > 0) {
                    char accountType = input.next().charAt(0);
                    switch (accountType) {
                        case 'S': {
                            double initialBalance = Float.parseFloat(input.next());
                            double interestRate = Float.parseFloat(input.next());
                            customer.addAccount(new SavingAccount(initialBalance, interestRate));
                            break;
                        }
                        case 'C': {
                            float initialBalance = Float.parseFloat(input.next());
                            float overdraftProtection = Float.parseFloat(input.next());
                            customer.addAccount(new CheckingAccount(initialBalance, overdraftProtection));
                            break;
                        }
                    }
                }
            }
        }
    }

    public void generateCustomerReport() {
        System.out.println("\t\t\tCUSTOMERS REPORT");
        System.out.println("\t\t\t================");

        for (int i = 0; i < Bank.getcostumerCount(); i++) {
            Customer customer = Bank.getCustomer(i);
            System.out.println("Customer: " + customer.getLastName() + ", " + customer.getFirstName());
        }
    }
}