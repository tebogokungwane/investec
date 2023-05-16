package co.za.programming.tech.invest.assignment1;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class CommonFactorTest {
    @Test
    public void testHighestCommonFactor() {
        CommonFactor hcf = new CommonFactor();
        int[] input = {12, 16, 20};
        int expected = 4;
        int actual = hcf.highestCommonFactor(input);
        assertThat(actual, Matchers.equalTo(expected));
    }
}