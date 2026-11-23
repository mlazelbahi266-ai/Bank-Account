public class Customer {
    
    private String name;
    private int pin;
    private BankAccount account;
    public Customer(String name , int pin, BankAccount account){

        this.name = name ;
        this.pin = pin ;
        this.account = account;
    }
    public boolean checkPIN(int enteredPIN){
        return  this.pin == enteredPIN;
    }
    public BankAccount getAccount(){
        return account;
    }
}
