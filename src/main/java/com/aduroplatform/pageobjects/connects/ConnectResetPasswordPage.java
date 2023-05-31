package com.aduroplatform.pageobjects.connects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.nhuythang.base.CommonPage;

public class ConnectResetPasswordPage extends CommonPage{

    //LIST OF ELEMENTS ON CC LOGIN PAGE---------------------------------------
    @FindBy(how = How.ID, using = "input-email-forgot-pw")
    WebElement txtResetPassEmail;
    @FindBy(how = How.ID, using = "btn-send-code")
    WebElement btnSendCode;
    @FindBy(how = How.ID, using = "form-input-enter-code")
    WebElement txtEnterCode;
    @FindBy(how = How.ID, using = "btn-continue")
    WebElement btnContinue;
    
    public ConnectResetPasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public void enterEmailAndSendCode(String email) {
        try {
            sendKeys(txtResetPassEmail, email);
            waitFor(btnSendCode);
            click(btnSendCode);
        } catch (Exception e) {
            System.out.println("Exception thrown:" + e.toString());
        }
    }
    
    public void enterVerificationCodeAndContinue(String code) {
        try {
            sendKeys(txtEnterCode, code);
            waitFor(btnContinue);
            click(btnContinue);
        } catch (Exception e) {
            System.out.println("Exception thrown:" + e.toString());
        }
    }

    // LIST OF PAGE VALIDATION------------------------------------------------
    public boolean isResetPasswordEmailDisplay() {
        return isDisplay(txtResetPassEmail);
    }
    
    public boolean isSendCodeBtnDisplay() {
        return isDisplay(btnSendCode);
    }

}

