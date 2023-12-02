package MainPage;
import java.io.*;
public class file_Creation {
    public static void main(String[] args) {
        try {
            // Creating a file with a specific path
            File file = new File("C:\\Users\\Mariam\\IdeaProjects\\GYM_project\\MainPage\\GymInfo.txt");
            boolean fileCreated = file.createNewFile();
            System.out.println("File created: " + fileCreated);

            // Writing to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Mariam\\IdeaProjects\\GYM_project\\MainPage\\GymInfo.txt"));
            writer.write("Fitness Gym \n");
            writer.write("cairo, nasr city \n");
            writer.write("0118956245\n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
