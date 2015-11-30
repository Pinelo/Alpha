package com.example.rogelio.saludtec;

/**
 * Created by hugo on 11/29/15.
 */
public class SleepReport {

    private String lightsOut;
    private String wakeUpTime;
    private int nightWakeUps;
    private int sleepAmmount;
    private int sleepQuality;
    private boolean siesta;
    private boolean caffeineAfterSix;
    private boolean acoholAfterSix;
    private boolean stress;
    private boolean sleepMedicine;
    private boolean relax;
    private boolean diet;
    private boolean excercise;
    private int energy;
    private String date;
    private String time;

    public SleepReport() {

    }

    public SleepReport(String lightsOut, String wakeUpTime, int nightWakeUps, int sleepAmmount, int sleepQuality, boolean siesta, boolean caffeineAfterSix, boolean acoholAfterSix, boolean stress, boolean sleepMedicine, boolean relax, boolean diet, boolean excercise, int energy, String date, String time) {
        this.lightsOut = lightsOut;
        this.wakeUpTime = wakeUpTime;
        this.nightWakeUps = nightWakeUps;
        this.sleepAmmount = sleepAmmount;
        this.sleepQuality = sleepQuality;
        this.siesta = siesta;
        this.caffeineAfterSix = caffeineAfterSix;
        this.acoholAfterSix = acoholAfterSix;
        this.stress = stress;
        this.sleepMedicine = sleepMedicine;
        this.relax = relax;
        this.diet = diet;
        this.excercise = excercise;
        this.energy = energy;
        this.date = date;
        this.time = time;
    }

    public SleepReport(String string, String string1, int anInt, int anInt1, int anInt2, int anInt3, int anInt4, int anInt5, int anInt6, int anInt7, int anInt8, int anInt9, int anInt10, int anInt11, String string2, String string3) {
        this.lightsOut = string;
        this.wakeUpTime = string1;
        this.nightWakeUps = anInt;
        this.sleepAmmount = anInt1;
        this.sleepQuality = anInt2;
        setSiesta(anInt3);
        setCaffeineAfterSix(anInt4);
        setAcoholAfterSix(anInt5);
        setStress(anInt6);
        setSleepMedicine(anInt7);
        setRelax(anInt8);
        setDiet(anInt9);
        setExcercise(anInt10);
        this.energy = anInt11;
        this.date = string2;
        this.time = string3;
    }

    public String getLightsOut() {
        return lightsOut;
    }

    public void setLightsOut(String lightsOut) {
        this.lightsOut = lightsOut;
    }

    public String getWakeUpTime() {
        return wakeUpTime;
    }

    public void setWakeUpTime(String wakeUpTime) {
        this.wakeUpTime = wakeUpTime;
    }

    public int getNightWakeUps() {
        return nightWakeUps;
    }

    public void setNightWakeUps(int nightWakeUps) {
        this.nightWakeUps = nightWakeUps;
    }

    public int getSleepAmmount() {
        return sleepAmmount;
    }

    public void setSleepAmmount(int sleepAmmount) {
        this.sleepAmmount = sleepAmmount;
    }

    public int getSleepQuality() {
        return sleepQuality;
    }

    public void setSleepQuality(int sleepQuality) {
        this.sleepQuality = sleepQuality;
    }

    public boolean isSiesta() {
        return siesta;
    }

