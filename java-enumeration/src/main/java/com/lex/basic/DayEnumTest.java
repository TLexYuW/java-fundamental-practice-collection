package com.lex.basic;

public class DayEnumTest {
    Day day;

    public DayEnumTest() {
    }

    public DayEnumTest(Day day) {
        this.day = day;
    }

    public void tellItLikeItIs(){
        switch (day){
            case MONDAY:
                System.out.println("Blue Mondays");
                break;
            case FRIDAY:
                System.out.println("Friday Nights");
                break;
            case SATURDAY, SUNDAY:
                System.out.println("Weekends are best");
                break;
            default:
                System.out.println("Midweek days are so-so");
                break;
        }
    }

    public void mapEnum(Day day){
        switch (day){
            case MONDAY:
                System.out.println("This is Monday");
                break;
            case FRIDAY:
                System.out.println("This is Friday");
                break;
            case SATURDAY, SUNDAY:
                System.out.println("This is Weekends");
                break;
            default:
                System.out.println("Midweek days");
                break;
        }
    }

    public static void main(String[] args) {
        DayEnumTest firstDay = new DayEnumTest(Day.MONDAY);
        firstDay.tellItLikeItIs();
        DayEnumTest thirdDay = new DayEnumTest(Day.WEDNESDAY);
        thirdDay.tellItLikeItIs();
        DayEnumTest fifthDay = new DayEnumTest(Day.FRIDAY);
        fifthDay.tellItLikeItIs();
        DayEnumTest sixthDay = new DayEnumTest(Day.SATURDAY);
        sixthDay.tellItLikeItIs();
        DayEnumTest seventhDay = new DayEnumTest(Day.SUNDAY);
        seventhDay.tellItLikeItIs();

        DayEnumTest dayEnumTest = new DayEnumTest();
        dayEnumTest.mapEnum(Day.TUESDAY);
    }

}
