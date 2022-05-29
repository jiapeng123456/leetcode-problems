package com.test;

import java.util.Arrays;

/**
 * @author john
 * @date 2022-04-30 10:01 PM
 */
public class HorseRace {

    int[] race(int[] usHorses, int[] enemyHorses) {
        Arrays.sort(usHorses);
        Arrays.sort(enemyHorses);

        for (int i = 0; i < usHorses.length; i++) {
            if (checkWin(usHorses, enemyHorses)) {
                return usHorses;
            }

            // rotate usHores
            int tmp = usHorses[0];
            for (int j = 1; j < usHorses.length; j++) {
                usHorses[j - 1] = usHorses[j];
            }
            usHorses[usHorses.length - 1] = tmp;
        }

        return null;
    }

    public boolean checkWin(int[] usHorses, int[] enemyHorses) {
        int winNum = usHorses.length / 2;
        int counter = 0;
        for (int i = 0; i < usHorses.length; i++) {
            if (usHorses[i] > enemyHorses[i]) {
                counter++;
            }
        }

        if (counter > winNum) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] usHorses = {12, 24, 8, 32};
        int[] enemyHorses = {13, 25, 32, 11};

        HorseRace horseRace = new HorseRace();
        int[] raceResult = horseRace.race(usHorses, enemyHorses);
        System.out.println(Arrays.toString(raceResult));
    }
}
