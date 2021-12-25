package com.zhu.onemanager.context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author ggBall
 * @version 1.0.0
 * @ClassName OnedriveContext.java
 * @Description TODO
 * @createTime 2021年12月17日 16:29:00
 */
@Component
@Slf4j
public class OnedriveContext implements ApplicationContextAware {





    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    }
}
