import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class MainPage {

private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Верхняя кнопка "Заказать"
    private final By headerOrderButton = By.xpath("//div[contains(@class,'Header')]//button[text()='Заказать']");
    //Нижняя кнопка "Заказать"
    private final By bodyOrderButton = By.xpath("//div[contains(@class,'FinishButton')]//button[text()='Заказать']");
    //Клик по верхней кнопке "Заказать"
    public void headerOrderButtonClick () {
        driver.findElement(headerOrderButton).click();
    }
    //Клик по нижней кнопке "Заказать"
    public void bodyOrderButtonClick () {
        WebElement element = driver.findElement(bodyOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(bodyOrderButton).click();
    }

    //Метод принимает вопрос и ответ, ждет дропдаун, возвращает ответ
    public String faqInfoClick (String requestQuestion, String answerQuestion) {
        JavascriptExecutor bottomView = ((JavascriptExecutor) driver);
        bottomView.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.xpath("//div[@class='accordion']//div//div[text()='" + requestQuestion + "']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='accordion']//div//div[text()='" + requestQuestion + "']"))));
        return driver.findElement(By.xpath("//div[@class='accordion']//div//p[text()='" + answerQuestion + "']")).getText();
    }
}
