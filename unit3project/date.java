package unit3project;


public class date {
    private int day;
    private int month;
    private int year;

    void setTime(int d, int m, int y){
        this.day = d;
        this.month = m;
        this.year = y;
    }

    int getDay(){
        return this.day;
    }

    int getMonth(){
        return this.month;
    }

    int getYear(){
        return this.year;
    }
}
