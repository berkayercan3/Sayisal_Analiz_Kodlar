public class Main {

    public static void main(String[] args) {
        double x = 5;
        double tv = Math.exp(-x); // Gerçek değer (true value)
        int maxIter = 20; // Maksimum iterasyon sayısı

        System.out.println("Terim\tSonuc\t\tet (%)\t\tea (%)");
        System.out.println("------------------------------------------------");

        calcAndPrint(x, tv, maxIter);
    }

    public static void calcAndPrint(double x, double tv, int maxIter) {
        double av = 1; // Yaklaşık değer (approximate value)
        double prevAv = 0;

        for (int i = 1; i <= maxIter; i++) {
            prevAv = av;
            av += Math.pow(-1, i) * Math.pow(x, i) / factorial(i);

            double trErr = calcTrErr(tv, av); // Gerçek hata (true relative error)
            double appErr = calcAppErr(av, prevAv); // Yaklaşık hata (approximate relative error)

            System.out.printf("%-10d %-15.9f %-10.3f %-10s\n", i, av, trErr, String.format("%.3f", appErr));
        }
    }

    public static double calcTrErr(double tv, double av) {
        return Math.abs((tv - av) / tv) * 100;
    }

    public static double calcAppErr(double av, double prevAv) {
        return Math.abs((av - prevAv) / av) * 100;
    }

    public static long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}