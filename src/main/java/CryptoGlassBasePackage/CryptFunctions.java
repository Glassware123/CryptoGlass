package CryptoGlassBasePackage;

import java.util.*;

public class CryptFunctions {

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
            if (primeNumbers.get(i)<hour){
                if((hour%primeNumbers.get(i))<minDifference){
                    closestPrimeNumber=primeNumbers.get(i);
                    minDifference=hour-primeNumbers.get(i);
                }
            }
        }
        result=hour%closestPrimeNumber;
        return result;

    }
    public String crypt(String message){
        String cryptedMessage="";
        Calendar calendar=Calendar.getInstance();
        Integer asciiCode=null;
        Integer hour = calendar.get(Calendar.HOUR_OF_DAY);
        char[] charArray = message.toCharArray();
        System.out.println("Şifrenecek mesaj:"+message);
        for (int i =0 ; i< charArray.length ;i++){
            asciiCode=(int)charArray[i];
            cryptedMessage=cryptedMessage+(asciiCode+dividingHourFromClosestPrimeNumber(hour));
        }
        return cryptedMessage+hour;
    }
    public String deCrypt(String message){

        return "";
    }
}
