public class main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Client c1 = new Client("Gabriel"),
                c2 = new Client("Carlos");

        c1.getChecking().deposit(200);
        c1.getChecking().withdraw(100);
        c1.getSaving().deposit(300);
        c1.getSaving().withdraw(50);

        c2.getChecking().deposit(400);
        c2.getChecking().withdraw(200);
        c2.getSaving().deposit(600);
        c2.getSaving().withdraw(540);

        bank.add(c1);
        bank.add(c2);

        for(Client c : bank.getClients()){
            c.getSaving().extract();
            c.getChecking().extract();
        }
    }
}
