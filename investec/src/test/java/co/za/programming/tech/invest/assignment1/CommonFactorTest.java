package co.za.programming.tech.invest.assignment1;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class CommonFactorTest {

    private CommonFactor commonFactor;

    @Before
    public void setup(){
        commonFactor = new CommonFactor();

    }

    @Test
    public void testHighestCommonFactor() {
        int[] input = {12, 16, 20};
        int expected = 4;
        int actual = commonFactor.highestCommonFactor(input);
        assertThat(actual, Matchers.equalTo(expected));
    }

    @Test
    public void testHighestCommonFactor_NegativeScenario(){
        int[] input = {12,16,20};
        int expected = 6;
        int actual = commonFactor.highestCommonFactor(input);
        assertThat(actual, Matchers.not(Matchers.equalTo(expected)));

    }
}
