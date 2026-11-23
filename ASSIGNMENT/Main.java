import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        Customer customer = new Customer(
            "student" , 1234 , new BankAccount(1000)
        );
        int attempts = 0;
        boolean loggedIn = false ;

        //Authentication
        while (attempts < 3) {
            System.out.println("Enter your PIN : ");
            int pin = input.nextInt();

            if (customer.checkPIN(pin)) {
                loggedIn = true ;
                System.out.println("Login Successfull!");
                break;
            } else{
                attempts++;
                System.out.println("Incorrect PIN!  ");
                System.out.println("Remaining attempts:" +(3 - attempts));
            }
        }
        if(!loggedIn){
            System.out.println("Account locked!");
            input.close();
            return ;
        }
        int choice;
        //Main Menu
        do{
            System.out.println(" \n=== ATM MENU ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");

            System.out.println("Choose an option :");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    customer.getAccount().checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount :");
                    double deposit = input.nextDouble();

                    customer.getAccount().deposit (deposit);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount:");
                    double withdraw = input.nextDouble();

                    customer.getAccount().withdraw(withdraw);
                    break;

                case 4:
                    customer.getAccount().showHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using ATM!"); 
                    break;  
                    default:
                        System.out.println("Invalid choice!");         
                        

            }

        }while (choice !=5); {
            input.close();
        }

    }
}
