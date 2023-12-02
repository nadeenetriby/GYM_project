import java.io.*;
import java.util.Scanner;

public class InBody {
 protected int Coustmer_id;
   protected String Date_of_InBody;
    protected double height;
   protected double Total_Weight;
   protected double Body_Fat;
   protected double Minerals;
   protected double Body_Water;
   protected double Protein ;
    public void Data_getter(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your id ");
        Coustmer_id = s.nextInt();
        System.out.println("Enter the date of your InBody");
        Date_of_InBody = s.next();
        System.out.println("Enter your total weight");
        Total_Weight = s.nextDouble();
        System.out.println("Enter your height");
        height = s.nextDouble();
        System.out.println("Enter your body fat");
        Body_Fat = s.nextDouble();
        System.out.println("Enter your mineral percentage");
        Minerals = s.nextDouble();
        System.out.println("Enter your body water percentage");
        Body_Water = s.nextDouble();
        System.out.println("Enter your protein percentage");
        Protein = s.nextDouble();
    }
    private static void writeDataToCSV(PrintWriter pw, String[] data) {
        for (int i = 0; i < data.length; i++) {
            pw.print(data[i]);
                pw.print(",");

        }
        pw.println(); // Move to the next line
    }
    public void CereateCSVFile(){
    String file = "InBody.csv";
    Data_getter();
        String [] Data = {Integer.toString(Coustmer_id),Date_of_InBody, Double.toString(Total_Weight), Double.toString(height), Double.toString(Body_Fat), Double.toString(Minerals), Double.toString(Body_Water), Double.toString(Protein)};
    String []Headers = {"Coustmer_Id", "Date_of_InBody", "Total_weight", "Height", "Body_fat", "Minerals", "Water_percentage", "Protein_percentage"};
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            // writing the headers as (id, weight. height ...etc)
            writeDataToCSV(pw, Headers);
            // writing data to file
            writeDataToCSV(pw, Data);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void AppendData(){
        String file = "InBody.csv";
        Data_getter();
        String [] Data = {Integer.toString(Coustmer_id),Date_of_InBody, Double.toString(Total_Weight), Double.toString(height), Double.toString(Body_Fat), Double.toString(Minerals), Double.toString(Body_Water), Double.toString(Protein)};
        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            // writing data to file
            writeDataToCSV(pw, Data);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static boolean EmptyFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return br.readLine() != null; // Check if the file has at least one line
        } catch (IOException e) {
            // Handle file I/O exception
            e.printStackTrace();
            return false; // Return false if an error occurs
        }
    }
    public void DataSavingToCSV(){
        if(EmptyFile("InBody.csv"))
        {
            AppendData();
            System.out.println("wowwww");
        }
        else
        CereateCSVFile();
    }
}
