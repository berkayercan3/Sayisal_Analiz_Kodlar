import java.util.Scanner;
import java.lang.Math;
//bisectionmethod
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Başlangıç Alt Değeri (xl): ");
        double xalt = scanner.nextDouble();

        System.out.print("Başlangıç Üst Değeri (xu): ");
        double xust = scanner.nextDouble();

        System.out.print("Maksimum İterasyon Sayısı: ");
        int maxIter = scanner.nextInt();

        System.out.print("Hata Toleransı (es, %): ");
        double es = scanner.nextDouble();

        System.out.println("\nİterasyon\t\txl\t\txu\t\txr\t\tεa (%)");
        System.out.println("---------------------------------------------------------");

        bisectionHesap(maxIter, xalt, xust, es);
    }

    public static void bisectionHesap(int maxIter, double xalt, double xust, double es) {
        double xr = 0;
        double ea = 100;
        int iter = 0;

        while (iter < maxIter) {
            double xrOld = xr;
            xr = (xalt + xust) / 2;

            double fxAlt = fonksiyon(xalt);
            double fxXr = fonksiyon(xr);

            if (fxAlt * fxXr < 0) {
                xust = xr;
            } else {
                xalt = xr;
            }
            if (iter > 0) {
                ea = Math.abs((xr - xrOld) / xr) * 100;
            }

            System.out.printf("%-10d\t%-10.6f\t%-10.6f\t%-10.6f\t%-10.6f%n", (iter + 1), xalt, xust, xr, ea);

            if (ea < es) break;

            iter++;
        }

        System.out.printf("\nYaklaşık kök: %.6f\n", xr);
    }

    public static double fonksiyon(double x) {
        return Math.pow(x, 2) - 10;
    }
}
