import java.util.Scanner;

public class Main {

    static double üsHesapla(double x, int n) {
        return Math.pow(x, n) / faktöriyel(n);
    }

    static double faktöriyel(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * faktöriyel(n - 1);
        }
    }

    static double gerçekDeğeriHesapla(double x) {
        return Math.exp(x); // e^x değeri hesaplandı
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("x değerini girin: ");
        double x = scanner.nextDouble();

        double gerçekDeğer = gerçekDeğeriHesapla(x);
        double tahminiDeğer = 1.0; //ilk terim

        System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "Terim  ", "Tahmini Değer", "Gerçek Hata(%)", "Tahmini Hata(%)", "Es");

        double es;

        for (int n = 1; ; n++) {
            double terim = üsHesapla(x, n);
            tahminiDeğer += terim;

            double gerçekHata = Math.abs((gerçekDeğer - tahminiDeğer) / gerçekDeğer) * 100; // mutlak hali
            double tahminiHata = Math.abs((terim / tahminiDeğer) * 100); // mutlak hali

            es = 0.5 * Math.pow(10, 2 - n); // yaklaşımın ne hassaslıklta yapılacağını hesapladık (hata eşiği hesabı)

            System.out.printf("%-10d%-20f%-20f%-20f%-20f%n", n, tahminiDeğer, gerçekHata, tahminiHata, es);

            if (es <= 0.05) {
                break;
            }
        }
    }
}
