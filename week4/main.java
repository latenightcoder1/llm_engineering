import java.util.Locale;

public class Main {
    private static double calculate(int iterations, double p1, double p2) {
        double result = 1.0;
        int i = 1;
        int limit = iterations - 3;
        for (; i <= limit; i += 4) {
            double di = i * p1;
            double j = di - p2;
            result -= 1.0 / j;
            j = di + p2;
            result += 1.0 / j;

            int i1 = i + 1;
            di = i1 * p1;
            j = di - p2;
            result -= 1.0 / j;
            j = di + p2;
            result += 1.0 / j;

            int i2 = i + 2;
            di = i2 * p1;
            j = di - p2;
            result -= 1.0 / j;
            j = di + p2;
            result += 1.0 / j;

            int i3 = i + 3;
            di = i3 * p1;
            j = di - p2;
            result -= 1.0 / j;
            j = di + p2;
            result += 1.0 / j;
        }
        for (; i <= iterations; i++) {
            double di = i * p1;
            double j = di - p2;
            result -= 1.0 / j;
            j = di + p2;
            result += 1.0 / j;
        }
        return result;
    }

    public static void main(String[] args) {
        final int iterations = 200_000_000;
        final double p1 = 4.0;
        final double p2 = 1.0;

        long start = System.nanoTime();
        double partial = calculate(iterations, p1, p2);
        double result = partial * 4.0;
        long end = System.nanoTime();
        double elapsed = (end - start) / 1_000_000_000.0;

        System.out.printf(Locale.US, "Result: %.12f%n", result);
        System.out.printf(Locale.US, "Execution Time: %.6f seconds%n", elapsed);
    }
}