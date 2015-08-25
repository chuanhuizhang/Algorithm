public class ThreeSum {
    public static int count(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {-40, -20, -10, 0, 10, 30, 40};
        long start = System.currentTimeMillis();
        System.out.println(count(a));
        long end = System.currentTimeMillis();
        System.out.println(start);
        System.out.println(end);
    }
}
