package gui;

import io.appium.java_client.windows.WindowsDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.qam.gui.WinDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class WinDriverTest {
    private static WindowsDriver pairwiseSession = null;
    private static WebElement pairwiseResult = null;

    @BeforeAll
    public static void setup() {

        try {
            var capabilities = new DesiredCapabilities();
//            capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
//            capabilities.setCapability("app", "C:\\path\\to\\java.exe");
//            capabilities.setCapability("app", "Root");
//            capabilities.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
            capabilities.setCapability("app", "Root");
            capabilities.setCapability("appTopLevelWindow", "Root");
//            capabilities.setCapability("appArguments", "-jar D:\\_src\\QAMaster\\src\\main\\resources\\pairwise\\pairwise.jar");
//            capabilities.setCapability("appWorkingDirectory", "D:\\_src\\QAMaster\\src\\main\\resources\\pairwise");
//            capabilities.setCapability("appWorkingDirectory", "../../main/resources/pairwise");
//            capabilities.setCapability("platformName", "Windows");
//            capabilities.setCapability("deviceName", "WindowsPC");

//            capabilities.setCapability("app", "../../main/resources/pairwise/pairwise.bat");

            WinDriver.start();
            pairwiseSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            pairwiseSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            WinDriver.stop();
//            pairwiseResult = pairwiseSession.findElementByAccessibilityId("CalculatorResults");
//            assertNotNull(pairwiseResult);

        } catch (Exception e) {
            WinDriver.stop();
            e.printStackTrace();
        } finally {
        }
    }

    @Test
    void basicTest() {
//        pairwiseSession.launchApp();
    }
}
