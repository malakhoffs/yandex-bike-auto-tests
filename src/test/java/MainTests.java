import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

@RunWith(Parameterized.class)
public class MainTests{

    WebDriver driver = new EdgeDriver();

    MainPage functions = new MainPage(driver);

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String deliveryDate;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    public MainTests(String name, String surname, String address, String metro, String phone, String deliveryDate,
                     String rentalPeriod, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.deliveryDate = deliveryDate;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;

    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Иван", "Иванов", "Ленина 24", "Саларьево", "89567662314", "12.05.2026", "сутки", "серая безысходность", "Привезти доп. аккумулятор"},
                {"Петр", "Петров", "просп. Мира 66", "Комсомольская", "89202141718", "25.10.2025", "трое суток", "чёрный жемчуг", "Заказ примет другой человек"}
        };
    }

    //Тест на кликабельность и тектс в футтерах
    @Test
    public void faqTest (){
        driver.get("https://qa-scooter.praktikum-services.ru/");
        functions.scrollToBottom();
        Assert.assertTrue(functions.faqPaymentInfoClick());
        Assert.assertTrue(functions.faqMultipleOrderClick());
        Assert.assertTrue(functions.faqTermsClick());
        Assert.assertTrue(functions.faqTodayOrderClick());
        Assert.assertTrue(functions.faqExtendClick());
        Assert.assertTrue(functions.faqChargerClick());
        functions.scrollToBottom();
        Assert.assertTrue(functions.faqCancelClick());
        Assert.assertTrue(functions.faqFarAwayClick());
        functions.secondOrderButtonClick();
        driver.quit();
    }

    //Тесты на заказ самоката с 2-х разных кнопок
    @Test
    public void makeHeaderOrder()  {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage functions = new MainPage(driver);
        OrderPage personel = new OrderPage(driver);
        functions.firstOrderButtonClick();
        personel.fillPersonalData(name, surname, address, metro, phone);
        personel.fillAdditionalData(deliveryDate, rentalPeriod, color, comment);
        Assert.assertEquals("Заказ оформлен", personel.successOrder());
        driver.quit();
    }
    @Test
    public void makeBodyOrder() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage functions = new MainPage(driver);
        OrderPage personel = new OrderPage(driver);
        functions.firstOrderButtonClick();
        personel.pageLoadExpectation();
        personel.fillPersonalData(name, surname, address, metro, phone);
        personel.fillAdditionalData(deliveryDate, rentalPeriod, color, comment);
        Assert.assertEquals("Заказ оформлен", personel.successOrder());
        driver.quit();
    }
}



