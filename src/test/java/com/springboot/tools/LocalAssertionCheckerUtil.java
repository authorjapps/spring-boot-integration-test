package com.springboot.tools;

import com.springboot.testrunner.ZerocodeSpringBootRunner;
import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ZeroCodeUnitRunner.class)
public class LocalAssertionCheckerUtil {

    @Test
    @JsonTestCase("project_files/demo/actual_vs_expected_local_test.json")
    public void testActualVsExpected() throws Exception {
    }

    @Test
    @JsonTestCase("project_files/demo/actual_vs_expected_local_test_more.json")
    public void testActualVsExpectedMoreSamples() throws Exception {
    }

}
