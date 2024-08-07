package models;

public class Transaction {

    private static Long idIncrementor = 1L;

    private Long id;
    private User user;
    private Car car;
    private Integer price;

    public Transaction(Car car, User user) {
        this.car = car;
        this.user = user;
        this.price = this.car.getPrice();
        this.id = idIncrementor++;
    }

    public Long getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public Integer getPrice() {
        return price;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Transaction [id=" + id + ", user=" + user + ", car=" + car + ", price=" + price + "]";
    }

}
