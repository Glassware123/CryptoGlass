package CryptoGlassBasePackage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CryptFunctions {

    public int dividingHourFromClosestPrimeNumber(Integer hour){
        String convertHour;
        Integer closestPrimeNumber,minDifference,result;
        List<Integer> primeNumbers = new ArrayList<Integer>();
        primeNumbers.add(2);
        primeNumbers.add(3);
        primeNumbers.add(5);
        primeNumbers.add(7);
        primeNumbers.add(11);
        primeNumbers.add(13);
        primeNumbers.add(17);
        primeNumbers.add(19);
        primeNumbers.add(23);
        closestPrimeNumber=primeNumbers.get(0);
        minDifference=primeNumbers.get(8);

        for (int i = 1;i<primeNumbers.size();i++){
            if (primeNumbers.get(i) <= hour) {
                if ((hour % primeNumbers.get(i)) <= minDifference) {
                    closestPrimeNumber=primeNumbers.get(i);
                    minDifference=hour-primeNumbers.get(i);
                }
            }
        }
        result=hour%closestPrimeNumber;
        return result;

    }
    public String crypt(String message){
        ArrayList<Integer> cryptedMessage = new ArrayList<Integer>();
        Calendar calendar=Calendar.getInstance();
        Integer asciiCode;
        Integer hour = calendar.get(Calendar.HOUR_OF_DAY);
        char[] charArray = message.toCharArray();
        System.out.println("Şifrenecek mesaj:"+message);
        for (int i =0 ; i< charArray.length ;i++){
            asciiCode=(int)charArray[i];
            cryptedMessage.add(asciiCode + dividingHourFromClosestPrimeNumber(hour));
        }
        return cryptedMessage.toString() + "x" + hour;
    }
    public String deCrypt(String message){
        String[] parts = message.split("x");
        Integer hour = Integer.parseInt(parts[1]);
        String code = parts[0].substring(1, parts[0].length() - 1);
        ArrayList<Integer> codeArray = new ArrayList<Integer>();
        String[] codeParts = code.split(",");
        String[] decryptedMessage = new String[codeParts.length];
        for (int i = 0; i < codeParts.length; i++) {
            codeArray.add(Integer.valueOf(codeParts[i].trim()));
            decryptedMessage[i] = String.valueOf(Character.toChars(codeArray.get(i) - dividingHourFromClosestPrimeNumber(hour)));
        }
        StringBuilder builder = new StringBuilder();
        for (String s : decryptedMessage) {
            builder.append(s);
        }
        return builder.toString();
    }
}
