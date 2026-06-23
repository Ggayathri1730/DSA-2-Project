import java.util.Arrays;

public class ParcelRadixSort {
    public static void main(String[] args) {
        int[] trackingIds = {170, 45, 75, 90, 802, 24, 2, 66};

        Arrays.sort(trackingIds);

        System.out.println("Sorted Tracking IDs:");
        for (int id : trackingIds) {
            System.out.print(id + " ");
        }
    }
}