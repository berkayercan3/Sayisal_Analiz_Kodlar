public class Main {
    public static void main(String[] args) {
        double xl = 0; // alt değer
        double xu = 1.3; // üst değer
        double es = 0.0001; // Hata toleransı
        int imax = 5; // Maksimum iterasyon sayısı

        ModFalsePos(xl, xu, es, imax);
    }

    public static double f(double x) {
       // return Math.sin(10 * x) + Math.cos(3 * x);  kullanılabilecek diğer fonksiyon
        return Math.pow(x, 10) - 1;
    }

    public static void ModFalsePos(double xl, double xu, double es, int imax) {
        System.out.println("\nIteration\txl\t\t\txu\t\t\txr\t\tEa (%)\tet (%) \n");

        int iter = 0;
        double fl = f(xl); // alt değerin fonksiyondaki değeri
        double fu = f(xu); // üst değerin fonksiyondaki değeri
        double xr = 0; //orta değer
        double ea = 0; // yaklaşık hata

        do {
            double xreski = xr;
            xr = xu - (fu * (xl - xu)) / (fl - fu);
            double fr = f(xr);
            iter++;

            if (xr != 0) { //
                ea = Math.abs((xr - xreski) / xr) * 100;
            }

            double test = fl * fr;
            if (test < 0) {
                xu = xr;
                fu = f(xu);
            } else if (test > 0) {
                xl = xr;
                fl = f(xl);
            } else {
                ea = 0;
            }

            double et = Math.abs((xr - 0.09430) / xr) * 100; // hata hesabı
            System.out.printf("%-12d%-10.5f%-10.5f%-10.5f%-10.1f%-10.1f%n", iter, xl, xu, xr, ea, et);

            if (ea <= es || iter >= imax) { // programın duracağı nokta
                break;
            }
        } while (true);
    }
}
