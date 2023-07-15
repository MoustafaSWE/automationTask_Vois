package testCases;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.P01_Homepage;
import pages.Scrollable;
import util.JSONdata;

import java.io.IOException;
import java.text.ParseException;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static util.driver.DriverHolder.getDriver;

@Epic("Google Search")
@Feature("Keyword result")
public class T01_AutomationTask extends BaseTest {
    private P01_Homepage homepage;
    private Scrollable scrollable;


    @Test
    @Severity(BLOCKER)
    @Description("""
                Test Scenario:
                        1)                     Open https://www.google.com
                        
                        2)                     Type and search for “Vodafone”
                        
                        3)                     Scroll down and go to the next page
                        
                        4)                     Count the number of results displayed on the second page (ignore any maps, videos, or images. Just count the normal search results, they are usually around 10 displayed.)
                        
                        5)                     Scroll down and go to the next page
                        
                        6)                     Validate if the number of results on page 2 is equal to page 3 or not
                        
                        7)                     Close the browser window
            """)
    @Step
    @Owner("Moustafa Ismail")
    public void ValidateTheNumberOfResultsOfPages() throws IOException, org.json.simple.parser.ParseException {

         // Step 2: Type and search for “Vodafone”
        homepage.searchBox().sendKeys(JSONdata.getTestData("searchKeyword"));
        homepage.searchBox().submit();

        // Step 3: Scroll down and go to the next page
        scrollable.scrollDown();
        homepage.nextPageButton().click();

        // Step 4: Count the number of results displayed on the second page
        int resultsCount = homepage.countSearchResults();
        System.out.println("Results on page 2: " + resultsCount);

        // Step 5: Scroll down and go to the next page
        scrollable.scrollDown();
        homepage.nextPageButton().click();

        // Step 6: Validate if the number of results on page 2 is equal to page 3 or not
        int resultsCountPage3 = homepage.countSearchResults();
        System.out.println("Results on page 3: " + resultsCountPage3);
        Assert.assertEquals(resultsCount, resultsCountPage3, "Number of results on page 2 is not equal to page 3");

    }

    @BeforeMethod
    public void setUp (){
        homepage = new P01_Homepage(getDriver());
        scrollable = new Scrollable(getDriver());
    }

}
