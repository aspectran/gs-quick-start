package sample;

import com.aspectran.core.activity.Translet;
import com.aspectran.core.util.logging.Log;
import com.aspectran.core.util.logging.LogFactory;

public class SampleAction {
    
    private final Log log = LogFactory.getLog(SampleAction.class);

    public String helloWorld(Translet translet) {
        String msg = translet.getMessage("hello", new Object[] { "Aspectran" });
        
        log.info(translet.getMessage("first.action.is", new Object[] { msg }));

        return msg;
    }

}
