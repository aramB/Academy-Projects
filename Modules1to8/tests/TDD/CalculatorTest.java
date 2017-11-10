package TDD;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest
{
	@Test public void whenAddinTwoPlusThreeShouldReturnFive() {
		Calculator sut = new Calculator();
		int result = sut.add(2,3);
		Assert.assertEquals(result, 5);
	}

}