package sample;

import com.aspectran.core.activity.Translet;
import com.aspectran.core.util.logging.Logger;
import com.aspectran.core.util.logging.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class SampleAdvice {
    
    private final Logger logger = LoggerFactory.getLogger(SampleAdvice.class);

    public String welcome(Translet translet) {
        HttpServletRequest req = translet.getRequestAdaptee();
        String ip = req.getRemoteAddr();
        String msg = "Welcome to Aspectran! (" + ip + ")";
        
        logger.info(msg);
        
        return msg;
    }
    
    public String goodbye(Translet translet) {
        logger.info("activityData " + translet.getActivityData());

        String msg = "Goodbye!";
        
        logger.info(msg);
        
        return msg;
    }
    
}
