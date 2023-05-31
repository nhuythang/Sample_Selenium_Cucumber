package com.aduroplatform.pageobjects.connects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.nhuythang.base.CommonPage;

public class ConnectHomePage extends CommonPage {
    //COMMON TEST DATA

	//LIST OF ELEMENTS ON CC LOGIN PAGE---------------------------------------
	

	@FindBy(how = How.ID, using = "home-page")
	WebElement ConnectHomePage;
	@FindBy(how = How.CLASS_NAME, using = "home-my-activities")
    WebElement myActivity;
    @FindBy(how = How.CLASS_NAME, using = "my-paths-container")
    WebElement myPath;
	@FindBy(how = How.CLASS_NAME, using = "level-range")
	WebElement levelRange;
	@FindBy(how = How.CLASS_NAME, using = "view-more")
	WebElement viewDetailsLink;
	@FindBy(how= How.XPATH, using = "//div/span[text()='Me']")
	WebElement menuMe;
	@FindBy(how = How.ID, using = "well-metrics")
	WebElement wellMetricsLink;
    @FindBy(how = How.ID, using = "human-performance")
    WebElement humanPerformanceLink;
    @FindBy(how= How.XPATH, using = "//div/span[text()='Discover']")
	WebElement menuDiscover;
    @FindBy(how= How.XPATH, using = "//input[@placeholder='Search']")
	WebElement inputSearch;
    @FindBy(how= How.XPATH, using = "//div[@class='path-item']//div[@class='path-title']")
	WebElement titlePathName;
	
	// CONSTRUCTOR
	public ConnectHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	// LIST OF PAGE ACTIONS---------------------------------------------------
	
	public void clickMeMenu() {
		try {
			waitForElementClickable(menuMe);
			click(menuMe);
		} catch (Exception e) {
			System.out.println("Exception thrown:" + e.toString());
			e.printStackTrace();
		}
	}
	
	public void clickDiscoverMenu() {
		try {
			waitForElementClickable(menuDiscover);
			click(menuDiscover);
		} catch (Exception e) {
			System.out.println("Exception thrown:" + e.toString());
			e.printStackTrace();
		}
	}
	
	public void clickWellMetricsLink() {
		try {
			waitForElementClickable(wellMetricsLink);
			click(wellMetricsLink);
		} catch (Exception e) {
			System.out.println("Exception thrown:" + e.toString());
			e.printStackTrace();
		}
	}
	
	public void humanPerformanceLink() {
        try {
            waitFor(humanPerformanceLink);
            click(humanPerformanceLink);
        } catch (Exception e) {
            System.out.println("Exception thrown:" + e.toString());
            e.printStackTrace();
        }
    }

	public void inputSearchKeyword(String value) {
		try {
			waitFor(inputSearch);
			sendKeys(inputSearch, value);
			sendKeys(inputSearch, Keys.RETURN);
		} catch (Exception e) {
			System.out.println("Exception thrown:" + e.toString());
			e.printStackTrace();
		}
	}

	public void click1stPathName() {
		try {
			waitForElementClickable(titlePathName);
			click(titlePathName);
		} catch (Exception e) {
			System.out.println("Exception thrown:" + e.toString());
			e.printStackTrace();
		}
	}
	// LIST OF PAGE VALIDATION------------------------------------------------
	// Verify login fail base on the error scenario
	public boolean isLoginSuccess() {
		return isDisplay(ConnectHomePage);
	}

	public boolean isLevelDisplay() {
		return isDisplay(levelRange);
	}

    public boolean isMyActivityDisplay() {
        return isDisplay(myActivity);
    }

    public boolean isMyPathDisplay() {
        return isDisplay(myPath);
    }

	public boolean verifyViewDetailsDisplay(String linkText) {
		if(viewDetailsLink.getText().equalsIgnoreCase(linkText)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyPathNameDisplay(String name) {
		waitForElement(titlePathName, 20);
		if(titlePathName.getText().equalsIgnoreCase(name)) {
			return true;
		} else {
			return false;
		}
	}

}
