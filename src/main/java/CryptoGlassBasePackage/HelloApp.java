package CryptoGlassBasePackage;

import java.util.Scanner;

public class HelloApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        CryptFunctions cryptFunctions = new CryptFunctions();
        System.out.println();
        String cryptedMessage = cryptFunctions.crypt(message);
        System.out.println("Şifrelenmiş Mesaj:" + cryptedMessage);
        System.out.println("Çözümlenmiş Mesaj" + cryptFunctions.deCrypt(cryptedMessage));
    }
}
