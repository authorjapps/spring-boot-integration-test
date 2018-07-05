package com.springboot.runner;

import com.springboot.Application;
import org.jsmart.zerocode.core.runner.ZeroCodePackageRunner;
import org.junit.runners.model.InitializationError;

public class E2eJunitSuiteRunner extends ZeroCodePackageRunner {

    static{
        Application.start();
    }

    public E2eJunitSuiteRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }
}
