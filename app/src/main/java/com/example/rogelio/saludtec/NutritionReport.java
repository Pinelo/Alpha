package com.example.rogelio.saludtec;

/**
 * Created by hugo on 11/26/15.
 */
public class NutritionReport {



    public int criteriaOne;
    public int criteriaTwo;
    public int criteriaThree;
    public int criteriaFour;
    public int criteriaFive;
    public int criteriaSix;
    public int criteriaSeven;
    public int criteriaEight;
    public int criteriaNine;
    public int criteriaTen;
    public String date;
    public String time;

    public NutritionReport() {

    }

    public int getGrade() {
        float sum = 0, grade;
        sum += criteriaOne;
        sum += criteriaTwo;
        sum += criteriaThree;
        sum += criteriaFour;
        sum += criteriaFive;
        sum += criteriaSix;
        sum += criteriaSeven;
        sum += criteriaEight;
        sum += criteriaNine;
        sum += criteriaTen;
        grade = sum/50*100;
        return (int) grade;
    }

    public void setGrade(int criteria, int grade) {
        switch (criteria + 1) {
            case 1:
                criteriaOne = grade;
                break;

            case 2:
                criteriaTwo = grade;
                break;

            case 3:
                criteriaThree = grade;
                break;

            case 4:
                criteriaFour = grade;
                break;

            case 5:
                criteriaFive = grade;
                break;

            case 6:
                criteriaSix = grade;
                break;

            case 7:
                criteriaSeven = grade;
                break;

            case 8:
                criteriaEight = grade;
                break;

            case 9:
                criteriaNine = grade;
                break;

            case 10:
                criteriaTen = grade;
                break;
        }
    }

    public NutritionReport(int criteriaOne, int criteriaTwo, int criteriaThree, int criteriaFour, int criteriaFive, int criteriaSix, int criteriaSeven, int criteriaEight, int criteriaNine, int criteriaTen, String date, String time) {
        this.criteriaOne = criteriaOne;
        this.criteriaTwo = criteriaTwo;
        this.criteriaThree = criteriaThree;
        this.criteriaFour = criteriaFour;
        this.criteriaFive = criteriaFive;
        this.criteriaSix = criteriaSix;
        this.criteriaSeven = criteriaSeven;
        this.criteriaEight = criteriaEight;
        this.criteriaNine = criteriaNine;
        this.criteriaTen = criteriaTen;
        this.date = date;
        this.time = time;
    }

    public int getCriteriaOne() {
        return criteriaOne;
    }

    public void setCriteriaOne(int criteriaOne) {
        this.criteriaOne = criteriaOne;
    }

    public int getCriteriaTwo() {
        return criteriaTwo;
    }

    public void setCriteriaTwo(int criteriaTwo) {
        this.criteriaTwo = criteriaTwo;
    }

    public int getCriteriaThree() {
        return criteriaThree;
    }

    public void setCriteriaThree(int criteriaThree) {
        this.criteriaThree = criteriaThree;
    }

    public int getCriteriaFour() {
        return criteriaFour;
    }

    public void setCriteriaFour(int criteriaFour) {
        this.criteriaFour = criteriaFour;
    }

    public int getCriteriaFive() {
        return criteriaFive;
    }

    public void setCriteriaFive(int criteriaFive) {
        this.criteriaFive = criteriaFive;
    }

    public int getCriteriaSix() {
        return criteriaSix;
    }

    public void setCriteriaSix(int criteriaSix) {
        this.criteriaSix = criteriaSix;
    }

    public int getCriteriaSeven() {
        return criteriaSeven;
    }

    public void setCriteriaSeven(int criteriaSeven) {
        this.criteriaSeven = criteriaSeven;
    }

    public int getCriteriaEight() {
        return criteriaEight;
    }

    public void setCriteriaEight(int criteriaEight) {
        this.criteriaEight = criteriaEight;
    }

    public int getCriteriaNine() {
        return criteriaNine;
    }

    public void setCriteriaNine(int criteriaNine) {
        this.criteriaNine = criteriaNine;
    }

    public int getCriteriaTen() {
        return criteriaTen;
    }

    public void setCriteriaTen(int criteriaTen) {
        this.criteriaTen = criteriaTen;
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
