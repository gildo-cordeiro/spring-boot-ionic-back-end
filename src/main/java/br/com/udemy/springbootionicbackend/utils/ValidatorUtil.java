package br.com.udemy.springbootionicbackend.utils;

public class ValidatorUtil {

    public static boolean isEmpty(Object obj){
        if (obj.equals("") || obj == null)
            return true;

        return false;
    }
}
