package com.aduroplatform.pageobjects.connects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.nhuythang.base.CommonPage;

public class ConnectHumanPerformancePage extends CommonPage {
    //COMMON TEST DATA

    //LIST OF ELEMENTS ON CC LOGIN PAGE---------------------------------------
    
    @FindBy(how = How.CLASS_NAME, using = "my-data-header-title")
    WebElement txtHumanPerformance;
    
    @FindBy(how = How.CLASS_NAME, using = "flourishing-index-title")
    WebElement txtFlourishingIndex;
    
    @FindBy(how = How.CLASS_NAME, using = "hpa-title")
    WebElement txtHumanPerformaceAssessment;

    @FindBy(how = How.CLASS_NAME, using = "f-description-total-score")
    WebElement txtFlourishingIndexScore;
    
    @FindBy(how = How.CLASS_NAME, using = "flourishing-index-card-item")
    List<WebElement> lstFlourishingIndexCards;

    @FindBy(how = How.CLASS_NAME, using = "f-card-title")
    List<WebElement> lstFlourishingIndexCardsValue;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Top Opportunities')]/following-sibling::div/div")
    List<WebElement> lstTopOpportunityCards;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Top Strengths')]/following-sibling::div/div")
    List<WebElement> lstTopStrengthCards;

    @FindBy(how = How.XPATH, using = "//h3[contains(text(),'All Scores')]/following::div[starts-with(@class,'survey-wba-score-item-wrapper')]")
    List<WebElement> lstAllScoreCards;
    
    // CONSTRUCTOR
    public ConnectHumanPerformancePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    // LIST OF PAGE ACTIONS---------------------------------------------------


   
    // LIST OF PAGE VALIDATION------------------------------------------------    
    
    public boolean isHumanPerformanceTitleDisplay(String text) {
        waitForPageCompleteLoading();
        waitFor(txtHumanPerformance);
        if(txtHumanPerformance.getText().equalsIgnoreCase(text)) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isFlourishingIndexTitleDisplay(String text) {
        if(txtFlourishingIndex.getText().equalsIgnoreCase(text)) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isHumanPerformaceAssessmentTitleDisplay(String text) {
        if(txtHumanPerformaceAssessment.getText().equalsIgnoreCase(text)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyNumberFlourishingIndexCards(int number) {
        if(lstFlourishingIndexCards.size()== number) {
            return true;
        } else {
            return false;
        }
    }

   public boolean verifyFlourishingIndexScoreDisplay(String score) {
       if(txtFlourishingIndexScore.getText().equalsIgnoreCase(score)) {
           return true;
       } else {
           return false;
       }
   }

   public boolean verifyFlourishingIndexCardValue(int index, String title) {
       waitForPageCompleteLoading();
       int actualIndex = index-1;
       if(lstFlourishingIndexCardsValue.get(actualIndex).getText().equalsIgnoreCase(title)) {
           return true;
       } else {
           return false;
       }
   }

   public boolean verifyTopOpportunityCards(int number) {
       if(lstTopOpportunityCards.size()== number) {
           return true;
       } else {
           return false;
       }
   }

   public boolean verifyTopStrengthCards(int number) {
       if(lstTopStrengthCards.size()== number) {
           return true;
       } else {
           return false;
       }
   }

   public boolean verifyAllScoreCards(int number) {
       if(lstAllScoreCards.size()== number) {
           return true;
       } else {
           return false;
       }
   }
}
