package com.mindhub.homebanking.utils;

import java.util.Random;

public final class Utils {

    public static String generateAccountNumber(long max){
        String account = "VIN-";
        for(int i = 0; i < max; i++) {
            account = account.concat(Integer.toString(getRandomNumber()));
        }
        return account;
    }

    public static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
