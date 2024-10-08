package airline;

import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class DateUtils {
    public static String getCurrentDay() {
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Today Int: " + todayInt + "\n");

        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        System.out.println("Today Str: " + todayStr + "\n");

        return todayStr;
    }

    //Get The Current Day plus days. You can change this method based on your needs.
    public static String getCurrentDayPlus(int days) {
        LocalDate currentDate = LocalDate.now();

        int dayOfWeekPlus = currentDate.getDayOfWeek().plus(days).getValue();
        return Integer.toString(dayOfWeekPlus);
    }

    //Click to given day
    public static void clickGivenDay(List<WebElement> elementList, String day) {
        //DatePicker is a table. Thus we can navigate to each cell
        //and if a cell matches with the current date then we will click it.
        /**Functional JAVA version of this method.*/
        elementList.stream()
                .filter(element -> element.getText().contains(day))
                .findFirst()
                .ifPresent(WebElement::click);

    }
}
