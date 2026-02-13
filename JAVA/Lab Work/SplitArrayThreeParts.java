class SplitArrayThreeParts {

    static String canSplit(int[] a) {
        int total = 0;
        for (int x : a)
            total += x;

        if (total % 3 != 0)
            return "NO";

        int partSum = total / 3;
        int currSum = 0;
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            currSum += a[i];

            if (currSum == partSum) {
                count++;
                currSum = 0;
            }
        }

        if (count >= 3)
            return "YES";
        else
            return "NO";
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 0, 3};
        System.out.println("\nThe Array can be Divided? \n "+canSplit(A));
    }
}
