package CryptoGlassBasePackage;

public class HelloApp {

    public static void main(String[] args) {
        String message="A124safsASAs546540";
        CryptFunctions cryptFunctions = new CryptFunctions();
        System.out.println();
        System.out.println("Şifrelenmiş Mesaj:"+cryptFunctions.crypt(message));
    }
}
