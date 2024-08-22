
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayInMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String>monday = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.err.println("Enter the day: ");
        DayOfWeek day = DayOfWeek.valueOf((sc.nextLine()).toUpperCase());
        System.out.println("Enter the month in number: ");
        int month = sc.nextInt();
        System.out.println("Enter the Year: ");
        int year = sc.nextInt();
        System.out.println("//////DATES OF MONDAY///////");
        YearMonth yearMonth = YearMonth.of(year, month);
		LocalDate firsDayOfMonth = yearMonth.atDay(1);
		LocalDate firsMonday = firsDayOfMonth.with(day);
		if(firsMonday.isBefore(firsDayOfMonth)){
			firsMonday = firsMonday.plusWeeks(1);
		}
		LocalDate currentMonday = firsMonday;
		while(currentMonday.getMonthValue() == month){
			monday.add(currentMonday.format(formatter));
			currentMonday = currentMonday.plusWeeks(1);
		}
		monday.forEach(System.out::println);
		System.out.println("///////////////////////////");
    }
}
