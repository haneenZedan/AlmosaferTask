import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.*;
public class postAPI {

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
		RestAssured.baseURI ="https://api2.branch.io/v1/pageview";
		
		given()
		.contentType("application/x-www-form-urlencoded")
		.formParam("event", "pageview")
		.formParam("metadata", "{\"url\":\"https://www.almosafer.com/en\",\"user_agent\":\"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36\",\"language\":\"en-US\",\"screen_width\":1440,\"screen_height\":900,\"window_device_pixel_ratio\":2,\"og_data\":{\"$og_title\":\" Almosafer: Flights, Hotels, Activities & Airlines Ticket Booking\",\"$og_description\":\"Saudi's #1 Travel Company, over 500,000 Hotel options worldwide. Book Flights, Airlines Ticket, Aparthotel, Resorts, Villas. Check out user reviews. 24/7 Customer Support. Book Now, Pay later option.\",\"$og_type\":\"Product\"},\"title\":\" Almosafer: Flights, Hotels, Activities & Airlines Ticket Booking\",\"description\":\"Saudi's #1 Travel Company, over 500,000 Hotel options worldwide. Book Flights, Airlines Ticket, Aparthotel, Resorts, Villas. Check out user reviews. 24/7 Customer Support. Book Now, Pay later option.\",\"canonical_url\":\"https://www.almosafer.com/en\"}")
		.formParam("initial_referrer", "https://www.almosafer.com/en/hotels/Jordan/08-09-2023/09-09-2023/2_adult?placeId=ChIJmd5kZkdvABURmU4mUQdbKI0")
		.formParam("is_iframe", "false")
		.formParam("user_language", "en")
		.formParam("open_app", "false")
		.formParam("has_app_websdk", "false")
		.formParam("feature", "journeys")
		.formParam("callback_string", "branch_view_callback__1")
		.formParam("data", "{\"$canonical_url\":\"https://www.almosafer.com/en\",\"$og_title\":\" Almosafer: Flights, Hotels, Activities & Airlines Ticket Booking\",\"$og_description\":\"Saudi's #1 Travel Company, over 500,000 Hotel options worldwide. Book Flights, Airlines Ticket, Aparthotel, Resorts, Villas. Check out user reviews. 24/7 Customer Support. Book Now, Pay later option.\",\"$og_image_url\":null,\"$og_video\":null,\"$og_type\":\"Product\"}")
		.formParam("source", "web-sdk")
		.formParam("branch_key", "key_live_dkJwfdptlrki21V6ZoG89pcirEmaqo1J")
		.formParam("session_id", "1223692492512637715")
		.formParam("identity_id", "1223692492512704834")
		.formParam("sdk", "web2.79.0")
		.formParam("browser_fingerprint_id", "1104488473789874744")
		.auth().oauth2("skdjfh73273$7268u2j89s")
		.log().all()
		.when().post()

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
