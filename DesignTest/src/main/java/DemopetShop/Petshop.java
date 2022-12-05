package DemopetShop;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Set;

public class Petshop {
    WebDriver driver;
    public void Main() {
        String BaseURL = "https://demoqa.com/books";
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BaseURL);

    }
    //Login Function
    public void Login() throws InterruptedException{
        driver.findElement(By.id("login")).click();
        Thread.sleep(5000);
//        driver.findElement(By.id("userName")).click();
        driver.findElement(By.id("userName")).sendKeys("Surendra1998");
//        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("Surendra@98");
        driver.findElement(By.id("login")).click();
    }
    // To Open Elements
    public void Elements() throws InterruptedException {
        driver.findElement(By.xpath("(//div[@class='header-text'])[1]")).click();
        driver.findElement(By.id("item-0")).click();
        driver.findElement(By.id("userName")).sendKeys("Surendra");
        driver.findElement(By.id("userEmail")).sendKeys("jupudisurendra@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Guntur");
        Thread.sleep(3000);
        Actions scr = new Actions(driver);
        scr.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);

        driver.findElement(By.id("permanentAddress")).sendKeys("Guntur");
        // Thread.sleep(7000);
        driver.findElement(By.id("submit")).click();
        Thread.sleep(3000);
//        driver.findElement(By.xpath("//*[@id=\"item-1\"]/span")).click();

    }
    // Checkbox Function
    public void Checkbox() throws InterruptedException {
        Actions scr = new Actions(driver);
        scr.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"item-1\"]/span")).click();
        driver.findElement(By.className("rct-checkbox")).click();
        WebElement chbx = driver.findElement(By.className("rct-checkbox"));
        Boolean flag = chbx.isSelected();
        if(flag == true){
            System.out.println("Already Selected");
        }
        else{
            chbx.click();
        }
        // driver.findElement(By.className("rct-option rct-option-expand-all")).click();
        Thread.sleep(5000);

    }
    // Radio buttons Functionality
    public void Radio() throws InterruptedException {
        driver.findElement(By.id("item-2")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]")).click();
        WebElement radiotext = driver.findElement(By.className("mt-3"));
        System.out.println("RadioText output:"+radiotext.getText());
        Actions scr = new Actions(driver);
        scr.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
    }
    //WebTables function
    public void Webtables() throws InterruptedException {
        driver.findElement(By.id("item-3")).click();
//        driver.findElement(By.id("addNewRecordButton")).click();
//        driver.findElement(By.id("firstName")).sendKeys("PawanKalyan");
//        driver.findElement(By.id("lastName")).sendKeys("PowerStar");
//        driver.findElement(By.id("userEmail")).sendKeys("jupudisurendra21@gmail.com");
//        driver.findElement(By.id("age")).sendKeys("23");
//        driver.findElement(By.id("salary")).sendKeys("20000");
//        driver.findElement(By.id("department")).sendKeys("Testing");
        List<WebElement> LabelElt = driver.findElements(By.className("rt-table"));
        System.out.println(LabelElt);
        if(LabelElt.size() !=0){
            System.out.println(LabelElt.size()+"Data in Webtables option");
            for (WebElement Label : LabelElt) {
                System.out.println(Label.getText());
                Thread.sleep(7000);
            }
        }
        Actions scr = new Actions(driver);
        scr.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
    }
    //Buttons Function
    public void Buttons() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"item-4\"]")).click();
        Thread.sleep(3000);
        // driver.findElement(By.id("doubleClickBtn")).click();
        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(By.xpath("//*[@id=\"doubleClickBtn\"]"));
        actions.doubleClick(elementLocator).perform();
        WebElement buttonText = driver.findElement(By.id("doubleClickMessage"));
        System.out.println("doubleClick output:"+buttonText.getText());

        Actions right = new Actions(driver);
        WebElement eleRight = driver.findElement(By.id("rightClickBtn"));
        right.contextClick(eleRight).perform();
        WebElement rtBtnText = driver.findElement(By.id("rightClickMessage"));
        System.out.println("rightClick output:"+rtBtnText.getText());
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();
        WebElement clkText = driver.findElement(By.id("dynamicClickMessage"));
        System.out.println("Click output:"+clkText.getText());
        Actions scr = new Actions(driver);
        scr.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
    }
    //Links Function
    public void Links() throws InterruptedException {
        driver.findElement(By.id("item-5")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("simpleLink")).click();
        String  parentwin = driver.getWindowHandle();
        System.out.println(parentwin);

        Set<String> Windowhandles = driver.getWindowHandles();
        for(String ChildWin: Windowhandles){
            if(!parentwin.equals(ChildWin)){
                driver.switchTo().window(ChildWin);
                Thread.sleep(3000);
                driver.close();
            }
        }
        driver.switchTo().window(parentwin);

        Thread.sleep(2000);
        driver.findElement(By.id("dynamicLink")).click();
        String  parwin = driver.getWindowHandle();
        System.out.println(parwin);
        Set<String> Winhandles = driver.getWindowHandles();
        for(String ChildWin: Winhandles){
            if(!parentwin.equals(ChildWin)){
                driver.switchTo().window(ChildWin);
                Thread.sleep(3000);
            }
        }
        driver.switchTo().window(parentwin);
        driver.findElement(By.id("created")).click();
        WebElement crText = driver.findElement(By.id("created"));
        System.out.println("createText output:"+crText.getText());
        driver.findElement(By.id("no-content")).click();
        WebElement noConText = driver.findElement(By.id("no-content"));
        System.out.println("NoContent Output:"+noConText.getText());
        driver.findElement(By.id("moved")).click();
        WebElement MovedText = driver.findElement(By.id("moved"));
        System.out.println("Moved Output:"+MovedText.getText());
        Actions scr = new Actions(driver);
        scr.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.id("bad-request")).click();
        WebElement BadReqText = driver.findElement(By.id("bad-request"));
        System.out.println("BadRequest Output:"+BadReqText.getText());
        driver.findElement(By.id("unauthorized")).click();
        WebElement unAuthText = driver.findElement(By.id("unauthorized"));
        System.out.println("UnAuthentication Output:"+unAuthText.getText());
        driver.findElement(By.id("forbidden")).click();
        WebElement forbiddenText = driver.findElement(By.id("forbidden"));
        System.out.println("Forbidden Output:"+forbiddenText.getText());
        driver.findElement(By.id("invalid-url")).click();
        WebElement invalidUrlText = driver.findElement(By.id("invalid-url"));
        System.out.println("Invalid Output:"+invalidUrlText.getText());
        Thread.sleep(5000);
        scr.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
    }
    //Upload Function
    public void Upload() throws InterruptedException{
        driver.findElement(By.id("item-7")).click();
        driver.findElement(By.id("downloadButton")).click();
        WebElement uploadElement = driver.findElement(By.id("uploadFile"));
        uploadElement.sendKeys("C:\\Users\\SJUPUDI\\Downloads\\sampleFile.jpeg");
//        Thread.sleep(2000);
//        Actions scr = new Actions(driver);
//        scr.sendKeys(Keys.PAGE_DOWN).build().perform();
        //Thread.sleep(3000);
    }

    //    public void Forms(){
//        driver.findElement(By.xpath("(//div[@class='header-text'])[2]")).click();
//
//    };
    public void Forms(){
        driver.findElement(By.xpath("(//div[@class='header-text'])[2]")).click();
        driver.findElement(By.id("item-0")).click();
    }
}
