package integrationtests.delete;

import com.springboot.testrunner.ZerocodeSpringBootRunner;
import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("application_host.properties")
@RunWith(ZerocodeSpringBootRunner.class)
public class VerifyDeleteOperation {

    @Test
    @JsonTestCase("integration_tests/delete/delete_existing_customer_by_id_test.json")
    public void test_deleteExistingCustomerDetailsById() throws Exception {
    }

    @Test
    @JsonTestCase("integration_tests/delete/delete_nonexisting_customer_test.json")
    public void test_getUpdatedCustomerDetailsById() throws Exception {
    }

}
