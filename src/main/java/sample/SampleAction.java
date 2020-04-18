package sample;

import com.aspectran.core.activity.Translet;
import com.aspectran.core.util.logging.Logger;
import com.aspectran.core.util.logging.LoggerFactory;

public class SampleAction {
    
    private final Logger logger = LoggerFactory.getLogger(SampleAction.class);

    public String helloWorld(Translet translet) {
        String msg = translet.getMessage("hello", new Object[] { "Aspectran" });
        
        logger.info(translet.getMessage("first.action.is", new Object[] { msg }));

        return msg;
    }

}
