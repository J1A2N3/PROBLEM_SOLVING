public class CountOccurrences {
        public int firstIndex(int[] arr, int target) {
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid;
                high = mid - 1; 
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
    public int lastIndex(int[] arr, int target) {
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid;
                low = mid + 1; 
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
    public int countOccurrences(int[] arr, int target) {
        int first = firstIndex(arr, target);
        if (first == -1) return 0;
        int last = lastIndex(arr, target);
        return last - first + 1;
    }
    public static void main(String[] args) {
        CountOccurrences obj = new CountOccurrences();
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        System.out.println("Count of " + target + ": " + obj.countOccurrences(arr, target));
    }
}
