package com.springboot.testrunner;

import com.springboot.Application;
import org.jsmart.zerocode.core.runner.ZeroCodePackageRunner;
import org.junit.runners.model.InitializationError;

public class ZerocodeSpringBootSuite extends ZeroCodePackageRunner {

    static{
        Application.start();
    }

    public ZerocodeSpringBootSuite(Class<?> klass) throws InitializationError {
        super(klass);
    }
}
