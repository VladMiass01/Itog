import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        ToyFrequency toy1 = new ToyFrequency("1", "Doll", 3);
        ToyFrequency toy2 = new ToyFrequency("2", "Car", 7);
        ToyFrequency toy3 = new ToyFrequency("3", "Puzzle", 4);

        Queue<ToyFrequency> toyQueue = new PriorityQueue<>((t1, t2) -> t2.getFrequency() - t1.getFrequency());

        toyQueue.add(toy1);
        toyQueue.add(toy2);
        toyQueue.add(toy3);

        try {
            FileWriter fileWriter = new FileWriter("result.txt");

            int size_q = 0;
            for (ToyFrequency toy : toyQueue) {
                size_q += toy.getFrequency();
            }

            for (int i = 0; i < size_q; i++) {
                ToyFrequency toy = toyQueue.poll();
                String result = "Toy ID: " + toy.getId() + ", Name: " + toy.getName() + "\n";
                fileWriter.write(result);

                toy.downgradeFrequency();
                toyQueue.add(toy);
            }
            fileWriter.close();
            System.out.println("Result written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}