package integrationtests.get;

import com.springboot.Application;
import java.lang.reflect.Method;
import org.springframework.boot.SpringApplication;

public class MainSpring {
    public static void main2(String[] args) throws Exception{

        final Class<?> clazz = Class.forName("com.springboot.Application");
        SpringApplication.run(clazz);
    }

    public static void main(String[] args) throws Exception{

        final Class<?> clazz = Class.forName("com.springboot.Application");
        final Class<?> springAppLoader = Class.forName("org.springframework.boot.SpringApplication");

        final Method method = clazz.getMethod("run", Class.class, String.class);

        method.invoke(null, clazz);

        SpringApplication.run(clazz);
    }

    public static void main1(String[] argsX) throws Exception{
        try {
            final Class<?> clazz = Class.forName("com.springboot.Application");
            final Method method = clazz.getMethod("main", String[].class);

            final Object[] args = new Object[1];
            args[0] = new String[] { "1", "2"};
            method.invoke(null, args);

            Thread.sleep(5000);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
