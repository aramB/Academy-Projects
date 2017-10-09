package exercise17;

import java.util.HashMap;
import java.util.Map;

public class Ex17p1
{
	String hex = Integer.toHexString(12);

	/*HexConverter hexconv = new HexConverter();
	System.out.println(hexconv.convertToHex(255)); //0xFF
	System.out.println(hexconv.convertToHex(240)); //0xF0
	System.out.println(hexconv.convertToHex(128)); //0x80
	System.out.println(hexconv.convertToHex(15)); //0x0F
	System.out.println(hexconv.convertToHex(1)); //0x01
	System.out.println(hexconv.convertToHex(0)); //0x00
*/}

class HexConverter
{
	Map<Integer, Character> decToHexMap = new HashMap<>();

}