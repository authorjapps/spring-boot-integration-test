package integrationtests.uploadfile;

import com.springboot.testrunner.E2eJunitRunner;
import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("application_host.properties")
@RunWith(E2eJunitRunner.class)
public class VerifyFileUpload {

    @Test
    @JsonTestCase("integration_tests/upload_file/file_upload_test.json")
    public void test_uploadFile() throws Exception {
    }

    @Test
    @JsonTestCase("integration_tests/upload_file/file_upload_and_more_params_test.json")
    public void test_uploadFileAndPassMoreParams() throws Exception {
    }

}
