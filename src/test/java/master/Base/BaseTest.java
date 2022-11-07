package master.Base;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public class BaseTest {
    public static Logger log = Logger.getLogger(String.valueOf(BaseTest.class));
    protected static AppiumDriver<MobileElement> appiumDriver;
    protected boolean localAndroid=true;
    @BeforeScenario
    public void StarScenario() throws MalformedURLException {
        if (localAndroid){
            log.info("----Localde Android Testi Basliyor----");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.lcwaikiki.android");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.lcwaikiki.android.ui.HomeActivity");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,3000);
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            appiumDriver = new AndroidDriver(url,desiredCapabilities);
        }else{
            log.info("----Localde IOS Testi Basliyor----");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID,"IOS UDID");
            desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID,"IOS BUNDLE ID");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"IPHONE");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"3.5.4");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,3000);
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            appiumDriver = new IOSDriver(url,desiredCapabilities);
        }
    }
    @AfterScenario
    public void afterScenario(){
        appiumDriver.quit();
        log.info("----Mobil Test Bitti----");
    }



}