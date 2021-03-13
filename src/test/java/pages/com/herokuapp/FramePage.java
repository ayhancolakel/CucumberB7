package pages.com.herokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramePage {
    public FramePage(WebDriver driver){
        PageFactory.initElements(driver,this); // initiliazing our driver, where it is pointing.In order to initilazie the elements we need that
    }

    @FindBy(id="tinymce")
    public WebElement textBox;

    public void sendKey(String str){
        textBox.sendKeys(str);
    }
}
