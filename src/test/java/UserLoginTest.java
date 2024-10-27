// 1 - biblitoecas / imports
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// 2 - Classe
public class UserLoginTest {
    // 2.1 - Atributos

    private WebDriver driver;

    // 2.2 - Funções e Métodos
    // Antes do Teste
    @BeforeEach
    public void executarAntesDeCadaTeste() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
        String url = driver.getCurrentUrl();
        assertEquals(url, "https://the-internet.herokuapp.com/login");
        String title = driver.getTitle();
        assertEquals(title, "The Internet");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
    }
    // Depois do Teste
    @AfterEach
    public void executarDepoisDeCadaTeste() {
        assertEquals("Secure Area", 
            driver.findElement(By.cssSelector("h2")).getText());
        assertEquals("Welcome to the Secure Area. When you are done click logout below.", 
            driver.findElement(By.cssSelector("h4")).getText());
        driver.quit();
    }
    // Teste
    // Teste 1 - Cenário: Login de usuário com sucesso
    @Test
    public void LoginDeUsuarioComSucesso() {
        

        {
            WebElement inputUserName = driver.findElement(By.id("username"));
            inputUserName.sendKeys("tomsmith");
        }

        {
            WebElement inputPassword = driver.findElement(By.id("password"));
            inputPassword.sendKeys("SuperSecretPassword!");
        }

        {
            WebElement loginButton = driver.findElement(By.xpath("//*[@id='login']/button"));
            loginButton.click();
        }





    }






}
