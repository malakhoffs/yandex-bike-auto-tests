import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;



public class WebdriverSetup {

   WebDriver driver;

   //Выбор драйвра и URL входа
    @Before
    public void driverToUse() {
        driver = new EdgeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void shutDown() {
            driver.quit();
    }
}
