public class FixedPointIteration {
    public static double fixedPointIteration(double initialGuess, double tolerance, int maxIterations) {
        double currentGuess = initialGuess;
        int iterations = 0;
        double previousGuess = Double.NaN;

        System.out.println("   i      xi           Ea (%)     Et (%)   ");
        System.out.println("--------------------------------------------");

        while (iterations < maxIterations) {
            double nextGuess = Math.exp(-currentGuess);
            double ea = 0;
            double et = 0;

            if (!Double.isNaN(previousGuess)) {
                ea = Math.abs((nextGuess - currentGuess) / nextGuess) * 100;
                et = Math.abs((nextGuess - 0.56714329) / 0.56714329) * 100;
            }

            System.out.printf("  %2d     %.6f    %.2f        %.2f      \n", iterations, currentGuess, ea, et);

            if (Math.abs(nextGuess - currentGuess) < tolerance) {
                return nextGuess;
            }

            previousGuess = currentGuess;
            currentGuess = nextGuess;
            iterations++;
        }
        return Double.NaN;
    }
}
