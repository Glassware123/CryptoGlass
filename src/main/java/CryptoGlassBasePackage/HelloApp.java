package CryptoGlassBasePackage;

import java.util.Scanner;

public class HelloApp {

    public static CryptFunctions cryptFunctions = new CryptFunctions();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1:Şifrele \n2:Şifre Çöz");
            Scanner scanner = new Scanner(System.in);
            Integer decision = scanner.nextInt();
            switch (decision) {
                case 1:
                    crypter();
                    break;
                case 2:
                    deCrypter();
                    break;
                default:
                    exitApplication();
                    break;
            }
        }
    }

    public static void crypter() {
        System.out.println("Mesaj?");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        System.out.println("Şifrelenmiş Mesaj:" + cryptFunctions.crypt(message));
    }

    public static void deCrypter() {
        System.out.println("Şifre?");
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        System.out.println("Çözümlenmiş Mesaj:" + cryptFunctions.deCrypt(code));
    }

    public static void exitApplication() {
        System.exit(0);
    }
}
