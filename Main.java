import Customer.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Taking input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter start date: ");
        String start_date = scanner.nextLine();
        System.out.print("Enter number of months: ");
        int number_of_months = scanner.nextInt();
        System.out.print("Enter days per week: ");
        int days_per_week = scanner.nextInt();


        Membership_Plan membershipPlan = new Membership_Plan(start_date, number_of_months, days_per_week);
        double plan_price = membershipPlan.choose_plan();
        System.out.println("Plan Price: " + plan_price + " EGP");
        // Write
        Membership_Plan.write_to_file(start_date, number_of_months, days_per_week, plan_price, true);
    }
}
