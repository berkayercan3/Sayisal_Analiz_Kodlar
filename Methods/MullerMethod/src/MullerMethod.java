package src;

public class MullerMethod {

    public static double f(double x) {
        return Math.pow(x, 3) - 13 * x - 12; // Örnek fonksiyon
    }

    public static void muller(double xr, double h, double eps, int maxit) {
        double x2 = xr;
        double x1 = xr + h * xr;
        double x0 = xr - h * xr;
        double dxr = 0;
        int iter = 0;

        while (true) {
            iter++;

            double h0 = x1 - x0;
            double h1 = x2 - x1;

            double d0 = (f(x1) - f(x0)) / h0;
            double d1 = (f(x2) - f(x1)) / h1;

            double a = (d1 - d0) / (h1 + h0);
            double b = a * h1 + d1;
            double c = f(x2);

            double rad = Math.sqrt(b * b - 4 * a * c);

            double den;
            if (Math.abs(b + rad) > Math.abs(b - rad)) {
                den = b + rad;
            } else {
                den = b - rad;
            }

            dxr = -2 * c / den;
            xr = x2 + dxr;

            System.out.printf("Iter %d: xr = %.6f%n", iter, xr);

            if (Math.abs(dxr) < eps * Math.abs(xr) || iter >= maxit) {
                break;
            }

            // Değişkenleri güncelle
            x0 = x1;
            x1 = x2;
            x2 = xr;
        }

        System.out.printf("Root found at xr = %.6f after %d iterations%n", xr, iter);
    }

    public static void main(String[] args) {
        double initialGuess = 4.5;
        double h = 0.5;
        double eps = 1e-6;
        int maxit = 100;

        muller(initialGuess, h, eps, maxit);
    }
}

/*
                    sadeleştirilmiş Müller Metodu Fonksiyonu

    public static void muller(double xr, double h, double eps, int maxit) {
    double x2 = xr;
    double x1 = xr + h * xr;
    double x0 = xr - h * xr;
    double dxr;
    int iter = 0;

    while (true) {
        iter++;

        double h0 = x1 - x0;
        double h1 = x2 - x1;

        double d0 = (f(x1) - f(x0)) / h0;
        double d1 = (f(x2) - f(x1)) / h1;

        double a = (d1 - d0) / (h1 + h0);
        double b = a * h1 + d1;
        double c = f(x2);

        double rad = Math.sqrt(b * b - 4 * a * c);
        double den = Math.abs(b + rad) > Math.abs(b - rad) ? b + rad : b - rad;

        dxr = -2 * c / den;
        xr = x2 + dxr;

        if (Math.abs(dxr) < eps * Math.abs(xr) || iter >= maxit)
            break;

        x0 = x1;
        x1 = x2;
        x2 = xr;
    }
}

public static double f(double x) {
    return Math.pow(x, 3) - 13 * x - 12;
}

*/