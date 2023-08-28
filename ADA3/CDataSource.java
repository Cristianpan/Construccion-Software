import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CDataSource {
    private File data_file;

    public CDataSource(String data_file_path) {
        this.data_file = new File(data_file_path);
    }

    public void load_data() throws IOException {
        Scanner input = new Scanner(this.data_file);

        if (data_file.exists()) {
            System.out.println("Existe");
            int customer_count = input.nextInt();

            for (int i = 0; i < customer_count; i++) {
                String first_name = input.next();
                String last_name = input.next();
                Bank.add_customer(first_name, last_name);

                Customer customer = Bank.get_customer(i);
                System.out.println(customer_count);
                
                int account_count = input.nextInt();
                while (account_count-- > 0) {
                    char account_type = input.next().charAt(0);
                    switch (account_type) {
                        case 'S': {
                            double initial_balance = Float.parseFloat(input.next());
                            double interest_rate = Float.parseFloat(input.next());
                            customer.add_account(new SavingAccount(initial_balance, interest_rate));
                            break;
                        }
                        case 'C': {
                            float initial_balance = Float.parseFloat(input.next());
                            float overdraft_protection = Float.parseFloat(input.next());
                            customer.add_account(new CheckingAccount(initial_balance, overdraft_protection));
                            break;
                        }
                    }
                }
            }
        }
    }

    public void generate_customer_report() {
        System.out.println("\t\t\tCUSTOMERS REPORT");
        System.out.println("\t\t\t================");

        for (int i = 0; i < Bank.get_costumer_count(); i++) {
            Customer customer = Bank.get_customer(i);
            System.out.println("Customer: " + customer.get_last_name() + ", " + customer.get_first_name());
        }
    }
}