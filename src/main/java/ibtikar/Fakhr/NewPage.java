package ibtikar.Fakhr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewPage extends PageBase{

	public NewPage(WebDriver driver) {
		super(driver);
	}
	
	//home login button
//	@FindBy(xpath = "//a[@href='/ar/login']")
//	WebElement homeLoginBtn;
		
	//disability type field
	@FindBy(id = "mui-component-select-disabilityId")
	WebElement disTypeField;
	
	//disability type 1
	@FindBy(xpath = "//*[@id='menu-disabilityId']/div[3]/ul/li[1]")
	WebElement disType;
		
	//current work field
	@FindBy(id = "mui-component-select-currentWorkId")
	WebElement currWorkField;
	
	//current work 1
	@FindBy(xpath = "//*[@id='menu-currentWorkId']/div[3]/ul/li[1]")
	WebElement currWork;
	
	//status field
	@FindBy(id = "mui-component-select-statusId")
	WebElement statusField;
	
	//status 1
	@FindBy(xpath="//*[@id='menu-statusId']/div[3]/ul/li[1]")
	WebElement status;
		
	//solidery sector field
	@FindBy(id = "mui-component-select-soliderySectorId")
	WebElement soldSecField;
	
	//solidery sector 1
	@FindBy(xpath = "//*[@id='menu-soliderySectorId']/div[3]/ul/li[1]")
	WebElement soldSec;
	
	//review status field
	@FindBy(id = "mui-component-select-review_status_id")
	WebElement revStatusField;
	
	//review status 1
	@FindBy(id = "//*[@id='menu-review_status_id']/div[3]/ul/li[1]")
	WebElement revStatus;
	
	
	//from date field
	@FindBy(xpath = "*//form/div[6]/div/div/input")
	WebElement fromDateField;
	
	//to date field
	@FindBy(xpath = "*//form/div[7]/div/div/input")
	WebElement toDateField;
	
	//name field
	@FindBy(name = "name")
	WebElement nameField;
	
	//phone number field
	@FindBy(name = "phone_number")
	WebElement phoneField;
		
	//email field
	@FindBy(name = "email")
	WebElement emailField;
	
	//assign to whom field
	@FindBy(xpath = "*//form/div[11]/div[1]/div/div/div/div/div/div/input")
	WebElement assignToField;
	
	//region field
	@FindBy(xpath = "*//form/div[11]/div[2]/div/div/div/div/div/div/input")
	WebElement regionField;
		
	//city field
	@FindBy(xpath = "*//form/div[11]/div[3]/div/div/div/div/div/div/input")
	WebElement cityField;
	
	//search button
	@FindBy(xpath = "*//form/div[12]/button[1]")
	WebElement searchBtn;
	
	//clear button
	@FindBy(xpath = "*//form/div[12]/button[2]")
	WebElement clearBtn;
	
	//export button
	@FindBy(xpath = "*//span/button")
	WebElement exportBtn;
	
	//join requests number field
	@FindBy(xpath = "*//table/tfoot/tr/td/div/span/text()[2]")
	WebElement joinReqsNumField;
	
	public void filterMethod(String fromDate, String toDate,String name, String phone, String email,
			String assignTo, String region, String city) {
		
		new LoginPage(driver).loginMethod("admin@fakhr.com", "P@$$w0rd");
		disTypeField.click();
		currWorkField.click();
		statusField.click();
		soldSecField.click();
		revStatusField.click();
		fromDateField.click();
		toDateField.click();
		nameField.sendKeys(name);
		phoneField.sendKeys(phone);
		emailField.sendKeys(email);
		assignToField.sendKeys(assignTo);
		regionField.sendKeys(region);
		cityField.sendKeys(city);
		searchBtn.click();
	}
	
	public String getJoinReqNum() {
		
		return joinReqsNumField.getText().toString();
	}
	
	public void exportFileMethod() {
		exportBtn.click();
	}
	
	public void clearFilterMethod() {
		clearBtn.click();
	}
	
	
}
