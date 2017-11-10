import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class StringCalcTest
{
	private StringCalc sut;

	@Before public void Setup() {
			sut = new StringCalc();
	}

	@Test public void testForEmptyString() {
		sut = new StringCalc();

		sut.add("");
		int result = sut.add("");
		Assert.assertEquals(0, result);
	}

	@Test public void testFor1InputString() {
		sut = new StringCalc();

		int result  = sut.add("1");
		Assert.assertEquals(1, result);
	}

	@Test public void testForMultipleInputString() {
		sut = new StringCalc();

		int result = sut.add("1,2");
		Assert.assertEquals(3, result);
	}

	@Test public void redTestCaseForEmptyString() {
		sut = new StringCalc();

		int res = sut.add("");
		Assert.assertEquals(0, res);
	}

	@Test public void testForMultipleNegativInputString() {
		sut = new StringCalc();

		int result = sut.add("-5,1");
		Assert.assertEquals(-4, result);
	}

}