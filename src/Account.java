import java.text.NumberFormat;
import java.util.ArrayList;

public abstract class Account implements IAccount {

    private static final int DEFAULT_AGENCY = 1;
    private static int SEQUENCIAL = 0;
    protected int agency;
    protected int number;
    protected double balance;
    private ArrayList<String> historic;

    public Account() {
        historic = new ArrayList<>();
        historic.add("============================ EXTRACT ============================");

        agency = DEFAULT_AGENCY;
        number = SEQUENCIAL;

        SEQUENCIAL++;
    }


    public int getAgency() {
        return agency;
    }

    public void setAgency(int agency) {
        this.agency = agency;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void withdraw(double value) {
        this.balance -= value;

        historic.add("WITHDRAW - R$" + NumberFormat.getCurrencyInstance().format(value) + "\n");
    }

    @Override
    public void deposit(double value) {
        this.balance += value;

        historic.add("DEPOSIT - R$" + NumberFormat.getCurrencyInstance().format(value) + "\n");
    }

    @Override
    public void transfer(double value, Account account) {
        this.withdraw(value);
        account.deposit(value);
    }

    @Override
    public void extract(){
        historic.add("TOTAL = " +
                NumberFormat.getCurrencyInstance().format(this.balance));

        for(String s : historic){
            System.out.println(s);
        }
    }
}
