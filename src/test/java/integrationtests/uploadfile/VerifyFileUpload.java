package integrationtests.uploadfile;

import com.springboot.testrunner.E2eJunitRunner;
import com.springboot.testrunner.httpclient.ProjectApacheHttpClient;
import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.domain.UseHttpClient;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("application_host.properties")
@UseHttpClient(ProjectApacheHttpClient.class)
@RunWith(E2eJunitRunner.class)
public class VerifyFileUpload {

    @Test
    @JsonTestCase("integration_tests/upload_file/file_upload_test.json")
    public void test_createOrUpdateCustomer() throws Exception {
    }

}
