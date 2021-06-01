package ibtikar.Fakhr;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestData.ExcelSheetReader;

public class JoinRequestsTest extends TestBase{
	 
	private int indexData = 2;
	private int colsOnSheet = 8;
	private String url = "https://fakhr-landingpage.ibtik.net/ar/";
	
	@DataProvider(name="DataFakhr")
	public Object[][] getTestData() throws IOException{
		return new ExcelSheetReader().getExcelData(indexData,colsOnSheet);
	}
	
	@BeforeTest
	public void openBrowser() {
		openMyBrowser(url);
	}
	
	@Test(dataProvider = "DataFakhr", priority = 1)
	public void testFilterMethod(String fromDate, String toDate, String name, String phone, String email,
			String assignTo, String region, String city){
		new JoinRequestsPage(driver).filterMethod(fromDate ,toDate, name, phone, email, assignTo, region, city);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		assertEquals(new JoinRequestsPage(driver).getJoinReqNum(), "327");
	}
	
//	@AfterTest
//	public void closeBrowser() {
//		driver.close();
//	}
}