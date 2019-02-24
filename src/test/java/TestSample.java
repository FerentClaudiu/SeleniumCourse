import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;

public class TestSample  {

    private static WebDriver driver;

    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "/home/claudiu/TestSample/resources/chromedriver");
        driver = new ChromeDriver();
    }


    public static void main(String[] args)  {

        TestSample testSample = new TestSample();
        testSample.openBrowser();
        Form form = new Form();
        form.completeForm(driver);
        //testSample.keyPress();
        //testSample.autocomplete();
        //testSample.scrollToElement();
        //testSample.switchToActiveWindow();
        //testSample.switchToAlert();
        //testSample.javaScript();
        //testSample.dragAndDrop();
        //testSample.radioButtons();
        //testSample.checkboxes();
        //testSample.datepicker();
        //testSample.dropdown();
        //testSample.fileUpload();
        //testSample.completeForm();




    }

    public void keyPress() {
        driver.get("https://formy-project.herokuapp.com/keypress");
        WebElement name = driver.findElement(By.id("name"));
        name.click();
        name.sendKeys("Ferent Claudiu");

        WebElement button = driver.findElement(By.id("button"));
        button.click();
        driver.quit();

    }

    public void autocomplete() {
        driver.get("https://formy-project.herokuapp.com/autocomplete");
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement autocomplete = driver.findElement(By.id("autocomplete"));
        autocomplete.sendKeys("Via Marte Province of Padua ");
        //Thread.sleep(1000);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement autocompleteResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pac-item")));

        //WebElement autocompleteResult = driver.findElement(By.className("pac-item"));
        autocompleteResult.click();

    }

    public void scrollToElement() {
        driver.get("https://formy-project.herokuapp.com/scroll");
        WebElement name = driver.findElement(By.id("name"));
        Actions actions = new Actions(driver);
        actions.moveToElement(name);
        name.sendKeys("Claudiu Ferent");

        WebElement date = driver.findElement(By.id("date"));
        date.sendKeys("02/20/2019");
        driver.quit();
    }

    public void switchToActiveWindow() {
        driver.get("https://formy-project.herokuapp.com/switch-window");
        WebElement newTabButton = driver.findElement(By.id("new-tab-button"));
        newTabButton.click();

        String originalHandle = driver.getWindowHandle();

        for (String handle1 : driver.getWindowHandles()) {
            driver.switchTo().window(handle1);
        }
        driver.switchTo().window(originalHandle);


    }

    public void switchToAlert() {
        driver.get("https://formy-project.herokuapp.com/switch-window");
        WebElement alertButton = driver.findElement(By.id("alert-button"));
        alertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    public void javaScript() {
        driver.get("https://formy-project.herokuapp.com/modal");
        WebElement modalButton = driver.findElement(By.id("modal-button"));
        modalButton.click();

        WebElement closeButton = driver.findElement(By.id("close-button"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", closeButton);

    }

    public void dragAndDrop() {
        driver.get("https://formy-project.herokuapp.com/dragdrop");
        WebElement image = driver.findElement(By.id("image"));

        WebElement box = driver.findElement(By.id("box"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(image, box).build().perform();


    }

    public void radioButtons() {
        driver.get("https://formy-project.herokuapp.com/radiobutton");

        WebElement radioButton1 = driver.findElement(By.id("radio-button-1"));
        radioButton1.click();
        WebElement radioButton2 = driver.findElement(By.cssSelector("input[value='option2"));
        radioButton2.click();
        WebElement radioButton3 = driver.findElement(By.xpath("/html/body/div/div[3]/input"));
        radioButton3.click();

    }

    public void checkboxes() {
        driver.get("https://formy-project.herokuapp.com/checkbox");
        WebElement checkbox1 = driver.findElement(By.id("checkbox-1"));
        checkbox1.click();
        WebElement checkbox2 = driver.findElement(By.cssSelector("#checkbox-2"));
        checkbox2.click();
        WebElement checkbox3 = driver.findElement(By.cssSelector("#checkbox-3"));
        checkbox3.click();
    }

    public void datepicker() {
        driver.get("https://formy-project.herokuapp.com/datepicker");
        WebElement datefield = driver.findElement(By.id("datepicker"));
        datefield.sendKeys("02/22/2019");
        datefield.sendKeys(Keys.RETURN);

    }

    public void dropdown() {
        driver.get("https://formy-project.herokuapp.com/dropdown");
        WebElement dropdownButton = driver.findElement(By.id("dropdownMenuButton"));
        dropdownButton.click();

        WebElement autocompleteItem = driver.findElement(By.id("autocomplete"));
        autocompleteItem.click();

    }

    public void fileUpload() {
        driver.get("https://formy-project.herokuapp.com/fileupload");
        WebElement uploadField = driver.findElement(By.id("file-upload-field"));
        uploadField.sendKeys("image.jpeg");
    }

    public  void completeForm() {

        driver.get("https://formy-project.herokuapp.com/form");
        driver.findElement(By.id("first-name")).sendKeys("Claudiu");
        driver.findElement(By.id("last-name")).sendKeys("Ferent");
        driver.findElement(By.id("job-title")).sendKeys("QA Engineer");
        driver.findElement(By.id("radio-button-2")).click();
        driver.findElement(By.id("checkbox-2")).click();
        driver.findElement(By.cssSelector("option[value='1']")).click();
        driver.findElement(By.id("datepicker")).sendKeys("02/23/2019");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);
        driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));

        String alertText = alert.getText();
        assertEquals("The form was successfully submitted!", alertText);


    }


}
