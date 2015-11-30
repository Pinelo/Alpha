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

    public void setSiesta(boolean siesta) {
        this.siesta = siesta;
    }

    public boolean isCaffeineAfterSix() {
        return caffeineAfterSix;
    }

    public void setCaffeineAfterSix(boolean caffeineAfterSix) {
        this.caffeineAfterSix = caffeineAfterSix;
    }

    public boolean isAcoholAfterSix() {
        return acoholAfterSix;
    }

    public void setAcoholAfterSix(boolean acoholAfterSix) {
        this.acoholAfterSix = acoholAfterSix;
    }

    public boolean isStress() {
        return stress;
    }

    public void setStress(boolean stress) {
        this.stress = stress;
    }

    public boolean isSleepMedicine() {
        return sleepMedicine;
    }

    public void setSleepMedicine(boolean sleepMedicine) {
        this.sleepMedicine = sleepMedicine;
    }

    public boolean isRelax() {
        return relax;
    }

    public void setRelax(boolean relax) {
        this.relax = relax;
    }

    public boolean isDiet() {
        return diet;
    }

    public void setDiet(boolean diet) {
        this.diet = diet;
    }

    public boolean isExcercise() {
        return excercise;
    }

    public void setExcercise(boolean excercise) {
        this.excercise = excercise;
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
}
