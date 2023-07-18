package hw3.carina.demo;

import hw3.carina.demo.tests.HttpTest;

public class Main 
{
    public static void main(String[] args)
    {
        HttpTest httpTests = new HttpTest();
        //httpTests.testGet();
        httpTests.testPost();
        //httpTests.testPostWithMissingField();
        //httpTests.testPatch();
    }
}
