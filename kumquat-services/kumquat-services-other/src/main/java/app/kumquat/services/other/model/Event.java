package app.kumquat.services.other.model;

public class Event {

    private int amount;

    public Event(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Event{" +
                "amount=" + amount +
                '}';
    }
}
