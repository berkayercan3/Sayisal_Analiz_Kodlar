public class Main {

    public static void main(String[] args) {
        double x0 = Math.PI / 2;
        int maxOrder = 5;
        double h = 1e-5;

        for (int n = 0; n <= maxOrder; n++) {
            double deriv = nthDerivative(x0, h, n);
            System.out.printf("%d. türev (x=π/2): %.6f\n", n, deriv);
        }
    }

    // Verilen noktada n. türevi hesaplayan fonksiyon
    public static double nthDerivative(double x, double h, int n) {
        if (n == 0)
            return f(x);
        else
            return (nthDerivative(x + h, h, n - 1) - nthDerivative(x, h, n - 1)) / h;
    }

    // Verilen fonksiyon: f(x) = x - 1 - 0.5sin(x)
    public static double f(double x) {
        return x - 1 - 0.5 * Math.sin(x);
    }
}
