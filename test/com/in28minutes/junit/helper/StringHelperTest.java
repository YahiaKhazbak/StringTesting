package com.in28minutes.junit.helper;


import org.junit.*;

import java.util.Arrays;

import static org.junit.Assert.*;


public class StringHelperTest {

//    @BeforeClass
//    public static void beforeClass(){
//        System.out.println("Before Class");
//    }
//
//    @AfterClass
//    public static void afterClass(){
//        System.out.println("After Class");
//    }

    StringHelper helper;

    @Before // before every test
    public void before() {
        helper = new StringHelper();
    }

    @After // after every test
    public void after() {
        helper = null;
    }

    @Test
    public void testTruncateAInFirst2Positions() {


        assertEquals("RTAA", helper.truncateAInFirst2Positions("RTAA"));
        assertEquals("BB", helper.truncateAInFirst2Positions("AABB"));
        assertEquals("BBB", helper.truncateAInFirst2Positions("BABB"));

    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame() {

        assertFalse(helper.areFirstAndLastTwoCharactersTheSame(""));
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("A"));
        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("AB"));
        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("AAA"));
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("AAB"));
    }

    /* Arrays.sort */
    @Test
    public void testArraysSort() {
        int[] numbers = {5, 6, 4, 2, 3, 1};
        Arrays.sort(numbers);
        int[] expectedOutput = {1, 2, 3, 4, 5, 6};

        assertArrayEquals(expectedOutput, numbers);
    }

    @Test(expected = NullPointerException.class)
    public void testArraysSortWithNullCondition() {
        int[] numbers = null;
        Arrays.sort(numbers);
    }

    @Test(timeout = 100) // in milliseconds
    public void testArraysSortPerformance() {

        for (int i = 0; i < 1000000; i++) {

            int[] numbers = {i, i - 1, i + 1};
            Arrays.sort(numbers);
        }
    }
}