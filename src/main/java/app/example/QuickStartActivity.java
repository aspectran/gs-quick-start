/*
 * Copyright (c) 2015-present The Aspectran Project
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
import com.aspectran.core.component.bean.annotation.Advisable;
import com.aspectran.core.component.bean.annotation.Bean;
import com.aspectran.core.component.bean.annotation.Component;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Bean("quickStartActivity")
public class QuickStartActivity {
    
    private final Logger logger = LoggerFactory.getLogger(QuickStartActivity.class);

    @Advisable
    public String helloWorld(@NonNull Translet translet) {
        String msg = translet.getMessage("hello", new Object[] { "Aspectran" });
        
        logger.info(translet.getMessage("first_action_is", new Object[] { msg }));

        return msg;
    }

}
