public class Main {
    public static void main(String[] args) {
        double xl = 12; // alt sınır
        double xu = 16; // üst sınır
        double es = 0.5; // Hata toleransı
        int imax = 100; // Maksimum iterasyon sayısı
        Bisect(xl, xu, es, imax); // Bisect fonksiyonunu çağırma

    }
    public static void Bisect(double xl, double xu, double es, int imax) {
        double xr = 0; // alt ve üst değerlern hesaplanan orta değeri
        double iter = 0;
        double ea = 0; // yaklaşık hata
        double et = 0;// gerçek oransal bağıl hata için
        System.out.println("\nIteration\txl\t\t\txu\t\t\txr\t\tEa (%)\t\tet (%) \n");

        do {
            double xreski = xr;
            xr = (xl + xu) / 2;
            iter++;
            if (xr != 0) {
                ea = Math.abs((xr - xreski) / xr) * 100; // yaklaşık hata değerinin hesaplanması
            }

            et = Math.abs((14.875 - xr) / 14.875) * 100; // Gerçek oransal bağıl hata hesaplaması

            System.out.printf("%d\t\t%.5f\t%.5f\t%.5f\t%.3f\t\t%.3f\n", (int) iter, xl, xu, xr, ea, et);

            double test = f(xl) * f(xr); // kök aralığı hesabı
            if (test < 0) {
                xu = xr;
            } else if (test > 0) {
                xl = xr;
            } else {
                ea = 0;
            }
            if (ea <= es || iter >= imax) { // hata toleransı veya maks iterasyon sayısına ulaşıldığında çık.
                break;
            }
        } while (true);
    }

    public static double f(double x) {
        return Math.sin(10 * x) + Math.cos(3 * x); // f(x) olarak dikkate aldığımız fonksiyon
        // return Math.pow(x, 10) - 1;  diğer bir örnek
    }

}
