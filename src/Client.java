public class Client {

    private String name;
    private Account checking ,saving;


    public Client(String name) {
        this.name = name;
        this.checking = new CheckingAccount();
        this.saving = new SavingAccount();
    }

    public Account getChecking() {
        return checking;
    }

    public Account getSaving() {
        return saving;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
