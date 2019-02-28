import java.util.Date;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.gc();
        Repository repository = new Repository();
        Date start = new Date();

        repository.startTest();

        Date end = new Date();
        long time = end.getTime() - start.getTime();

        System.out.println("Тест занял " + time + " секунд");
        System.out.println();
        repository.printResult();
    }
}
