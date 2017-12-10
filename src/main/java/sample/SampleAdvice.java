package sample;

import com.aspectran.core.activity.Translet;
import com.aspectran.core.util.logging.Log;
import com.aspectran.core.util.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;

public class SampleAdvice {
    
    private final Log log = LogFactory.getLog(SampleAdvice.class);

    public String welcome(Translet translet) {
        HttpServletRequest req = translet.getRequestAdaptee();
        String ip = req.getRemoteAddr();
        String msg = "Welcome to Aspectran! (" + ip + ")";
        
        log.info(msg);
        
        return msg;
    }
    
    public String goodbye(Translet translet) {
        log.info("activityDataMap " + translet.getActivityDataMap(true));

        String msg = "Goodbye!";
        
        log.info(msg);
        
        return msg;
    }
    
}
