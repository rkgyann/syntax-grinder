import java.util.Scanner;

class recursive {

    static void selectionSort(int[] a, int n, int i) {
        if (i == n - 1)
            return;

        int min = i;

        for (int j = i + 1; j < n; j++) {
            if (a[j] < a[min])
                min = j;
        }

        int temp = a[min];
        a[min] = a[i];
        a[i] = temp;

        selectionSort(a, n, i + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Array size: ");
        int n = sc.nextInt();
        int[] a = new int[n];

        System.out.println("Enter the Array Elememnts: ");
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        selectionSort(a, n, 0);

        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }
}
