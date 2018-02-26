package singleton_pattern;

import java.time.LocalDateTime;

public class AppStats {

    private static AppStats instance;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int objectsCreated ;


    private AppStats(){

    }

    public static AppStats instance(){

        synchronized (AppStats.class){
            if(instance == null){
                instance = new AppStats();
            }

            return instance;
        }

    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime  endTime) {
        this.endTime = endTime;
    }

    public int getObjectsCreated() {
        return objectsCreated;
    }

    public void setObjectsCreated(int objectsCreated) {
        this.objectsCreated = objectsCreated;
    }


}
