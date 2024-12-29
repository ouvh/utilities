"inside the main use this annotation to enable scheduling @EnableScheduling "

  import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
    
    @Scheduled(fixedRate = 5000)
    public void executeTask() {
        System.out.println("Scheduled task executed");
    }
}

  
