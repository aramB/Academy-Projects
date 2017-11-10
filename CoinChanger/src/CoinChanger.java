import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinChanger
{
	private double[] coinTypes;
	public CoinChanger(double[] coinTypes) {
		List<Double> allCoinTypes = new ArrayList<>();
		for (double coin:coinTypes){
			allCoinTypes.add(coin);
		}
		Collections.sort(allCoinTypes);
		Collections.reverse(allCoinTypes);
		coinTypes = allCoinTypes;
	}


	public Map<Double, Integer> makeChange(final double v) {
		Map<Double, Integer> change = new HashMap<>();
		//Måste tänka på att det kommer finnas flera CoinTypes

	}
}
