package pojo;

public class IdCard {

    @Override
    public String toString() {
        return "IdCard{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }

    private int id;
    private double money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
