package com.mindhub.homebanking.utils;

public final class Utils {

    public static String generateAccountNumber(long max){
        String account = "VIN-";
        for(int i = 0; i < max; i++) {
            account.concat(Integer.toString(getRandomNumber(0,9)));
        }
        return account;
    }

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
