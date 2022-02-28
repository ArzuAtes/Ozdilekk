import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Random;


public class BasePage extends BaseTest{

    Logger logger = LogManager.getLogger(BasePage.class);

    @Step("<wait> saniye bekle")
    public void waitForseconds(int wait)throws InterruptedException {
        Thread.sleep(1000*wait);
    }
    @Step("id <id> 'ye tıklandı")
    public void clickByid(String id) {
        appiumDriver.findElement(By.id(id)).click();
        System.out.println(id + " tıklandı");
        logger.info(id + " tıklandı");

    }
    @Step("uygulama açıldı mı  kontrol et ")
    public void controlEt() throws InterruptedException {
        if (appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/tv_startShoppingStore")).isDisplayed()){
            System.out.println("Alışverişe başla butonu görüldü.");
            waitForseconds(3);
        }
    }
    @Step("xpath <xpath> 'ye tıklandı")
    public void clickByxpath(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
        System.out.println(xpath + " tıklandı");
    }
    //https://appium.io/docs/en/commands/interactions/touch/scroll/
    @Step("iki defa sayfada en alta kadar in ve geri yukarı çık")
    public void scrollTwo() {
        for (int i = 1; i < 3; i++) {
            TouchAction action = new TouchAction(appiumDriver);
            action.press(PointOption.point(538, 1538)).moveTo(PointOption.point(538, 420)).release().perform();
        }
    }
    @Step("Sayfadan herhangi bir ürün seçildi.")
    public void selectRondamproduct(){
        Random rdn = new Random();
        List<MobileElement> us = appiumDriver.findElements(By.xpath("//*[@resource-id = 'com.ozdilek.ozdilekteyim:id/recyclerView']/android.widget.FrameLayout"));
        System.out.println("pd"  +us);
        MobileElement element =  us.get(rdn.nextInt(us.size()));
        System.out.println("element"  +element);
        element.click();
    }
    @Step("<id> İd'li elemente <text> değerini yaz")
    public void sendKeysid(String id,String text){
        appiumDriver.findElement(By.id(id)).sendKeys(text);
        System.out.println(id + "eleentini bul ve " + text + " değerini yaz"  );
    }
    @Step("xpath <xpath> 'e tıklandı")
    public void clickxpath(String xpath) {
        for (int i=1;i>3;i++)
        appiumDriver.findElement(By.xpath(xpath)).click();
        System.out.println(xpath + " tıklandı");
    }
    @Step("ürünü favorilere eklemek için ekle butonuna bas")
    public void addFavorite() throws InterruptedException {
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/imgFav")).click();
        System.out.println("Favorilere ekle butonuna basildi.");
        logger.info("Favorilere ekle butonuna basildi.");
    }

    @Step("id <id> li butona tıkla")
    public void clickid(String id){
        for (int i=0;i<2;i++) {
            appiumDriver.findElement(By.id(id)).click();
            System.out.println(id + "butona tıklandı");
        }
    }






}
