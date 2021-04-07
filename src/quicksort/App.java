import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter a list of up to 10 Integers (comma and space seperated): ");
            String input = in.nextLine() + ", ";
            System.out.print(
                    "Enter Pivot Location with corresponding number (1: first, 2: last, 3: middle, 4: random): ");

            int loc = 1;
            try {
                loc = in.nextInt();
            } catch (Exception e) {
            }

            int count = 0;
            for (char c : input.toCharArray()) {
                if (c == ',')
                    count++;
            }

            if (count > 10) {
                System.out.println("Cannot Exceed 10 Numbers");
            } else {

                int[] arr = new int[count];
                for (int i = 0; i < count; i++) {
                    arr[i] = Integer.parseInt(input.substring(0, input.indexOf(",")));
                    input = input.substring(input.indexOf(" ") + 1);
                }

                System.out.println("Original Array: " + Arrays.toString(arr));
                QuickSort qs = new QuickSort(arr);

                if (loc == 3)
                    qs.sortMid(0, arr.length - 1, arr);
                else
                    qs.sort(0, arr.length - 1, arr, loc);

                System.out.println("Sorted Array: " + qs.getArray());
            }
            in.close();
        } catch (Exception e) {
            System.out.println("An Error Occured");
        }
    }
}