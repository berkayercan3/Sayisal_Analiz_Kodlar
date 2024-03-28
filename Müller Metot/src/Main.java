import java.util.Scanner;
import java.util.function.Function;

public class Main {
    static class Polinom {
        int derece;
        double[] katsayı;

        Polinom(int derece) {
            this.derece = derece;
            this.katsayı = new double[derece + 1];
        }
    }

    public static int getPolynomialDegree() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Polinomun derecesini girin: ");
        return scanner.nextInt();
    }
    public static Polinom getPolinomKatsayilari(int derece) {
        Scanner scanner = new Scanner(System.in);
        Polinom polynomial = new Polinom(derece);

        System.out.println("Polinomun katsayılarını girin:");

        for (int i = derece; i >= 0; i--) {
            System.out.print("x^" + i + " katsayısı: ");
            polynomial.katsayı[i] = scanner.nextDouble();
        }

        return polynomial;
    }

    public static Function<Double, Double> PolinomOlusturma(Polinom polinom) {
        return x -> {
            double result = 0;
            for (int i = polinom.derece; i >= 0; i--) {
                result += polinom.katsayı[i] * Math.pow(x, i);
            }
            return result;
        };
    }

    public static void KokBul(Function<Double, Double> f, double x0, double x1, double x2, double tolerance, int maxIterations) {
        System.out.println("i\t xr\t\t Ea (%)");

        double xr = 0;

        for (int i = 0; i < maxIterations; i++) {
            double h0 = x1 - x0;
            double h1 = x2 - x1;
            double d0 = (f.apply(x1) - f.apply(x0)) / h0;
            double d1 = (f.apply(x2) - f.apply(x1)) / h1;
            double a = (d1 - d0) / (h1 + h0);
            double b = a * h1 + d1;
            double c = f.apply(x2);
            double discriminant = Math.sqrt(b * b - 4 * a * c);
            double denominator = b + Math.signum(b) * discriminant;
            xr = x2 - 2 * c / denominator;

            double ea = Math.abs((xr - x2) / xr) * 100;

            System.out.printf("%d\t %.6f\t %.6f%n", i, xr, ea);

            if (Math.abs(xr - x2) < tolerance * xr)
                break;

            x0 = x1;
            x1 = x2;
            x2 = xr;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int degree = getPolynomialDegree();
        Polinom polinom = getPolinomKatsayilari(degree);

        Function<Double, Double> polynomialFunction = PolinomOlusturma(polinom);

        System.out.print("İlk kök için tahmini girin: ");
        double x0 = scanner.nextDouble();
        System.out.print("İkinci kök için tahmini girin: ");
        double x1 = scanner.nextDouble();
        System.out.print("Üçüncü kök için tahmini girin: ");
        double x2 = scanner.nextDouble();

        double tolerance = 0.0001;
        int maxIterations = 100;

        KokBul(polynomialFunction, x0, x1, x2, tolerance, maxIterations);
    }
}
