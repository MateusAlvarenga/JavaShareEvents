package IT;

import br.edu.iftm.tadeventos.DAO.ConexaoFactory;
import br.edu.iftm.tadeventos.DAO.DAOFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIT {

    private final ChromeDriver driver;
    private final String baseUrl;

    public SeleniumIT() throws Exception {
        this.driver = new ChromeDriver();
        this.baseUrl = "http://localhost:8084";
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @BeforeClass
    public static void setup() throws SQLException {
        DAOFactory factory = new DAOFactory();
        factory.abrirConexao();
        Connection conexao = ConexaoFactory.getConexao();
        
        String remocao = "DELETE FROM `tadeventos`.`user` WHERE username = 'userteste'";
        
        Statement stmt = (Statement) conexao.createStatement();
        stmt.executeUpdate(remocao);
    }

    @Test
    public void Cadastro() throws Exception {
        driver.get(baseUrl + "/TadEventosS/views/cadastro.jsp");
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("userteste");
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys("123456");
        driver.findElement(By.name("pass-confirm")).clear();
        driver.findElement(By.name("pass-confirm")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"home\"]/div[2]/form/div/div/button")).click();
        Boolean check = driver.findElements(By.cssSelector("div .ui .dropdown ")).size() > 0;
        Assert.assertEquals(Boolean.TRUE, check);
        driver.findElement(By.linkText("Logout")).click();
        
        driver.get(baseUrl + "/TadEventosS/views/login.jsp");
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("userteste");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    
        check = driver.findElements(By.cssSelector("div .ui .dropdown ")).size() > 0;
        Assert.assertEquals(Boolean.TRUE, check);
        
        driver.get(baseUrl + "/TadEventosS/eventos/publicar");
        driver.findElement(By.id("titulo")).clear();
        driver.findElement(By.id("titulo")).sendKeys("teste");
        driver.findElement(By.id("descicao")).clear();
        driver.findElement(By.id("descicao")).sendKeys("teste");
        driver.findElement(By.name("preco_entrada")).clear();
        driver.findElement(By.name("preco_entrada")).sendKeys("100");
        driver.findElement(By.id("datainicio")).clear();
        driver.findElement(By.id("datainicio")).sendKeys("2016/11/15 0:0:0");
        driver.findElement(By.id("datafim")).clear();
        driver.findElement(By.id("datafim")).sendKeys("2016/12/12 0:0:0");
        driver.findElement(By.id("geocomplete")).clear();
        driver.findElement(By.id("geocomplete")).sendKeys("Uberaba - State of Minas Gerais, Brazil");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        check = driver.findElements(By.cssSelector("div .ui .dropdown ")).size() > 0;
        Assert.assertEquals(Boolean.TRUE, check);
    }

}
