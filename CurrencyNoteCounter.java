package DSA_PRBLMS;
import java.util.*;

public class CurrencyNoteCounter {

    public static void countCurrency(int amount) {
        int[] notes = {2000, 500, 200, 100, 50, 20, 10, 5, 1};

        System.out.println("Currency Count ->");
        for (int note : notes) {
            if (amount >= note) {
                int count = amount / note;
                System.out.println(note + " : " + count);
                amount %= note;
            }
        }
    }

    public static void main(String[] args) {
        int amount = 868;
        countCurrency(amount);
    }
}
