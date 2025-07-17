package listeners;
import static hooks.Hooks.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShotUtil {

    private ScreenShotUtil() {
    }

    public static void takeScreenShot(String stepName) {
        try {
            File srcFile = ((TakesScreenshot) getDr()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File("screenshots/" + stepName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Start screen recording using Shift+R shortcut and Enter
     */
    public static void startScreenRecord() {
        try {
            System.out.println("🎬 Starting screen recording with Shift+R shortcut...");
            
            Robot robot = new Robot();
            robot.delay(1000); // Small delay to ensure window is focused
            
            // Press Shift + R
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_R);
            
            // Release keys in reverse order
            robot.keyRelease(KeyEvent.VK_R);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            
            // Small pause to let system process the shortcut
            robot.delay(1000);
            
            // Press Enter to confirm (needed for starting)
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            
            System.out.println("✅ Screen recording started");
        } catch (AWTException e) {
            System.err.println("❌ Failed to start screen recording: " + e.getMessage());
        }
    }

    /**
     * Stop screen recording using Shift+R shortcut (no Enter required)
     */
    public static void stopScreenRecord() {
        try {
            System.out.println("⏹️ Stopping screen recording with Shift+R shortcut...");
            
            Robot robot = new Robot();
            robot.delay(500); // Small delay
            
            // Press Shift + R
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_R);
            
            // Release keys in reverse order
            robot.keyRelease(KeyEvent.VK_R);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            
            // No Enter press needed for stopping
            
            System.out.println("✅ Screen recording stopped");
            System.out.println("📁 Recording saved to your default videos folder");
        } catch (AWTException e) {
            System.err.println("❌ Failed to stop screen recording: " + e.getMessage());
        }
    }
}