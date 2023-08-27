//https://docs.oracle.com/javase/specs/jls/se20/jls20.pdf
package java;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DataSource {
    private File dataFile;
    private Bank bank;

    public DataSource(File dataFile) {
        this.dataFile = dataFile;
        this.bank = new Bank();
    }

    public void loadData() throws IOException {
        if (!dataFile.exists()) {

        } else {
            System.out.println("Existe");
            Scanner input = new Scanner(dataFile);
            int numAccounts;
            char accountType;

            int numCustomers = input.nextInt();

            for (int i = 0; i < numCustomers; i++) {
                String firstName = input.next();
                String lastName = input.next();
                bank.addCustomer(firstName, lastName, i);
                Customer customer = bank.getCustomer(i);
                numAccounts = input.nextInt();
                System.out.println(numCustomers);

                while (numAccounts-- > 0) {
                    accountType = input.next().charAt(0);
                    float initBalance = Float.parseFloat(input.next());

                    switch (accountType) {
                        case 'S':
                            float interestRate = Float.parseFloat(input.next());
                            customer.addAccount(new SavingAccount(initBalance, interestRate));
                            break;
                        case 'C':
                            float overdraftProtection = Float.parseFloat(input.next());
                            customer.addAccount(new CheckingAccount(initBalance, overdraftProtection));
                            break;
                        default:
                            break;
                    }
                }

            }
        }
    }

    public void generateCustomerReport() {
        System.out.println("\t\t\tCUSTOMERS REPORT");
        System.out.println("\t\t\t================");

        for (int i = 0; i < bank.getNumCustomers(); i++) {
            Customer customer = bank.getCustomer(i);
            System.out.println("Customer:" + customer.getLastName() + ", " + customer.getFirstName());
        }

    }
}
