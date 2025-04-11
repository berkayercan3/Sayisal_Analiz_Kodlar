import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Katsayıları al
        System.out.println("a katsayısını giriniz: ");
        double a = scanner.nextDouble();
        System.out.println("b katsayısını giriniz: ");
        double b = scanner.nextDouble();
        System.out.println("c katsayısını giriniz: ");
        double c = scanner.nextDouble();

        // Metodun çıktısını ekrana yazdır
        System.out.println(kokbulma(a, b, c));

        scanner.close();
    }

    public static String kokbulma(double a, double b, double c) {
        if (a == 0) {
            return "Geçersiz giriş: a katsayısı 0 olamaz!";
        }

        double delta = b * b - 4 * a * c;
        if (delta < 0) {
            double reelKisim = -b / (2 * a);
            double sanalKisim = Math.sqrt(-delta) / (2 * a);
            return "Kompleks kökler: " + reelKisim + " + " + sanalKisim + "i ve " + reelKisim + " - " + sanalKisim + "i";
        } else if (delta == 0) {
            double root = -b / (2 * a);
            return "Gerçek ve eşit kökler: " + root;
        } else {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return "Gerçek ve farklı kökler: " + root1 + " ve " + root2;
        }
    }
}
