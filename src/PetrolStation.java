public class PetrolStation {
    private volatile int amount;

    public PetrolStation(int initialAmount) {
        this.amount = initialAmount;
    }

    public synchronized void doRefuel(int requestedAmount) {
        if (requestedAmount > amount) {
            System.out.println("Not enough fuel available.");
            return;
        }

        System.out.println("Refueling started.");

        try {
            Thread.sleep((long) (3000 + Math.random() * 7000)); // Затримка від 3 до 10 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        amount -= requestedAmount;
        System.out.println("Refueling completed. Remaining fuel: " + amount);
    }
}