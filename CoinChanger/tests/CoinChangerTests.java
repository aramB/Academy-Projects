import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class CoinChangerTests
{
	private CoinChanger sut;
	double[] coinTypes = { 1.0 };
	@Before public void setUp(){
		sut = new CoinChanger(coinTypes);
	}

	@Test public void correctChangeWhenUsingOneCoinType() {

		//Arrange
		sut = new CoinChanger(coinTypes);

		//Act
		Map<Double, Integer> myChange = sut.makeChange(14.0);

		//Assert
		Assert.assertEquals("got the right amount", 14, (int)myChange.get(1.0));
	}

}