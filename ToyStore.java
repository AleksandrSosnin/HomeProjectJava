import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class ToyStore {
    private PriorityQueue<Toy> toyQueue;

    public ToyStore() {
        toyQueue = new PriorityQueue<>((t1, t2) -> t2.getFrequency() - t1.getFrequency());
    }

    public void addToy(Toy toy) {
        toyQueue.add(toy);
    }

    public int getRandomToyId() {
        double rand = Math.random();
        int totalFrequency = toyQueue.stream().mapToInt(Toy::getFrequency).sum();
        int cumulativeFrequency = 0;
        for (Toy toy : toyQueue) {
            cumulativeFrequency += toy.getFrequency();
            if (rand * totalFrequency <= cumulativeFrequency) {
                return toy.getId();
            }
        }
        return -1;
    }

    public void saveToFile(String filename, int times) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < times; i++) {
                writer.write(String.valueOf(getRandomToyId()));
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
