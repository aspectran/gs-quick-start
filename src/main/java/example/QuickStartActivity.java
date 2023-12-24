package example;

import com.aspectran.core.activity.Translet;
import com.aspectran.core.component.bean.annotation.Bean;
import com.aspectran.core.component.bean.annotation.Component;
import com.aspectran.utils.logging.Logger;
import com.aspectran.utils.logging.LoggerFactory;

@Component
@Bean("quickStartActivity")
public class QuickStartActivity {
    
    private final Logger logger = LoggerFactory.getLogger(QuickStartActivity.class);

    public String helloWorld(Translet translet) {
        String msg = translet.getMessage("hello", new Object[] { "Aspectran" });
        
        logger.info(translet.getMessage("first_action_is", new Object[] { msg }));

        return msg;
    }

}
