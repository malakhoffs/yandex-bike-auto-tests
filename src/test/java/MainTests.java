import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class MainTests extends WebdriverSetup {

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

    //Тесты на заказ самоката с 2-х разных кнопок
    @Test
    public void makeHeaderOrder()  {
        MainPage functions = new MainPage(driver);
        OrderPage personel = new OrderPage(driver);
        functions.headerOrderButtonClick();
        personel.fillPersonalData(name, surname, address, metro, phone);
        personel.fillAdditionalData(deliveryDate, rentalPeriod, color, comment);
        Assert.assertEquals("Заказ оформлен", personel.successOrder());
    }
    @Test
    public void makeBodyOrder() {
        MainPage functions = new MainPage(driver);
        OrderPage personel = new OrderPage(driver);
        functions.bodyOrderButtonClick();
        personel.pageLoadExpectation();
        personel.fillPersonalData(name, surname, address, metro, phone);
        personel.fillAdditionalData(deliveryDate, rentalPeriod, color, comment);
        Assert.assertEquals("Заказ оформлен", personel.successOrder());
    }
}
