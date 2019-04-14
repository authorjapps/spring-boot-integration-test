package integrationtests.post;

import com.springboot.testrunner.ZerocodeSpringBootRunner;
import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("application_host.properties")
@RunWith(ZerocodeSpringBootRunner.class)
//@RunWith(ZeroCodeUnitRunner.class) //<-- if you manually start the Spring App i.e. Application.java
public class VerifyPostFeature {

    @Test
    @JsonTestCase("integration_tests/post/post_www_form_header_test.json")
    public void test_postFormDataWithHeaders() throws Exception {
    }

    @Test
    @JsonTestCase("integration_tests/post/post_www_form_header_customer_test.json")
    public void test_postCustomerWithWwwFormData() throws Exception {
    }

    @Test
    @JsonTestCase("integration_tests/post/post_www_form_header_key-value_body_test.json")
    public void test_postCustomerBody_WithWwwFormData() throws Exception {
    }

}
