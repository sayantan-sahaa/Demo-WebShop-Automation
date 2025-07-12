package base;

import java.util.Map;
import java.util.HashMap;

public class DriverManagerFactory {


    public static Map<String, Class<? extends DriverManager>> driverMap = new HashMap<>();

    public void setdriverMap(Class<? extends DriverManager> clazz, String browser){
        driverMap.put(browser, clazz);
    }

    public DriverManager getDriverManager(String browser){
        Class<? extends DriverManager> clazz = driverMap.get(browser);
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException | SecurityException e) {
            throw new RuntimeException("Failed to create driver instance for browser: " + browser, e);
        }
    }
    
}
