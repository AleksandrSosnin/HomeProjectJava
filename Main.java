public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        // Примеры создания и добавления игрушек
        toyStore.addToy(new Toy(1, "Конструктор", 2));
        toyStore.addToy(new Toy(2, "Робот", 2));
        toyStore.addToy(new Toy(3, "Кукла", 6));

        toyStore.saveToFile("output.txt", 10);
    }
}

