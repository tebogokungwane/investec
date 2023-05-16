package co.za.programming.tech.invest.assignment1;

public class CommonFactor {

    public static void main(String[] args) {
        int num[] = {12,16,20};
        System.out.println(highestCommonFactor(num));
    }

    public static int highestCommonFactor(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Input array must not be empty or null");
        }
        int hcf = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            hcf = calculateHCF(hcf, numbers[i]);
        }
        return hcf;
    }

    private static int calculateHCF(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calculateHCF(b, a % b);
    }
}
