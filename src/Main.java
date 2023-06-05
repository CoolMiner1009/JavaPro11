import java.util.ArrayList;
import java.util.List;





public class Main {
    public static void main(String[] args) {
        PetrolStation petrolStation = new PetrolStation(100);

        Thread thread1 = new Thread(() -> petrolStation.doRefuel(30));
        Thread thread2 = new Thread(() -> petrolStation.doRefuel(20));
        Thread thread3 = new Thread(() -> petrolStation.doRefuel(50));

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All refueling operations completed.");
    }
}

