package edu.bt.todo9;

import androidx.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static java.lang.Double.POSITIVE_INFINITY;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
@SmallTest

public class ExampleUnitTest {
    private Ccalculator calu;

    @Before
    public void setUp() {
        calu = new Ccalculator();
    }

    @Test
    public void addTwoNumber() {
        double result = calu.add(1d, 2d);
        assertThat(result, is(equalTo(3d)));
    }
    @Test
    public void subTwoNumbers() {
        double result = calu.sub(4d, 2d);
        assertThat(result, is(equalTo(2d)));
    }
    @Test
    public void subWorksWithNegativeResults() {
        double result = calu.sub(-4d, 2d);
        assertThat(result, is(equalTo(-6d)));
    }
    @Test
    public void mulTwoNumbers() {
        double result = calu.mul(4d, 2d);
        assertThat(result, is(equalTo(8d)));
    }
    @Test
    public void mulTwoNumbersZero() {
        double result = calu.mul(0d, 2d);
        assertThat(result, is(equalTo(0d)));
    }
    @Test
    public void divTwoNumbers() {
        double result = calu.div(8d, 2d);
        assertThat(result, is(equalTo(4d)));
    }
    @Test
    public void divTwoNumbersZero() {
        double result = calu.div(4d, 0d);
        assertThat(result, is(equalTo(POSITIVE_INFINITY)));
    }
}

//    Add a unit test called subTwoNumbers() that tests the sub() method.
//        Add a unit test called subWorksWithNegativeResults() that tests the sub() method where the given calculation results in a negative number.
//        Add a unit test called mulTwoNumbers() that tests the mul() method.
//        Add a unit test called mulTwoNumbersZero() that tests the mul() method with at least one argument as zero.
//        Add a unit test called divTwoNumbers() that tests the div() method with two non-zero arguments.
//        Add a unit test called divTwoNumbersZero() that tests the div() method with a double dividend and zero as the divider.

