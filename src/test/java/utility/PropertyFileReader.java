package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
    
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        String filepath = System.getProperty("user.home") + "/eclipse-workspace/NewSwagLabProject/target/example.properties";
        
        FileInputStream file = new FileInputStream(filepath);
        properties.load(file);
        file.close();
        
        // Read the data from the property file
        String URL = properties.getProperty("URL");
        String name = properties.getProperty("name");
        String email = properties.getProperty("email");
        String age = properties.getProperty("age");
        String address = properties.getProperty("address");
        
        System.out.println(URL + " " + name + " " + age + " " + email + " " + address);
    }
}