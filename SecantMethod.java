public class SecantMethod {
    public static double f(double x) {
        return Math.log(x);
    }

    public static double secantMethod(double x0, double x1, double tolerance, int maxIterations) {
        double x2 = 0.0;
        int iter = 1;

        System.out.println("Iteration\t xl\t xu\t xr");

        while (iter <= maxIterations) {
            x2 = x1 - (f(x1) * (x1 - x0)) / (f(x1) - f(x0));
            System.out.printf("%d\t\t %.4f\t %.4f\t %.4f\n", iter, x0, x1, x2);

            if (Math.abs(f(x2)) < tolerance) {
                break;
            }

            x0 = x1;
            x1 = x2;
            iter++;
        }

        return x2;
    }
}
