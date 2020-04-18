package com.ilkdeneme.demo;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public abstract class AbstractLaunch extends Application {
private static String[] savedArgs;

private ConfigurableApplicationContext applicationContext;

@Override
public void init() {
        applicationContext = SpringApplication.run(getClass(), savedArgs);
        applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
        }

@Override
public void stop() throws Exception {

        super.stop();
        applicationContext.close();
        }

static void launchApp(Class<? extends AbstractLaunch> appClass, String[] args) {

    AbstractLaunch.savedArgs = args;
        Application.launch(appClass, args);
        }}