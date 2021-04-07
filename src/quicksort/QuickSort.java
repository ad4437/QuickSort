import java.util.Arrays;

public class QuickSort {
    private int[] arr;

    public QuickSort(int[] arr) {
        this.arr = arr;
    }

    public String getArray() {
        return Arrays.toString(arr);
    }

    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int partitionLast(int l, int r, int[] arr) {
        int pivot = r;
        int i = l;
        for (int j = l; j <= r; j++) {
            if (arr[j] >= arr[pivot]) {
                swap(i, j, arr);
                i++;
            }
        }
        return i - 1;
    }

    public int partitionFirst(int l, int r, int[] arr, int loc) {
        int pivot = l;
        if (loc == 4)
            swap(l + (int) (Math.random() * (r - l + 1)), l, arr);
        int i = r;
        for (int j = r; j >= 0; j--) {
            if (arr[j] <= arr[pivot]) {
                swap(i, j, arr);
                i--;
            }
        }
        return i + 1;
    }

    public int partitionMid(int l, int r, int[] arr) {
        int pivot = (l + r) / 2;
        int li = l - 1;
        int ri = r + 1;
        while (true) {
            while (arr[++li] > arr[pivot])
                ;
            while (arr[--ri] < arr[pivot])
                ;
            if (li >= ri)
                break;
            swap(li, ri, arr);
        }
        return ri;
    }

    public void sortMid(int l, int r, int[] arr) {
        if (l >= r)
            return;
        int pivot = partitionMid(l, r, arr);
        sortMid(l, pivot, arr);
        sortMid(pivot + 1, r, arr);
    }

    public void sort(int l, int r, int[] arr, int loc) {
        if (l >= r)
            return;
        int pivot = (loc == 1 || loc == 4) ? partitionFirst(l, r, arr, loc) : partitionLast(l, r, arr);
        sort(l, pivot - 1, arr, loc);
        sort(pivot + 1, r, arr, loc);
    }
}
