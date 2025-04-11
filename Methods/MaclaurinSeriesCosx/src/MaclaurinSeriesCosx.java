public class MaclaurinSeriesCosx {
    public static void main(String[] args) {
        double x = 0.3 * Math.PI;
        double truevalue = Math.cos(x);
        int iter = 10; // Maksimum iterasyon sayısı
        // Maclaurin serisini hesapla
        MaclaurinSeriesForCosx(x, truevalue, iter);
    }

    public static void MaclaurinSeriesForCosx(double x, double truevalue, int iter) {
        double approx = 1.0;  // İlk terim (cos(0) = 1)
        double prevapprox;

        System.out.printf("%-5s %-20s %-15s %-15s\n", "it", "sonuc", "et(%)", "ea(%)");
        System.out.println("------------------------------------------------------------");

        for (int i = 2; i <= iter; i += 2) { // Çift üsler (2, 4, 6, ...)
            prevapprox = approx;
            approx += Math.pow(-1, i / 2) * Math.pow(x, i) / faktoriyel(i);

            double et = ethesap(truevalue, approx);

            if (i == 2) { // İlk iterasyonda ea hesaplanamaz
                System.out.printf("%-5d %-20.6f %-15.6f %-15s\n", i / 2, approx, et, "----");
            } else {
                double ea = eahesap(approx, prevapprox);
                System.out.printf("%-5d %-20.6f %-15.6f %-15.6f\n", i / 2, approx, et, ea);
            }
        }
    }

    public static double eahesap(double approx, double prevapprox) {
        return Math.abs((approx - prevapprox) / approx) * 100;
    }

    public static double ethesap(double tv, double av) {
        return Math.abs((tv - av) / tv) * 100;
    }

    public static long faktoriyel(int i) {
        long sonuc = 1;
        for (int term = 1; term <= i; term++) {
            sonuc *= term;
        }
        return sonuc;
    }
}