    public int getSiesta() {
        if(siesta) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setSiesta(boolean siesta) {
        this.siesta = siesta;
    }

    public void setSiesta(int siesta) {
        if(siesta == 1) {
            this.siesta = true;
        } else {
            this.siesta = false;
        }
    }

    public boolean isCaffeineAfterSix() {
        return caffeineAfterSix;
    }

    public int getCaffeineAfterSix() {
        if(caffeineAfterSix) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setCaffeineAfterSix(boolean caffeineAfterSix) {
        this.caffeineAfterSix = caffeineAfterSix;
    }

    public void setCaffeineAfterSix(int caffeineAfterSix) {
        if(caffeineAfterSix == 1) {
            this.caffeineAfterSix = true;
        } else {
            this.caffeineAfterSix = false;
        }
    }

    public boolean isAcoholAfterSix() {
        return acoholAfterSix;
    }

    public int getAlcoholAfterSix() {
        if(acoholAfterSix) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setAcoholAfterSix(boolean acoholAfterSix) {
        this.acoholAfterSix = acoholAfterSix;
    }

    public void setAcoholAfterSix(int alcoholAfterSix) {
        if(alcoholAfterSix == 1) {
            acoholAfterSix = true;
        } else {
            acoholAfterSix = false;
        }
    }

    public boolean isStress() {
        return stress;
    }

    public int getStress() {
        if(stress) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setStress(boolean stress) {
        this.stress = stress;
    }

    public void setStress(int stress) {
        if(stress == 1) {
            this.stress = true;
        } else {
            this.stress = false;
        }
    }

    public boolean isSleepMedicine() {
        return sleepMedicine;
    }

    public int getSleepMedicine() {
        if(sleepMedicine) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setSleepMedicine(boolean sleepMedicine) {
        this.sleepMedicine = sleepMedicine;
    }

    public void setSleepMedicine(int sleepMedicine) {
        if(sleepMedicine == 1) {
            this.sleepMedicine = true;
        } else {
            this.sleepMedicine = false;
        }
    }

    public boolean isRelax() {
        return relax;
    }

    public int getRelax() {
        if(relax) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setRelax(boolean relax) {
        this.relax = relax;
    }

    public void setRelax(int relax) {
        if(relax == 1) {
            this.relax = true;
        } else {
            this.relax = false;
        }
    }

    public boolean isDiet() {
        return diet;
    }

    public int getDiet() {
        if(diet) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setDiet(boolean diet) {
        this.diet = diet;
    }

    public void setDiet(int diet) {
        if(diet == 1) {
            this.diet = true;
        } else {
            this.diet  = false;
        }
    }

    public boolean isExcercise() {
        return excercise;
    }

    public int getExcercise() {
        if(excercise) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setExcercise(boolean excercise) {
        this.excercise = excercise;
    }

    public void setExcercise(int excercise) {
        if(excercise == 1) {
            this.excercise = true;
        } else {
            this.excercise = false;
        }
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getWakeUpTimeGrade() {
        if (wakeUpTime.equals("6:00am") || wakeUpTime.equals("7:00am")) {
            return 5;
        } else if(wakeUpTime.equals("8:00am") || wakeUpTime.equals("9:00am")) {
            return 4;
        } else if(wakeUpTime.equals("10:00am")) {
            return 3;
        } else {
            return 2;
        }
    }

    public float getLightsOutGrade() {
        if (lightsOut.equals("8:00pm") || lightsOut.equals("9:00pm")) {
            return 5;
        } else if(lightsOut.equals("10:00pm") || lightsOut.equals("11:00pm")) {
            return 4;
        } else if(lightsOut.equals("12:00pm")) {
            return 3;
        } else {
            return 2;
        }

    }

    public float getGrade() {
        float grade, sum = 0;
        sum += getWakeUpTimeGrade();
        sum += getLightsOutGrade();
        sum += getNightWakeUpsGrade();
        sum += getSleepAmmountGrade();
        sum += getSleepQuality();
        sum += getSiesta()*5;
        sum += getCaffeineAfterSix()*5;
        sum += getAlcoholAfterSix()*5;
        sum += getStress()*5;
        sum += getSleepMedicine()*5;
        sum += getRelax()*5;
        sum += getDiet()*5;
        sum += getExcercise()*5;
        sum += getEnergy();
        grade = sum/70*100;

        return grade;
    }

    private float getSleepAmmountGrade() {
        if (sleepAmmount >= 8) {
            return 5;
        } else if(sleepAmmount == 7) {
            return 4;
        } else if (sleepAmmount == 6) {
            return 3;
        } else {
            return 2;
        }
    }

    private float getNightWakeUpsGrade() {
        if (nightWakeUps == 0) {
            return 5;
        } else if(nightWakeUps == 1) {
            return 4;
        } else {
            return 2;
        }
    }
}
