package utility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
    
    public static void main(String[] args) throws IOException  {
        
        Properties properties = new Properties();

        properties.setProperty("URL", "https://www.saucedemo.com/");
        properties.setProperty("name", "Ila");
        properties.setProperty("email", "ilasharif2020@gmail.com");
        properties.setProperty("age", "36");
        properties.setProperty("address", "New York");
        
        String filepath = System.getProperty("user.home") + "/eclipse-workspace/NewSwagLabProject/target/example.properties";
        
        FileOutputStream file = new FileOutputStream(filepath);
        properties.store(file, "Sample data in properties file");
        file.close();
        
        System.out.println("Properties have been written into " + filepath);
    }
}