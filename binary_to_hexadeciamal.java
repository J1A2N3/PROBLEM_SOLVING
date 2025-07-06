package DSA_PRBLMS;

public class binary_to_hexadeciamal {

    public static String convert(String binary) {
        int len = binary.length();

        // Padding with zeros if needed to make length a multiple of 4
        int pad = (4 - (len % 4)) % 4;
        StringBuilder final_string = new StringBuilder();
        for (int i = 0; i < pad; i++) {
            final_string.append('0');
        }
        final_string.append(binary);

        StringBuilder hexadeci = new StringBuilder();

        // Conversion using switch
        for (int i = 0; i < final_string.length(); i += 4) {
            String four = final_string.substring(i, i + 4);

            switch (four) {
                case "0000": hexadeci.append("0"); break;
                case "0001": hexadeci.append("1"); break;
                case "0010": hexadeci.append("2"); break;
                case "0011": hexadeci.append("3"); break;
                case "0100": hexadeci.append("4"); break;
                case "0101": hexadeci.append("5"); break;
                case "0110": hexadeci.append("6"); break;
                case "0111": hexadeci.append("7"); break;
                case "1000": hexadeci.append("8"); break;
                case "1001": hexadeci.append("9"); break;
                case "1010": hexadeci.append("A"); break;
                case "1011": hexadeci.append("B"); break;
                case "1100": hexadeci.append("C"); break;
                case "1101": hexadeci.append("D"); break;
                case "1110": hexadeci.append("E"); break;
                case "1111": hexadeci.append("F"); break;
                default: hexadeci.append("?"); // in case of invalid binary string
            }
        }

        return hexadeci.toString();
    }

    public static void main(String[] args) {
        String hex = convert("10101");
        System.out.println(hex);  // Output: 15
    }
}


/* 📥 Input:
"10101"

📤 Output:
Hexadecimal: 15

⏱ Time Complexity:
O(n) where n is the number of binary digits
*/
