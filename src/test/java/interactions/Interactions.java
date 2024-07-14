package interactions;

import DAO.Queries.Query;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Alert;
import pages.Page;
import org.openqa.selenium.support.PageFactory;
import java.sql.SQLException;

import static tests.Hooks.driver;
import static utils.BuildTools.robots;

public class Interactions extends Page {

    public Interactions() {

        PageFactory.initElements(new AppiumFieldDecorator (driver), this);
    }

    public void setUserInteraction(String user, String failenamess, String pathss) throws InterruptedException {
        robots.setText(usernameLabel, user);
        robots.takeScreenShot (failenamess, pathss );
    }

    
    private void printVisibleElements() {
        List<WebElement> allElements = driver.findElements(By.xpath("//*"));
        for (WebElement element : allElements) {
            if (element.isDisplayed()) {
                System.out.println("Elemento visível: " + element.getTagName());
                // Você pode adicionar mais informações do elemento aqui, se necessário
            }
        }
    }

    
    public void setPasswordInteraction(String pass, String failenamess, String pathss) throws InterruptedException {
        robots.setText(passwordLabel, pass);
        robots.takeScreenShot (failenamess, pathss );
        printVisibleElements();
    }

    public void btLoginClick(String failenamess, String pathss)  throws InterruptedException{
        robots.clickElement(loginButton);
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            e.printStackTrace();
        }
        robots.takeScreenShot (failenamess, pathss );
    }


    public void consultarPedidos() throws SQLException, ClassNotFoundException {
        Query.queryMethod();
    }

}
