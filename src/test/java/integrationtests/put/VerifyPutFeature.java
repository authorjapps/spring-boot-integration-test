package integrationtests.put;

import com.springboot.testrunner.E2eJunitRunner;
import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("abc_bankapp_host.properties")
@RunWith(E2eJunitRunner.class)
public class VerifyPutFeature {

    @Test
    @JsonTestCase("integration_tests/put/create_a_customer_test.json")
    public void test_createOrUpdateCustomer() throws Exception {
    }

    @Test
    @JsonTestCase("integration_tests/put/update_an_existing_customer_test.json")
    public void test_updateExistingCustomer() throws Exception {
    }

}
