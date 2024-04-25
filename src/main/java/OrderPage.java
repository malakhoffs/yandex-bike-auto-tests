import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.*;



public class OrderPage {
    private final WebDriver driver;
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }


    //Поле для ввода имени
    private final By firsrNameField = By.xpath("//input[@placeholder='* Имя']");
    //Поле для ввода фамилии
    private final By secondNameField = By.xpath("//input[@placeholder='* Фамилия']");
    //Поле для ввода адреса
    private final By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле для выбора станции метро
    private final By metroStationField = By.xpath("//input[@placeholder='* Станция метро']");
    //Поле для ввода номера телефона
    private final By PhoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private final By nextButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Поле для ввода даты начала аренды
    private final By orderDate = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //Поле для выбора срока аренды
    private final By rentTerms = By.xpath("//div[@class='Dropdown-placeholder']");
    //Выбор цвета самоката
    private final By bikeColor = By.xpath("//div[contains(text(),'Цвет самоката')]");
    //Поле комментария для курьера
    private final By courierComment = By.xpath("//input[@placeholder='Комментарий для курьера']");
    //Кнопка "Заказать"
    private final By orderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка подтверждения заказа
    private final By orderConfirmButton = By.xpath("//button[text()='Да']");
    //Сообщение об успешном заказе
    private final By messageOfOrderSucess = By.xpath("//div[contains(@class,'Order_ModalHeader')]");



    //Заполнение данных клиента
    public void fillPersonalData (String firstName, String secondName, String address, String metro, String phoneNumber) {
        driver.findElement(firsrNameField).sendKeys(firstName);
        driver.findElement(secondNameField).sendKeys(secondName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(metroStationField).click();
        driver.findElement(metroStationField).sendKeys(metro);
        driver.findElement(By.xpath("//input[contains(@placeholder,'метро')]/../following-sibling::div")).click();
        driver.findElement(PhoneField).sendKeys(phoneNumber);
        driver.findElement(nextButton).click();
    }

    //Заполнение дополнительной информации
    public void fillAdditionalData (String deliveryData, String rentalPeriod, String bikeColour, String comment) {
        driver.findElement(orderDate).sendKeys(deliveryData, Keys.ENTER);
        driver.findElement(rentTerms).click();
        driver.findElement(rentTerms).findElement(By.xpath("./../following-sibling::div//div[text()='" + rentalPeriod + "']")).click();
        driver.findElement(bikeColor).click();
        driver.findElement(bikeColor).findElement(By.xpath("./following-sibling::label[text()='" + bikeColour + "']")).click();
        driver.findElement(courierComment).sendKeys(comment);
        driver.findElement(orderButton).click();
        driver.findElement(orderConfirmButton).click();
    }

    //Ожидание загрузки страницы
    public void pageLoadExpectation () {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(firsrNameField)));
    }

    //Метод захвата сообщения об успешном заказе
    public String successOrder(){
        return driver.findElement(messageOfOrderSucess).getText().substring(0,14);
    }
}
