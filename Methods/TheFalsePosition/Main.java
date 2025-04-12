import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Başlangıç Alt Değeri (xl): ");
        double xl = scanner.nextDouble();

        System.out.print("Başlangıç Üst Değeri (xu): ");
        double xu = scanner.nextDouble();

        System.out.print("Maksimum İterasyon Sayısı: ");
        int imax = scanner.nextInt();

        System.out.print("Hata Toleransı (es, %): ");
        double es = scanner.nextDouble();

        double xr = xl; // Başlangıçta bir değer atayalım
        double ea = 100;
        int iter = 0;

        System.out.println("\nİterasyon\t\txl\t\txu\t\txr\t\tεa (%)");

        xr = modFalsePosition(xl, xu, es, imax);
        System.out.printf("\nYaklaşık kök: %.6f\n", xr);

        scanner.close();
    }

    public static double modFalsePosition(double xl, double xu, double es, int imax) {
        double fl = fonksiyon(xl);
        double fu = fonksiyon(xu);
        double xr = xl;
        double xrold = Double.NaN; // İlk iterasyonda tanımsız
        double fr;
        double ea = 100;
        int iter = 0;
        int il = 0, iu = 0;

        while (iter < imax && ea >= es) {
            xrold = xr;
            xr = xu - fu * (xl - xu) / (fl - fu);
            fr = fonksiyon(xr);
            iter++;

            if (xr != 0) {
                ea = Math.abs((xr - xrold) / xr) * 100;
            } else {
                ea = 0; // Kök sıfırsa hata sıfır
            }

            double test = fl * fr;

            System.out.printf("%-10d\t%-10.6f\t%-10.6f\t%-10.6f\t%-10.6f%n", iter, xl, xu, xr, (iter > 1 ? ea : Double.NaN));

            if (test < 0) {
                xu = xr;
                fu = fonksiyon(xu);
                iu++;
                il = 0;
                if (iu >= 2) {
                    fu /= 2.0;
                }
            } else if (test > 0) {
                xl = xr;
                fl = fonksiyon(xl);
                il++;
                iu = 0;
                if (il >= 2) {
                    fl /= 2.0;
                }
            } else {
                ea = 0; // Tam kök bulundu
                break;
            }

            if (Double.isNaN(xrold)) {
                ea = 100; // İlk iterasyonda anlamlı bir hata yok
            }
        }

        return xr;
    }

    public static double fonksiyon(double x) {
        return Math.pow(x, 2) - 10;
    }
}