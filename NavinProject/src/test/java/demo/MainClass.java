package demo;

import org.testng.TestNG;

public class MainClass {
    static TestNG testng;

    public static void main(String[] args)
    {
        testng=new TestNG();

        testng.setTestClasses(new Class[]{GetRequest.class, PostRequest.class});

        testng.run();
    }
}
