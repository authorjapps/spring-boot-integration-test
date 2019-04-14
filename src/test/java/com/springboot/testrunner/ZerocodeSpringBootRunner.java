package com.springboot.testrunner;

import com.springboot.Application;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.runners.model.InitializationError;

public class ZerocodeSpringBootRunner extends ZeroCodeUnitRunner {
    public ZerocodeSpringBootRunner(Class<?> klass) throws InitializationError {
        super(klass);
        Application.start();
    }
}
