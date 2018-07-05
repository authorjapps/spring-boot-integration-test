package integrationtests.get;

import com.springboot.runner.E2eJunitRunner;
import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("abc_bankapp_host.properties")
@RunWith(E2eJunitRunner.class)
public class VerifyGetContract {

    @Test
    @JsonTestCase("integration_tests/get/get_customer_by_id_test.json")
    public void test_getCustomerDetailsById() throws Exception {
    }

}
