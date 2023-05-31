package com.aduroplatform.pageobjects.connects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.nhuythang.base.CommonPage;

public class ConnectScheduleServicesPage extends CommonPage {
    // CONSTRUCTOR
    public ConnectScheduleServicesPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //LIST OF ELEMENTS ON PAGE---------------------------------------------------
    @FindBy(how= How.XPATH, using = "//h1[contains(text(),'My Appointments')]")
    WebElement txtMyAppointments;

    @FindBy(how= How.XPATH, using = "//div[@class='group-button']//div[@class='content'][normalize-space()='Cancel']")
    WebElement btnCancelCurrentEvent;
    @FindBy(how= How.XPATH, using = "//div[@class='group-button']//div[@class='content'][normalize-space()='Reschedule']")
    WebElement btnReschedule;
    @FindBy(how= How.XPATH, using = "//button[contains(text(), 'YES, CANCEL APPOINTMENT')]")
    WebElement btnConfirmCancel;
    @FindBy(how= How.XPATH, using = "//button[contains(text(), 'SELECT LOCATION')]")
    WebElement btnSelectLocation;
    @FindBy(how= How.XPATH, using = "//h1[contains(text(), 'Select Services')]")
    WebElement labelSelectServices;
    @FindBy(how= How.XPATH, using = "//div[contains(@class, 'list-item')]/a[1]")
    WebElement firstLocationLink;
    @FindBy(how= How.XPATH, using = "//button[contains(@class, 'btn-select scheduler-button-custom-color')][1]")
    WebElement btnSelect1stEvent;
    @FindBy(how= How.XPATH, using = "//div[contains(@aria-label, 'My self')]//div[contains(text(), '9:00 AM')]")
    WebElement btn9AMTime;
    @FindBy(how= How.XPATH, using = "//button[contains(text(), 'Done')]")
    WebElement btnDoneAppointmentTime;
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'term-condition-container')]//preceding::label[@class='custom-control-label'][1]")
    WebElement chkboxConfirmAppointment;
    @FindBy(how= How.XPATH, using = "//button[contains(@aria-label,'Confirm Appointment')]")
    WebElement btnConfirmAppointment;
    @FindBy(how= How.XPATH, using = "//h2[@class='h5-text your-appointment']")
    WebElement txtAppointmentConfirmed;
    @FindBy(how= How.XPATH, using = "//h1[@class='step-name h1-text']")
    WebElement txtThankYou;
    @FindBy(how= How.XPATH, using = "//button[@class='ap-btn scheduler-button-custom-color btn-schedule']")
    WebElement btnSchedule;
    @FindBy(how= How.XPATH, using = "(//div[contains(@class, 'custom-control custom-radio custom-control-inline')])[1]")
    WebElement chkboxFluShotsService;
    @FindBy(how= How.XPATH, using = "(//div[contains(@class, 'custom-control custom-radio custom-control-inline')])[2]")
    WebElement chkboxCovidVaccineService;
    @FindBy(how= How.XPATH, using = "(//div[contains(@class, 'custom-control custom-radio custom-control-inline')])[3]")
    WebElement chkboxCovidFluShotsService;
    @FindBy(how= How.XPATH, using = "//div[@class='text scheduler-text-custom-color'][contains(text(),'Biometric screening')]")
    WebElement chckboxBiometricScreeningChecked;
    @FindBy(how= How.XPATH, using = "//div[@class='text scheduler-text-custom-color'][contains(text(),'Flu shot')]")
    WebElement chckboxFluShotsChecked;
    @FindBy(how= How.XPATH, using = "//div[@class='text scheduler-text-custom-color'][contains(text(),'Covid-19 Vaccine')]")
    WebElement chckboxCovidVaccineChecked;
    @FindBy(how= How.XPATH, using = "//div[@class='text scheduler-text-custom-color'][contains(text(),'Covid-19 and Flu Shots')]")
    WebElement chckboxCovidFluShotsChecked;

    // LIST OF PAGE ACTIONS---------------------------------------------------
    public void clickCancelCurrentEventButton() {
        try {
            click(btnCancelCurrentEvent);
        } catch (Exception e) {
            System.out.println("Exception thrown:" + e.toString());
        }
    }

    public void clickConfirmCancelButton() {
        try {
            waitFor(btnConfirmCancel);
            click(btnConfirmCancel);
        } catch (Exception e) {
            System.out.println("Exception thrown:" + e.toString());
        }
    }

    public void clickSelectLocationButton() {
        try {
            waitFor(btnSelectLocation);
            click(btnSelectLocation);
        } catch (Exception e) {
            System.out.println("Exception thrown:" + e.toString());
        }
    }

    public void clickFirstLocationLink() {
        try {
            waitFor(firstLocationLink);
            click(firstLocationLink);
        } catch (Exception e) {
            System.out.println("Exception thrown:" + e.toString());
        }
    }

    public void clickSelect1stEventButton() {
        try {
            waitFor(btnSelect1stEvent);
            click(btnSelect1stEvent);
        } catch (Exception e) {
            System.out.println("Exception thrown:" + e.toString());
        }
    }

    public void click900AMTimeButton() {
        try {
            waitFor(btn9AMTime);
            click(btn9AMTime);
        } catch (Exception e) {
            System.out.println("Exception thrown:" + e.toString());
        }
    }

    public void clickDoneAppointmentButton() {
        try {
            waitFor(btnDoneAppointmentTime);
            click(btnDoneAppointmentTime);
        } catch (Exception e) {
            System.out.println("Exception thrown:" + e.toString());
        }
    }

    public void checkConfirmAppointmentCheckBox() {
        try {
            waitFor(chkboxConfirmAppointment);
            click(chkboxConfirmAppointment);
        } catch (Exception e) {
            System.out.println("Exception thrown:" + e.toString());
        }
    }

    public void clickConfirmAppointmentButton() {
        try {
            waitFor(btnConfirmAppointment);
            click(btnConfirmAppointment);
        } catch (Exception e) {
            System.out.println("Exception thrown:" + e.toString());
        }
    }
    
    public void clickScheduleButton() {
        try {
            waitFor(btnSchedule);
            click(btnSchedule);
        } catch (Exception e) {
            System.out.println("Exception thrown:" + e.toString());
        }
    }
    
    public void selectFluShotsServiceCheckBox() {
        try {
            waitFor(chkboxFluShotsService);
            click(chkboxFluShotsService);
        } catch (Exception e) {
            System.out.println("Exception thrown:" + e.toString());
        }
    }
    
    public void selectCovidVaccineServiceCheckBox() {
        try {
            waitFor(chkboxCovidVaccineService);
            click(chkboxCovidVaccineService);
        } catch (Exception e) {
            System.out.println("Exception thrown:" + e.toString());
        }
    }
    
    public void selectCovidFluShotServiceCheckBox() {
        try {
            waitFor(chkboxCovidFluShotsService);
            click(chkboxCovidFluShotsService);
        } catch (Exception e) {
            System.out.println("Exception thrown:" + e.toString());
        }
    }

    // LIST OF PAGE VALIDATION------------------------------------------------
    public boolean isScheduleServicesDisplaysSuccessfully() {
        return isDisplay(txtMyAppointments);
    }

    public boolean isCancelButtonDisplays(){
        return isDisplay(btnCancelCurrentEvent);
    }

    public boolean isRescheduleButtonDisplays(){
        return isDisplay(btnReschedule);
    }

    public boolean isThankYouTextDisplay() {
        return isDisplay(txtThankYou);
    }

    public boolean isAppointmentConfirmedTextDisplay() {
        return isDisplay(txtAppointmentConfirmed);
    }

    public boolean isSelectServicesTextDisplay() {
        return isDisplay(labelSelectServices);
    }

    public boolean isScheduleButtonDisplay(){
        return isDisplay(btnSchedule);
    }
    
    public boolean isCheckboxBiometricScreeningChecked(){
        return isDisplay(chckboxBiometricScreeningChecked);
    }
    
    public boolean isCheckboxFluShotsChecked(){
        return isDisplay(chckboxFluShotsChecked);
    }
    
    public boolean isCheckboxCovidVaccineChecked(){
        return isDisplay(chckboxCovidVaccineChecked);
    }
    
    public boolean isCheckboxCovidFluShotsChecked(){
        return isDisplay(chckboxCovidFluShotsChecked);
    }
    
    public boolean isFirstLocationLinkDisplay(){
        return isDisplay(firstLocationLink);
    }
}
