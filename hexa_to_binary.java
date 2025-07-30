package DSA_PRBLMS;
import java.util.HashMap;
import java.util.Map;

public class hexa_to_binary {
    public static void main(String[] args) {
        String hexNumber = "1A3F";
        String binaryNumber = hexToBinary(hexNumber);
        System.out.println("Hexadecimal: " + hexNumber);
        System.out.println("Binary: " + binaryNumber);
    }

    public static String hexToBinary(String hex) {
        hex = hex.toUpperCase();
        StringBuilder binary = new StringBuilder();
        Map<Character, String> hexMap = new HashMap<>();

        hexMap.put('0', "0000");
        hexMap.put('1', "0001");
        hexMap.put('2', "0010");
        hexMap.put('3', "0011");
        hexMap.put('4', "0100");
        hexMap.put('5', "0101");
        hexMap.put('6', "0110");
        hexMap.put('7', "0111");
        hexMap.put('8', "1000");
        hexMap.put('9', "1001");
        hexMap.put('A', "1010");
        hexMap.put('B', "1011");
        hexMap.put('C', "1100");
        hexMap.put('D', "1101");
        hexMap.put('E', "1110");
        hexMap.put('F', "1111");

        for (char c : hex.toCharArray()) {
            if (hexMap.containsKey(c)) {
                binary.append(hexMap.get(c));
            } else {
                return "Invalid hexadecimal input";
            }
        }
        return binary.toString();
    }
}
