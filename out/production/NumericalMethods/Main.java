public class Main {

    public static void main(String[] args) {
        double epsilon = 1.0;
        double onePlusEpsilon = 1.0 + epsilon;
        int iteration = 0;

        System.out.println("Makine Epsilon Belirleme Süreci:");
        System.out.println("----------------------------------");

        while (onePlusEpsilon != 1.0) {
            System.out.printf("Adım %d: epsilon = %.20f, 1 + epsilon = %.20f\n", iteration, epsilon, onePlusEpsilon);
            epsilon /= 2.0;
            onePlusEpsilon = 1.0 + epsilon;
            iteration++;
        }

        epsilon *= 2.0; // Son bölme işlemini geri alıyoruz.
        System.out.printf("Adım %d (Son): epsilon (düzeltilmiş) = %.20f\n", iteration, epsilon);
        System.out.println("----------------------------------");
        System.out.println("Makine Epsilon Değeri: " + epsilon);
    }
}