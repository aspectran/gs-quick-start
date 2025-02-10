/*
 * Copyright (c) 2015-2024 The Aspectran Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package app.example;

import com.aspectran.core.activity.Translet;
import com.aspectran.core.component.bean.annotation.Aspect;
import com.aspectran.core.component.bean.annotation.Bean;
import com.aspectran.core.component.bean.annotation.Component;
import com.aspectran.core.component.bean.annotation.Description;
import com.aspectran.core.component.bean.annotation.Joinpoint;
import com.aspectran.utils.annotation.jsr305.NonNull;
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
        "요청 URI가 '/ga-quick-start/'로 시작하고, simplestAction Bean의 helloWorld()를 실행하는 Translet이 발견되면, " +
        "해당 Translet을 실행하기 전에 simplestAdvice Bean의 welcome()을 호출하고, " +
        "해당 Translet을 실행한 후에는 simplestAdvice Bean의 goodbye()를 호출합니다."
)
public class QuickStartAdvice {
    
    private final Logger logger = LoggerFactory.getLogger(QuickStartAdvice.class);

    public String welcome(@NonNull Translet translet) {
        HttpServletRequest req = translet.getRequestAdaptee();
        String ip = req.getRemoteAddr();
        String msg = "Welcome to Aspectran! (" + ip + ")";
        
        logger.info(msg);
        
        return msg;
    }
    
    public String goodbye(@NonNull Translet translet) {
        logger.info("activityData " + translet.getActivityData());

        String msg = "Goodbye!";
        
        logger.info(msg);
        
        return msg;
    }
    
}
