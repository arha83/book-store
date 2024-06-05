import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;


public class Admin extends User {
    
    // constructor methods
    public Admin(String userName, String password, String email){
        super(userName, password, email, true);
    }

    
    public static ArrayList<User> loadAdmins(){
        File adminFile= new File("./admins.csv");
        String line;
        String adminData[];
        ArrayList<User> admins= new ArrayList<>();
        Admin newAdmin;
        
        Scanner scanner;
        try{
            scanner= new Scanner(adminFile);
            while(scanner.hasNextLine()){
                line= scanner.nextLine();
                adminData= line.split(",");
                newAdmin= new Admin(adminData[0], adminData[1], adminData[2]);
                admins.add(newAdmin);
            }
        } catch(FileNotFoundException e){
            System.out.println("Customer file not found!");
        }

        return admins;
    }

    public static void saveAdmins(ArrayList<User> admins){
        String line;
        try{
            FileWriter adminWriter= new FileWriter("./admins.csv");
            for(User admin : admins){
                if(admin.getClass() != Admin.class) continue;
                line= admin.getUsername() + "," + admin.getPassword() + "," + admin.getEmail() + "\n";
                adminWriter.write(line);
            }
            adminWriter.close();
        } catch(IOException e){
            System.out.println("Could not save to customers!");
        }
    }
}
