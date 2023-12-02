package Customer;

import java.io.*;
import java.util.Scanner;

public class Membership_Plan {
    public boolean silver_plan;  // 3 days per week with base_price = 50 and discount = 20%
    public boolean gold_plan;  // 6 days per week with base_price = 45 and discount = 30%
    private String start_date;
    private int number_of_months;
    private int days_per_week;
    private double plan_price;

    public Membership_Plan(String start_date, int number_of_months, int days_per_week) {
        this.start_date = start_date;
        this.number_of_months = number_of_months;
        this.days_per_week = days_per_week;
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public void calc_price(int base_price, double discount) {
        if (number_of_months >= 3) {
            plan_price = ((((base_price * days_per_week) * 4) * number_of_months) * (1 - discount));
        } else {
            plan_price = ((base_price * days_per_week) * 4) * number_of_months;
        }
    }

    public double choose_plan() {
        if (days_per_week == 3) {
            calc_price(50, 0.2);
            silver_plan = true;
        } else if (days_per_week == 6) {
            calc_price(45, 0.3);
            gold_plan = true;
        }
        else{
            System.out.println("invalid number of days , please choose 3 or 6");
        }
        return plan_price;
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void  write_to_file(String start_date, int number_of_months, int days_per_week, double plan_price, boolean append) {
        try (FileWriter writer = new FileWriter("membership_plan.csv", append)) {
            if (append && new File("membership_plan.csv").length() == 0) {
                writer.write("\"start date\" , \"Number Of Months\" , \"Days Per Week\" , \"Plan Price\"" + System.lineSeparator());
            }
            writer.write(start_date + "," + number_of_months + "," + days_per_week + "," + plan_price + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Membership_Plan read_from_file() {
        Membership_Plan membership_plan = null;
        try (Scanner fileScanner = new Scanner(new File("membership_plan.csv"))) {
            while (fileScanner.hasNextLine()) {
                String[] data = fileScanner.nextLine().split(",");
                String start_date = data[0];
                int number_of_months = Integer.parseInt(data[1]);
                int days_per_week = Integer.parseInt(data[2]);
                double plan_price = Double.parseDouble(data[3]);
                membership_plan = new Membership_Plan(start_date, number_of_months, days_per_week);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return membership_plan;
    }
}
