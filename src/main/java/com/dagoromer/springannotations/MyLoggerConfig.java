package com.dagoromer.springannotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Component
public class MyLoggerConfig {
    private String rootLoggerLevel;
    private String printedLoggerLevel;

    @Value("${logger.root.level}")
    public void setRootLoggerLevel(String rootLoggerLevel) {
        this.rootLoggerLevel = rootLoggerLevel;
    }

    @Value("${logger.printed.level}")
    public void setPrintedLoggerLevel(String printedLoggerLevel) {
        this.printedLoggerLevel = printedLoggerLevel;
    }

    @PostConstruct
    public void initLogger() {
        // parse levels
        Level rootLevel = Level.parse(rootLoggerLevel);
        Level printedLevel = Level.parse(printedLoggerLevel);

        // get logger for app context
        Logger applicationContextLogger = Logger.getLogger(AnnotationConfigApplicationContext.class.getName());

        // get parent logger
        Logger loggerParent = applicationContextLogger.getParent();

        // set root logging level
        loggerParent.setLevel(rootLevel);

        // set up console Handler
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(printedLevel);
        consoleHandler.setFormatter(new SimpleFormatter());

        // add handler to logger
        loggerParent.addHandler(consoleHandler);
    }
}
