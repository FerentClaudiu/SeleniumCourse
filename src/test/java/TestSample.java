import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestSample {

    WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/claudiu/TestSample/resources/chromedriver");
        TestSample testSample = new TestSample();
        //testSample.keyPress();
        //testSample.autocomplete();
        //testSample.scrollToElement();
        //testSample.switchToActiveWindow();
        //testSample.switchToAlert();
        //testSample.javaScript();
        //testSample.dragAndDrop();


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

    public void autocomplete() throws InterruptedException {
        driver.get("https://formy-project.herokuapp.com/autocomplete");
        WebElement autocomplete = driver.findElement(By.id("autocomplete"));
        autocomplete.sendKeys("Via Marte Province of Padua ");
        Thread.sleep(1000);

        WebElement autocompleteResult = driver.findElement(By.className("pac-item"));
        autocompleteResult.click();
        driver.quit();

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


}
