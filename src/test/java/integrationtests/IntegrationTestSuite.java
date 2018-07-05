package integrationtests;

import com.springboot.runner.E2eJunitSuiteRunner;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.domain.TestPackageRoot;
import org.junit.runner.RunWith;

/**
 * This runs the entire test suite i.e. all tests recursively under "resources/integration_tests"
 * To run individual tests, go to the corresponding package and run the test as JUnit
 * e.g. folders >> get, put etc
 */
@TargetEnv("abc_bankapp_host.properties")
@TestPackageRoot("integration_tests")
@RunWith(E2eJunitSuiteRunner.class)
public class IntegrationTestSuite {

}
