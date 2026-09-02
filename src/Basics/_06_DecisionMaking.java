package Basics;

public class _06_DecisionMaking {
    public static void main(String[] args){
        /*  IMPORTANT NOTE:
            In Java, a condition must evaluate strictly to boolean (true or false).

            Numbers like 0, 1, 10 → ❌ cannot be used directly as conditions.
            References like null / non-null → ❌ cannot be used directly as conditions.

            You must explicitly check them:
            if (x > 0)
            if (obj != null)

            Unlike C++, Java does not implicitly convert values/references to boolean
         */

        // Switch Statement
        int num = 20;
        switch (num) {
            case 5:
                System.out.println("It is 5");
                break;
            case 10:
                System.out.println("It is 10");
                break;
            case 15:
                System.out.println("It is 15");
                break;
            case 20:
                System.out.println("It is 20");
                break;
            default:
                System.out.println("Not present");
        }


        // modern switch
        // no need of break statement using ->
        String day = "Sunday";
        switch(day){
            case "Saturday", "Sunday" -> System.out.println("weekend. MOJ AA GYI!!");

            case "Monday"             -> System.out.println("weekend ends. SED!");

            default                   -> System.out.println("weekdays. BORING");
        }

        // using switch as an expression to return
        String day1 = "Sunday";
        String result = switch(day1){
            case "Saturday", "Sunday" -> "weekend";    // returning weekend to result

            case "Monday"             -> "week starts"; // returning week starts to result

            default                   -> "weekdays";    // returning weekdays to result
        }; // ';' is being used here as switch is used as an expression(returns a value) not a statement(just executes code) OR it used here to end the assignment statement of String result = switch(day)......;
        System.out.println(result);

        // yield keyword: yield is used when a switch-expression case has a block {} and needs to return a value.

        String day2 = "Sunday";
        String message = switch (day2) {
            case "Saturday", "Sunday" -> {
                System.out.println("Holiday!");
                yield "Weekend";
            }

            case "Monday" -> {
                System.out.println("Back to work");
                yield "Week Starts";
            }

            default -> {
                yield "Weekday";
            }
        };

        System.out.println(message);
    }
}
