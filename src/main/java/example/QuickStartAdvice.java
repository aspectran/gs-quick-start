package example;

import com.aspectran.core.activity.Translet;
import com.aspectran.core.component.bean.annotation.Aspect;
import com.aspectran.core.component.bean.annotation.Bean;
import com.aspectran.core.component.bean.annotation.Component;
import com.aspectran.core.component.bean.annotation.Description;
import com.aspectran.core.component.bean.annotation.Joinpoint;
import com.aspectran.utils.logging.Logger;
import com.aspectran.utils.logging.LoggerFactory;

import jakarta.servlet.http.HttpServletRequest;

@Component
@Bean("quickStartAdvice")
@Aspect("quickStartAspect")
@Joinpoint(
        pointcut = {
                "+: /gs-quick-start/*/helloWorld@quickStartActivity^helloWorld"
        }
)
@Description(
        "'Hello World'만 출력하기에는 심심한 면이 없지 않아서 내부적으로 특정 Method를 실행하는 기능을 주입시켜 보겠습니다. " +
        "요청 URI가 '/ga-quick-start/'로 시작하고, simplestAction Bean의 helloWorld()를 실행하는 Translet이 발견되면, " +
        "해당 Translet을 실행하기 전에 simplestAdvice Bean의 welcome()을 호출하고, " +
        "해당 Translet을 실행한 후에는 simplestAdvice Bean의 goodbye()를 호출합니다."
)
public class QuickStartAdvice {
    
    private final Logger logger = LoggerFactory.getLogger(QuickStartAdvice.class);

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
