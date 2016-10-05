package CryptoGlassBasePackage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CryptFunctions {

    public Double calculateFactorial(Integer n) {
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
    public int dividingHourFromClosestPrimeNumber(Integer hour){
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
        return closestPrimeNumber;

    }
    public String crypt(String message){
        BigDecimal bd;
        Double doubleVal;
        String stringVal;
        ArrayList<Integer> cryptedMessage = new ArrayList<Integer>();
        Calendar calendar=Calendar.getInstance();
        Integer asciiCode;
        Integer hour = calendar.get(Calendar.HOUR_OF_DAY);
        char[] charArray = message.toCharArray();
        System.out.println("Şifrenecek mesaj:"+message);
        for (int i =0 ; i< charArray.length ;i++){
            asciiCode=(int)charArray[i];
            doubleVal = calculateFactorial(hour + 3) / calculateFactorial(dividingHourFromClosestPrimeNumber(hour));
            bd = new BigDecimal(doubleVal);
            cryptedMessage.add((int) (Math.pow(asciiCode, 2) + bd.intValue()));
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
            decryptedMessage[i] = String.valueOf(Character.toChars((int) Math.sqrt(codeArray.get(i) - (calculateFactorial(hour + 3) / calculateFactorial(dividingHourFromClosestPrimeNumber(hour))))));
        }
        StringBuilder builder = new StringBuilder();
        for (String s : decryptedMessage) {
            builder.append(s);
        }
        return builder.toString();
    }
//    public String coreCode(String codeString){
//        String[] parts = codeString.split("x");
//        Integer hour = Integer.parseInt(parts[1]);
//        String code = parts[0].substring(1, parts[0].length() - 1);
//        ArrayList<Integer> codeArray = new ArrayList<Integer>();
//        String[] codeParts = code.split(",");
//        StringBuilder builder = new StringBuilder();
//        for (String s : codeParts) {
//            builder.append(s.trim());
//        }
//        return builder.toString()+"x"+hour;    }
}
