package master.Methods;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import master.Base.BaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Methods extends BaseTest {
    private static final Logger logger = LogManager.getLogger(Methods.class);

    @Step("Sayfayi kaydir")
    public void swipeByUP(){
        final int ANIMATION_TIME = 200; // ms
        final int PRESS_TIME = 200; // ms

        int edgeBorder = 300; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = appiumDriver.manage().window().getSize();
        System.out.println("dims====="+ dims);
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);

        new TouchAction(appiumDriver)
                .press(pointOptionStart)
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointOptionEnd)
                .release().perform();
    }
    @Step("<id> ID'li elementi bul ve tikla")
    public void clickByID(String id){
        appiumDriver.findElement(By.id(id)).click();
        log.info(id + " Element tiklandi.");
    }

    @Step("<xpath> Xpath'li elementi bul ve tikla")
    public void clickByXPATH(String xpath){
        appiumDriver.findElement(By.xpath(xpath)).click();
        log.info(xpath + " Element tiklandi.");
    }
    @Step("<time> saniye bekle")
    public void waitForSecond(int time) throws InterruptedException {
        Thread.sleep(time*1000);
    }
    @Step("<id> ID'li element <text> değerini içeriyor mu kontrol et")
    public void ControlElementByID(String id,String text){
        MobileElement element = appiumDriver.findElement(By.id(id));
        Assert.assertTrue("Textler farkli",element.getText().equals(text));
    }
    @Step("<id> ID'li elementi bul ve <text> değerini yaz")
    public void sendKeysByID(String id,String text){
        appiumDriver.findElement(By.id(id)).sendKeys(text);
        log.info(text + " degeri yazildi");
    }
    @Step("<xpath> Xpath'li elementler arasında rasgele bir tanesine tıkla")
    public void clickRandomElementByXpath(String xpath){
        List<MobileElement> elements = appiumDriver.findElements(By.xpath(xpath));
        Random rand = new Random();
        int index = rand.nextInt(elements.size());
        elements.get(index).click();
        log.info("Rastgele secim yapildi");
    }
    @Step("<id> ID'li elementler arasında rasgele bir tanesine tıkla")
    public void clickRandomElementByID(String id){
        List<MobileElement> elements = appiumDriver.findElements(By.id(id));
        Random rand = new Random();
        int index = rand.nextInt(elements.size());
        elements.get(index).click();
        log.info("Rastgele secim yapildi");
    }
    @Step("Ucus saatleri kontrol edilir")
    public void controlFlightTime(){

    }
    @Step("<id> ID'li elementin textini al")
    public void getTextID(String id){
        MobileElement element=appiumDriver.findElement(By.id(id));
        String message=element.getText();
        log.info("Elementin texti : " +message);
    }
    @Step("<xpath> XPATH'li elementin textini al")
    public void getTextXpath(String xpath){
        MobileElement element=appiumDriver.findElement(By.xpath(xpath));
        String message=element.getText();
        log.info("Elementin texti : " +message);
    }
    @Step("<day> Gün sonrasini sec")
    public void dateSelect(int day){
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY");
        Date dt = new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(dt);;
        cl.add(Calendar.DATE, day);
        dt=cl.getTime();
        String str = df.format(dt);
        System.out.println("the date today is " + str);
        MobileElement el = appiumDriver.findElement(By.id("com.m.qr:id/fragment_calendar_root_text_view"));
        el.sendKeys(str);
    }
}
