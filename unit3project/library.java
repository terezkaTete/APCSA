package unit3project;

public class library {

    public static void checkFines(int d1, int m1, int y1, int d2, int m2, int y2){
        int nOfExtraDays = d2-d1 + (m2-m1)*30 + (y2-y1)*360;
        int fine;
        if(nOfExtraDays > 0){
            if(y2>y1){
                fine = 10000;
            }
            else{
                if(m2>m1){
                    fine = (m2-m1)*500;
                }
                else{
                    fine = (d2-d1)*15;
                }
            }
            System.out.printf("You should pay %d\n", fine);
        }
        else{
            System.out.println("It's allright, you don't have to pay anything");
        }
    }
    public static void main(String[] args) {
        //task1
        reader reader1 = new reader("Jozko");
        reader reader2 = new reader("Janko");

        book book1 = new book();
        book book2 = new book();

        date today = new date();
        today.setTime(5,5,2020);

        //print out all

        //task2
        book1.get(reader1.getName(), today.getDay(), today.getMonth()+1, today.getYear());
        book2.get(reader2.getName(), today.getDay(), today.getMonth()+1, today.getYear());
        today.setTime(5, 6, 2020);

        //task3
        book1.returnBook();
        checkFines(book1.expectedDay(), book1.expectedMonth(), book1.expectedYear(),
        today.getDay(), today.getMonth(), today.getYear());
        today.setTime(6, 7, 2020);
        //print all

        //task4
        book2.returnBook();
        checkFines(book2.expectedDay(), book2.expectedMonth(), book2.expectedYear(),
        today.getDay(), today.getMonth(), today.getYear());
    }
}
