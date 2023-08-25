import static io.restassured.RestAssured.given;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.RestAssured;

public class getAPI {
	 private ExtentReports extent;
	    private ExtentTest test;

	    @BeforeSuite
	    
	    public void setUpExtentReports() {
	        String reportPath = "test-output/api-test-report.html";

	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
	        htmlReporter.config().setDocumentTitle("API Test Automation Report");
	        htmlReporter.config().setReportName("API Test Suite");
	        htmlReporter.config().setTheme(Theme.STANDARD);

	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	    }

	    @BeforeMethod
	    public void setUpTest() {
	        test = extent.createTest("API Test", "Testing API endpoint");
	    }
	@Test
	public void ListAPI() {
		RestAssured.baseURI ="https://www.almosafer.com/api/system/currency/list";
		
		given()
		.contentType("application/json")
		.auth().oauth2("skdjfh73273$7268u2j89s")
		.log().all()
		.when().get()

		.then().statusCode(200).log().all();

	}
	@AfterMethod
    public void tearDownTest() {
        extent.flush();
    }

    @AfterSuite
    public void tearDownExtentReports() {
        extent.flush();
    }
    
	

}
