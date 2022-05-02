package home.pet.life;

public class Main {

    private static int AREA_SIZE = 5;
    private static int ITERATIONS = 10;


    public static void main(String[] args) throws InterruptedException {
        final Terra terra = new Terra(AREA_SIZE);
        System.out.println("Initial position:");
        terra.depict();
        terra.start(ITERATIONS);
    }
}
