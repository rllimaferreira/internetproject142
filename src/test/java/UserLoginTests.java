
// 1 - biblitoecas / imports
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

// 2 - Classe
public class UserLoginTests {
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
        driver.quit();
    }

    // Teste
    // Teste 1 - Cenário: Login de usuário com sucesso
    @Test
    @Order(1)
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
        assertEquals("Secure Area",
                driver.findElement(By.cssSelector("h2")).getText());
        assertEquals("Welcome to the Secure Area. When you are done click logout below.",
                driver.findElement(By.cssSelector("h4")).getText());
    }

    // Teste 2 - Cenário: Login de usuário com sucesso
    @Test
    @Order(2)
    public void LoginDeUsuarioComDadosInvalidos() {
        {
            WebElement inputUserName = driver.findElement(By.id("username"));
            inputUserName.sendKeys("tomsmithh");
        }
        {
            WebElement inputPassword = driver.findElement(By.id("password"));
            inputPassword.sendKeys("SuperSecretPassword!!");
        }
        {
            WebElement loginButton = driver.findElement(By.xpath("//*[@id='login']/button"));
            loginButton.click();
        }
        assertEquals("Your username is invalid!", driver.findElement(By.id("flash")).getText().split("\n")[0]);
    }

    // Teste 3 - Cenário: Login de usuário com password inválido
    @Test
    @Order(3)
    public void LoginDeUsuarioComPasswordInvalido() {
        {
            WebElement inputUserName = driver.findElement(By.id("username"));
            inputUserName.sendKeys("tomsmith");
        }
        {
            WebElement inputPassword = driver.findElement(By.id("password"));
            inputPassword.sendKeys("SuperSecretPassword!!");
        }
        {
            WebElement loginButton = driver.findElement(By.xpath("//*[@id='login']/button"));
            loginButton.click();
        }
        assertEquals("Your password is invalid!", driver.findElement(By.id("flash")).getText().split("\n")[0]);
    }

    // Teste 4 - Cenário: Login de usuário com username inválido
    @Test
    @Order(4)
    public void LoginDeUsuarioComUsernameInvalido() {
        {
            WebElement inputUserName = driver.findElement(By.id("username"));
            inputUserName.sendKeys("tomsmithh");
        }
        {
            WebElement inputPassword = driver.findElement(By.id("password"));
            inputPassword.sendKeys("SuperSecretPassword!");
        }
        {
            WebElement loginButton = driver.findElement(By.xpath("//*[@id='login']/button"));
            loginButton.click();
        }
        assertEquals("Your username is invalid!", driver.findElement(By.id("flash")).getText().split("\n")[0]);
    }

    // Teste 5 - Cenário: Login de usuário com campos em branco
    @Test
    @Order(5)
    public void LoginDeUsuarioComCamposEmBranco() {
        {
            WebElement loginButton = driver.findElement(By.xpath("//*[@id='login']/button"));
            loginButton.click();
        }
        assertEquals("Your username is invalid!", driver.findElement(By.id("flash")).getText().split("\n")[0]);
    }

    // Teste 6 - Cenário: Login de usuário com username em branco
    @Test
    @Order(6)
    public void LoginDeUsuarioComUsernameEmBranco() {
        {
            WebElement inputPassword = driver.findElement(By.id("password"));
            inputPassword.sendKeys("SuperSecretPassword!");
        }
        {
            WebElement loginButton = driver.findElement(By.xpath("//*[@id='login']/button"));
            loginButton.click();
        }
        assertEquals("Your username is invalid!", driver.findElement(By.id("flash")).getText().split("\n")[0]);
    }

    // Teste 7 - Cenário: Login de usuário com username em branco e password
    // inválido
    @Test
    @Order(7)
    public void LoginDeUsuarioComUsernameEmBrancoPasswordInvalido() {
        {
            WebElement inputPassword = driver.findElement(By.id("password"));
            inputPassword.sendKeys("SuperSecretPassword!!");
        }
        {
            WebElement loginButton = driver.findElement(By.xpath("//*[@id='login']/button"));
            loginButton.click();
        }
        assertEquals("Your username is invalid!", driver.findElement(By.id("flash")).getText().split("\n")[0]);
    }

    // Teste 8 - Cenário: Login de usuário com apenas username válido e password em
    // branco
    @Test
    @Order(8)
    public void LoginDeUsuarioComPasswordEmBranco() {
        {
            WebElement inputUserName = driver.findElement(By.id("username"));
            inputUserName.sendKeys("tomsmith");
        }
        {
            WebElement loginButton = driver.findElement(By.xpath("//*[@id='login']/button"));
            loginButton.click();
        }
        assertEquals("Your password is invalid!", driver.findElement(By.id("flash")).getText().split("\n")[0]);
    }

    // Teste 9 - Cenário: Login de usuário com username inválido e password em
    // branco
    @Test
    @Order(9)
    public void LoginDeUsuarioComUsernameInvalidoPasswordEmBranco() {
        {
            WebElement inputUserName = driver.findElement(By.id("username"));
            inputUserName.sendKeys("tomsmithh");
        }
        {
            WebElement loginButton = driver.findElement(By.xpath("//*[@id='login']/button"));
            loginButton.click();
        }
        assertEquals("Your username is invalid!", driver.findElement(By.id("flash")).getText().split("\n")[0]);
    }
}
