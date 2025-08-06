public class TreeGrowth {
    public static int utopianTree(int n) {
        int height = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                height *= 2;
            } else {
                height += 1;
            }
        }
        return height;
    }
    public static void main(String[] args) {
        System.out.println("Input: 0 → Output: " + utopianTree(0)); // 1
        System.out.println("Input: 1 → Output: " + utopianTree(1)); // 2
        System.out.println("Input: 4 → Output: " + utopianTree(4)); // 7
        System.out.println("Input: 5 → Output: " + utopianTree(5)); // 14
        System.out.println("Input: 6 → Output: " + utopianTree(6)); // 15
    }
}
