package integrationtests;

import com.springboot.testrunner.E2eJunitSuiteRunner;
import com.springboot.testrunner.httpclient.ProjectApacheHttpClient;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.domain.TestPackageRoot;
import org.jsmart.zerocode.core.domain.UseHttpClient;
import org.junit.runner.RunWith;

/**
 * This runs the entire test suite i.e. picking all tests under "resources/integration_tests"
 * recursively.
 *
 * To run individual tests, go to the corresponding package and run the test as JUnit
 * e.g. go to folders >> get, put etc under "src/test/java/integrationtests"
 * and run-
 *      - integrationtests.get.VerifyGetFeature.java
 *      - integrationtests.put.VerifyPutFeature.java
 *      - integrationtests.delete.VerifyDeleteOperation.java
 */
@TargetEnv("application_host.properties")
@TestPackageRoot("integration_tests") //picks all tests from this folder and subfolders
@UseHttpClient(ProjectApacheHttpClient.class)
@RunWith(E2eJunitSuiteRunner.class)
public class IntegrationTestSuite {

}
