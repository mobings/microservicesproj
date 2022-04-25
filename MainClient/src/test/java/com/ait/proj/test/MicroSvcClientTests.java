package com.ait.proj.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


public class MicroSvcClientTests {

	@Test
    public void testConcatenate() {
  String mytest="test";

        String result = mytest.concat("contcated");

        assertNotEquals("testconcated", result);

    }

}
