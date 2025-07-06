public class RotationCount {
    public int countRotations(int[] arr) {
        int low = 0, high = arr.length - 1;
        int n = arr.length;

        while (low <= high) {
            if (arr[low] <= arr[high]) return low;

            int mid = low + (high - low) / 2;
            int next = (mid + 1) % n;
            int prev = (mid - 1 + n) % n;

            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) return mid;

            if (arr[mid] >= arr[low]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        RotationCount obj = new RotationCount();
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Array is rotated: " + obj.countRotations(arr) + " times");
    }
}
