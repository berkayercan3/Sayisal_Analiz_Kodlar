package NewtonRaphson;

public class Method {

    // Fonksiyon: f(x) = x^3 - x - 1
    public static double f(double x) {
        return Math.pow(x, 3) - x - 1;
    }

    // Merkezi farkla türev: f'(x) ≈ [f(x + h) - f(x - h)] / (2h)
    public static double derivativeCentral(double x, double h) {
        return (f(x + h) - f(x - h)) / (2 * h);
    }

    // Newton-Raphson Yöntemi (yaklaşık türevle)
    public static void newtonRaphson(double x0, double eps, int maxIter, double h) {
        int iter = 0;
        double x1;

        while (iter < maxIter) {
            double fx = f(x0);
            double dfx = derivativeCentral(x0, h); // yaklaşık türev

            if (dfx == 0) {
                System.out.println("Türev 0 oldu, işlem durduruldu.");
                return;
            }

            x1 = x0 - fx / dfx;

            System.out.printf("Iter %d: x = %.6f, f(x) = %.6f\n", iter, x1, f(x1));

            if (Math.abs(x1 - x0) < eps) {
                System.out.printf("\nYaklaşık kök: %.6f\n", x1);
                return;
            }

            x0 = x1;
            iter++;
        }

        System.out.println("Yakınsama sağlanamadı.");
    }

    public static void main(String[] args) {
        double x0 = 1.5;         // Başlangıç tahmini
        double eps = 1e-6;       // Hata toleransı
        int maxIter = 50;        // Maksimum iterasyon
        double h = 0.0001;       // Merkezi fark için h

        newtonRaphson(x0, eps, maxIter, h);
    }
}
