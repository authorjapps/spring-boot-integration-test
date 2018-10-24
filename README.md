# Spring-boot application - Integration-testing
This demo project exaplins how [JUnit](https://github.com/junit-team/junit4) and [Zerocode](https://github.com/authorjapps/zerocode) test framework based integration-tests for a spring-boot application can make everyone's life easy everyday. 

> Keep it simple and easy while doing the integration tests

## Spring boot + Spring Data + H2 in-memory DB

+ See here a [Reference Implementation](https://github.com/BeTheCodeWithYou/SpringBoot-ZeroCode-Integration) (**Author** - Neeraj Sidhaye @BeTheCodeWithYou)
+ What all stuffs the above [project](https://github.com/BeTheCodeWithYou/SpringBoot-ZeroCode-Integration) covers or why it is **useful** for developers as well as testers?
  + This project shows Fail-Fast approach and how easily you can do integration testing
  + How you should or you can set up your build pipe line to achieve zero defect APIs
  + Lists how envvironment switching to CI/DIT/SIT/UAT(ci2/dit2/sit2) is so easy and effortless
  + Covers how the smart test reports can be useful to trace test failures
  + How the entire test suite can be **reused** as a regression pack for testers(the below article explains that)
  + How the Developers and Test-Engineers can collaborate for the best quality APIs
  + This [article @Medium](https://medium.com/@bethecodewithyou/develop-zerodefect-apis-with-zerocode-cadd9dc2a430) exaplains step by step approach for achieving zero defect APIs (_same author_)


##### Needed maven dependencies
```xml
<dependency>
    <groupId>org.jsmart</groupId>
    <artifactId>zerocode-rest-bdd</artifactId>
    <version>1.2.x</version> 
</dependency>
```
```xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>
```

![Integration_tests_organization](img/it_tests_org_S.png)

### Where are the integration tests?
+ The JUnit integration tests are located under-
  + test/java/integrationtests/get
  + test/java/integrationtests/put

You can run and debug them individually.
  
### Where is the Suite to run all the tests?
The suite JUnit suite test located-
+ `src/test/java/integrationtests/IntegrationTestSuite.java`

### Where are the unit tests cases?
The JUnit unit tests are located **as usual** in their respective package, under root of-
+ `src/test/java/com/springboot` i.e. under package `com.springboot`

### How do they both run in the maven life cycle?
e.g.
> mvn clean install

+ The unit tests run as usual in the `test` phase
+ Then the integration-tests are fired in the `<goal>integration-test</goal>` as configured in the `pom.xml`

```     
  <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-failsafe-plugin</artifactId>
      <executions>
          <execution>
              <goals>
                  <goal>integration-test</goal>
                  <goal>verify</goal>
              </goals>
              <configuration>
                  <includes>
                      <include>integrationtests.IntegrationTestSuite.java</include>
                  </includes>
              </configuration>
          </execution>
      </executions>
  </plugin>
```     

+ Please look at the the Suite-Test class `<include>integrationtests.IntegrationTestSuite.java</include>` which is pointing 
to the root of the tests in the test-resources folder `resource/integration_tests`

i.e. as below-
```
@TargetEnv("abc_bankapp_host.properties")
@TestPackageRoot("integration_tests")  //You can point this to any package you need -or- use ususal Junit Suite runner
@RunWith(E2eJunitSuiteRunner.class)
public class IntegrationTestSuite {

}
```

### What does the above @RunWith do?
> @RunWith(E2eJunitSuiteRunner.class)

Ans: It starts the spring applications and then fires the tests once by one.
See below how it brings up the application.
```
public class E2eJunitSuiteRunner extends ZeroCodePackageRunner {

    static{
        Application.start();
    }

    public E2eJunitSuiteRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }
}
```

[How do I do integration testing of a spring boot application]: https://github.com/authorjapps/spring-boot-integration-test#spring-boot-integration-test
[How to do integration testing of a spring boot application]: https://github.com/authorjapps/spring-boot-integration-test#spring-boot-integration-test
[Integration testing of a spring boot application]: https://github.com/authorjapps/spring-boot-integration-test#spring-boot-integration-test
[Zerocode testing of a spring boot application]: https://github.com/authorjapps/spring-boot-integration-test#spring-boot-integration-test
[Zerocode JSON testing of a spring boot application]: https://github.com/authorjapps/spring-boot-integration-test#spring-boot-integration-test
[Zerocode testing of a spring application]: https://github.com/authorjapps/spring-boot-integration-test#spring-boot-integration-test
