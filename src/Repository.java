import java.util.*;

/**
 * Created by Иван on 28.02.2019.
 */
class Repository {
    private Map<String, String> map;
    private List<Thread> threadList = new ArrayList<>();
    private long threadWorkTimeMills;

    Repository() {
        this(Collections.synchronizedMap(new HashMap<>()), 500, 100);
    }

    Repository(Map<String, String > map, int threadsCount, long threadWorkTimeMills) {
        this.map = map;
        this.threadWorkTimeMills = threadWorkTimeMills;
        for (int i = threadsCount; i > 0; i--) {
            threadList.add(new UserWhoWantToDeleteLink(map, threadWorkTimeMills));
        }
    }

    void startTest() throws InterruptedException {
        for (Thread thread : threadList) {
            thread.start();
        }
        for (Thread thread : threadList) {
            thread.join();
        }
    }

    void printResult() {
        if (map.isEmpty()) {
            System.out.println("Успех, нет ошибок синхронизации!");
        } else {
            throw new RuntimeException("Репозиторий содержит элементы, ошибка синхронизации!");
        }
    }

}
