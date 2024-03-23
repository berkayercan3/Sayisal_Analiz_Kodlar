public class NewtonRaphson {
    public static double f(double x) {
        return Math.exp(-x) - x;
    }

    public static double derivativeF(double x) { //türevi
        return -Math.exp(-x) - 1;
    }

    public static double newtonRaphson(double initialGuess, double tolerance, int maxIterations) {
        double xi = initialGuess;
        int iter = 0;
        double et = 100.0;

        System.out.println("i\t xi\t\t Et (%)");
        System.out.println("----------------------------------");

        while (et > tolerance && iter < maxIterations) {
            double xNext = xi - f(xi) / derivativeF(xi);
            et = Math.abs((xNext - xi) / xNext) * 100;
            System.out.printf("%d\t %.9f\t %.6f\n", iter, xi, et);

            xi = xNext;
            iter++;
        }

        return xi;
    }
}
