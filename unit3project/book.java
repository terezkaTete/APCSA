package unit3project;

public class book{
    private boolean isBorrowed = false;
    private String borrower;
    private int dayExpected;
    private int monthExpected;
    private int yearExpected;
    book(){

    }

    void get(String reader, int d, int m, int y){
        this.isBorrowed = true;
        this.dayExpected = d;
        this.monthExpected = m;
        this.yearExpected = y;
        this.borrower = reader;
    }
    void returnBook(){
        this.isBorrowed =false;
    }

    int expectedDay(){
        return this.dayExpected;
    }
    int expectedMonth(){
        return this.monthExpected;
    }
    int expectedYear(){
        return this.yearExpected;
    }

}
