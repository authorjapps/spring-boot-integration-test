package com.springboot.runner;

import com.springboot.Application;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.runners.model.InitializationError;

public class E2eJunitRunner extends ZeroCodeUnitRunner {

    static{
        Application.start();
    }

    public E2eJunitRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }
}
