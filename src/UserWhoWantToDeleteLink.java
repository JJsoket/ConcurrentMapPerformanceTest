import java.util.Map;

/**
 * Created by Иван on 28.02.2019.
 */
class UserWhoWantToDeleteLink extends Thread {
    private Map<String, String> map;
    private long workTime;

    UserWhoWantToDeleteLink(Map<String, String> map, long workTime) {
        this.map = map;
        this.workTime = workTime;
        setDaemon(true);
    }

    @Override
    public void run() {
        String id = Thread.currentThread().getName();
        for (int i = 0; i < 100; i++) {
            map.put(id, String.valueOf(i));
            if (map.containsKey(id)) {
                map.remove(id);
            }
            try {
                Thread.sleep(workTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


