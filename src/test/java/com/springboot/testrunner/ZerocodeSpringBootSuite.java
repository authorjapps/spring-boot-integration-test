package com.springboot.testrunner;

import com.springboot.Application;
import org.jsmart.zerocode.core.runner.ZeroCodePackageRunner;
import org.junit.runners.model.InitializationError;

import static com.springboot.testrunner.ZerocodeSpringBootRunner.appRunning;

public class ZerocodeSpringBootSuite extends ZeroCodePackageRunner {

    static{
        // ---------------------------------------------------------------------------
        // appRunning flag is used only when we do a right-click on the "integrationtests"
        // folder via an IDE and run the tests.
        //
        // Usage of appRunning flag is not necessary for Jenkins builds,
        // as Jenkins will run the tests either as a Suite or Individually,
        // but never both.
        // ---------------------------------------------------------------------------
        if(!appRunning){
            Application.start();
            appRunning = true;
        }
    }

    public ZerocodeSpringBootSuite(Class<?> klass) throws InitializationError {
        super(klass);
    }
}
