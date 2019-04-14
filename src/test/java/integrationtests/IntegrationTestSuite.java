package integrationtests;

import com.springboot.testrunner.ZerocodeSpringBootSuite;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.domain.TestPackageRoot;
import org.junit.runner.RunWith;

/**
 * IntegrationTestSuite runs all the tests as a suite by picking all the tests
 * from "resources/integration_tests" folder and sub-folders.
 *
 * To run individual tests, go to the corresponding package and run the test as JUnit
 * e.g. go to folders >> get, put etc under "src/test/java/integrationtests"
 * and run-
 *      - integrationtests.get.VerifyGetFeature.java
 *      - integrationtests.put.VerifyPutFeature.java
 *      - integrationtests.delete.VerifyDeleteOperation.java
 *      - integrationtests.uploadfile.VerifyFileUpload.java
 */
@TargetEnv("application_host.properties")
@TestPackageRoot("integration_tests") //picks all tests from this folder and subfolders
@RunWith(ZerocodeSpringBootSuite.class)
public class IntegrationTestSuite {

}
