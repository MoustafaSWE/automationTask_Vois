package pages;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.util.List;

public class P01_Homepage extends BasePage{

    private final By searchLocator = By.name("q");
    private final By nextPageButtonLocator = By.xpath("//a[@id='pnnext']");
    private final By resultCountLocator = By.className("yuRUbf");

    public P01_Homepage(WebDriver driver) {
        super(driver);
    }

    public WebElement searchBox (){
        return driver.findElement(searchLocator);
    }

    public WebElement nextPageButton (){
        return driver.findElement(nextPageButtonLocator);
    }

    public List<WebElement> resultCount(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultCountLocator));
        return driver.findElements(resultCountLocator);
    }

    public int countSearchResults() {
        int resultsCount = resultCount().size();
        return resultsCount;
    }
}
