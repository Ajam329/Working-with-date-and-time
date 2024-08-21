import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * DOB
 */
public class DOB {

    private static LocalDate borDate;
    private static LocalDate todayDate = LocalDate.now();
    private static DateTimeFormatter formate = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Your Date Of Birth(YYYY-MM-DD):");
        String date = sc.nextLine();
        borDate = LocalDate.parse(date);
        int age = calculateAge(borDate,todayDate);
        LocalDate nextB = CalculateNextBDay(borDate,age);
        DayOfWeek dayofb = DayofBirth(borDate);
        DayOfWeek nextdayofb = nextBDay(nextB);
        System.out.println("You are "+age+" Year Old, And the Day of Your Birth was "+ dayofb +". Your next Birht day will be on "+ nextB.format(formate) +", And that will be on "+ nextdayofb);
        
    }
    

    public LocalDate getBorDate(String borDateString) {

        try {

            borDate = LocalDate.parse(borDateString);
            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        return borDate;
    }

    public static int calculateAge(LocalDate borDate, LocalDate todayDate){

        int age = Period.between(borDate, todayDate).getYears();
        return age;
    }

    public static DayOfWeek DayofBirth(LocalDate borDate){
        return borDate.getDayOfWeek();
    }
    
    public static LocalDate CalculateNextBDay(LocalDate borDate, int age){
        return borDate.plusYears(age+1);
    }
    
    public static DayOfWeek nextBDay(LocalDate Date){
        return Date.getDayOfWeek();
    }
    

}