import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("g degerini giriniz: ");
        double g = sc.nextDouble();

        System.out.println("c degerini giriniz: ");
        double c = sc.nextDouble();

        System.out.println("iterasyon degerini giriniz: ");
        int it = sc.nextInt();

        double m = 68.1;
        System.out.println("t/s\t\tv");
        System.out.println("-----------------");

        for (int i = 0; i <= it; i += 2) {
            double vt = fonk(g, c, m, i);
            System.out.println(i + "\t\t" + String.format("%.6f", vt));
        }
        sc.close();
    }
    private static double fonk(double g, double c, double m, int t) {
        double mgc = (m * g) / c;
        double e = Math.E;
        double eus = (-c * t) / m;
        double vt = mgc * (1 - Math.pow(e, eus));
        return vt;
    }
}