public class Main {
    public static void main(String[] args) {
        double initialGuess = 0.0;
        double tolerance = 0.01;
        int maxIterations = 20;

        System.out.println("\nSimple Fixed Point Method");
        double root = FixedPointIteration.fixedPointIteration(initialGuess, tolerance, maxIterations);
        System.out.println("Kök: " + root);
        System.out.println("\n");

        System.out.println("The newton Raphson Method");
        double root1 = NewtonRaphson.newtonRaphson(initialGuess, tolerance, maxIterations);
        System.out.println("Kök: " + root1);
        System.out.println("\n");


        System.out.println("Secant Method");
        double x0 = 5.0; // İlk tahmin
        double x1 = 0.5; // İkinci tahmin
        double root2 = SecantMethod.secantMethod(x0, x1, tolerance, maxIterations);
        System.out.println("Root: " + root2);
    }
}
