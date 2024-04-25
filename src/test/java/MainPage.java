import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class MainPage{

private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Верхняя кнопка "Заказать"
    private final By firstOrderButton = By.xpath("//button[@class='Button_Button__ra12g']");
    public void firstOrderButtonClick () {
        driver.findElement(firstOrderButton).click();
    }
    //Нижняя кнопка "Заказать"
    private final By secondOrderButton = By.cssSelector("#root > div > div.Home_HomePage__ZXKIX > div.Home_ThirdPart__LSTEE > div.Home_RoadMap__2tal_ > div.Home_FinishButton__1_cWm > button");

    public void secondOrderButtonClick () {
        driver.findElement(secondOrderButton).click();
    }

    //Скролл вниз до упора
    public void scrollToBottom (){
        JavascriptExecutor bottomView = ((JavascriptExecutor) driver);
        bottomView.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    //Клик на вопросы о важном:
    //Сколько это стоит? И как оплатить?
    public Boolean faqPaymentInfoClick () {
        driver.findElement(By.xpath("//div[@id=\"accordion__heading-0\"]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id=\"accordion__panel-0\"]/p"))));
        return driver.findElement(By.xpath("//p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']")).isDisplayed();
    }

    //Хочу сразу несколько самокатов! Так можно?
    public Boolean faqMultipleOrderClick () {
        driver.findElement(By.xpath("//div[@id=\"accordion__heading-1\"]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id=\"accordion__panel-1\"]/p"))));
        return driver.findElement(By.xpath("//p[text()='Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']")).isDisplayed();
    }

    //Как рассчитывается время аренды?
    public Boolean faqTermsClick () {
        driver.findElement(By.xpath("//div[@id=\"accordion__heading-2\"]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id=\"accordion__panel-2\"]/p"))));
        return driver.findElement(By.xpath("//p[text()='Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']")).isDisplayed();
    }

    //Можно ли заказать самокат прямо на сегодня?
    public Boolean faqTodayOrderClick () {
        driver.findElement(By.xpath("//div[@id=\"accordion__heading-3\"]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id=\"accordion__panel-3\"]/p"))));
        return driver.findElement(By.xpath("//p[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']")).isDisplayed();
    }

    //Можно ли продлить заказ или вернуть самокат раньше?
    public Boolean faqExtendClick () {
        driver.findElement(By.xpath("//div[@id=\"accordion__heading-4\"]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id=\"accordion__panel-4\"]/p"))));
        return driver.findElement(By.xpath("//p[text()='Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']")).isDisplayed();
    }

    //Вы привозите зарядку вместе с самокатом?
    public Boolean faqChargerClick () {
        driver.findElement(By.xpath("//div[@id=\"accordion__heading-5\"]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id=\"accordion__panel-5\"]/p"))));
        return driver.findElement(By.xpath("//p[text()='Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']")).isDisplayed();
    }

    //Можно ли отменить заказ?
    public Boolean faqCancelClick () {
        driver.findElement(By.xpath("//div[@id=\"accordion__heading-6\"]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id=\"accordion__panel-6\"]/p"))));
        return driver.findElement(By.xpath("//p[text()='Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']")).isDisplayed();
    }

    //Я живу за МКАДом, привезёте?
    public Boolean faqFarAwayClick () {
        driver.findElement(By.xpath("//div[@id=\"accordion__heading-7\"]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@id=\"accordion__panel-7\"]/p"))));
        return driver.findElement(By.xpath("//p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']")).isDisplayed();
    }

}
