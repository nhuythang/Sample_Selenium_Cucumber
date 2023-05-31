package com.nhuythang.stepsdefinition;

import com.aduroplatform.pageobjects.connects.ConnectCreateNewPasswordPage;
import com.aduroplatform.pageobjects.connects.ConnectHomePage;
import com.aduroplatform.pageobjects.connects.ConnectHumanPerformancePage;
import com.aduroplatform.pageobjects.connects.ConnectLoginPage;
import com.aduroplatform.pageobjects.connects.ConnectPathDetailPage;
import com.aduroplatform.pageobjects.connects.ConnectRegistrationPage;
import com.aduroplatform.pageobjects.connects.ConnectResetPasswordPage;
import com.aduroplatform.pageobjects.connects.ConnectScheduleServicesPage;
import com.aduroplatform.pageobjects.connects.ConnectWellMetricsPage;
import com.nhuythang.base.TestContext;
import com.nhuythang.exceptions.TestScenarioFailException;
import com.nhuythang.systemconfigurations.GlobalParameters;
import com.nhuythang.systemconfigurations.TestData;
import com.nhuythang.utils.CommonUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;

public class ConnectSteps {
	
	TestContext testContext;
	WebDriver driver;
	ConnectLoginPage connectLoginpage;
	ConnectHomePage connectHomePage;
	ConnectWellMetricsPage connectWellMetricsPage;
	ConnectScheduleServicesPage connectScheduleServicesPage;
	ConnectResetPasswordPage connectResetPasswordPage;
	ConnectCreateNewPasswordPage connectCreateNewPasswordPage;
	ConnectHumanPerformancePage connectHumanPerformancePage;
	ConnectRegistrationPage connectRegistrationPage;
	ConnectPathDetailPage connectPathDetailPage;
	
	static long currentTime = CommonUtils.getCurrentTimeStamp();
    static final String aduroId = CommonUtils.getRandomUUID();
	static final String newMemberEmail = "aduroqa+" + currentTime + "@gmail.com";
	static final String firstName = "FistName" + currentTime;
	static final String lastName = "LastName" + currentTime;
	static final String memberID = "AUTO_" + currentTime;
	static final String DOB = "01/01/1990";
	static final String phoneNumber = "+13202162320";
	static String verificationEmailLink;

	public ConnectSteps(TestContext context) {
		testContext = context;
		driver = testContext.getDriverManager().getDriver();
		connectLoginpage = testContext.getPageObjectManager().getConnectLoginPage();
		connectHomePage = testContext.getPageObjectManager().getConnectHomePage();
		connectWellMetricsPage = testContext.getPageObjectManager().getConnectWellMetricsPage();
		connectScheduleServicesPage =testContext.getPageObjectManager().getConnectScheduleServicesPage();
		connectResetPasswordPage = testContext.getPageObjectManager().getConnectResetPasswordPage();
		connectCreateNewPasswordPage = testContext.getPageObjectManager().getConnectCreateNewPasswordPage();
		connectHumanPerformancePage = testContext.getPageObjectManager().getConnectHumanPerformancePage();
		connectRegistrationPage = testContext.getPageObjectManager().getConnectRegistrationPage();
		connectPathDetailPage = testContext.getPageObjectManager().getConnectPathDetailPage();
	}
	
	@Given("User access to Connect url")
	public void user_access_to_connect_url() {
		try {
	    	driver.navigate().to(GlobalParameters.CONNECT_URL);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Given("User access to Connect forgot password url")
    public void user_access_to_connect_forgot_pw_url() {
        try {
            driver.navigate().to(GlobalParameters.CONNECT_FORGOT_PASSWORD_URL);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
	
	@Given("User access to Connect url have live event in new tab")
    public void user_access_to_connect_url_has_live_event() {
        try {
            connectLoginpage.openNewTab();
            driver.navigate().to(GlobalParameters.CONNECT_CLIENT_LIVE_EVENT_URL);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

	@Given("User access to Connect Client has Signup url")
    public void user_access_to_connect_client_with_signup_url() {
        try {
            driver.navigate().to(GlobalParameters.CONNECT_CLIENT_SIGNUP_URL);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

	@When("User login to Connect web with valid account")
	public void user_login_to_cc_with_valid_account() {
		connectLoginpage.login(TestData.CONNECT_USERNAME, TestData.CONNECT_PASSWORD);
	}

	@When("User login to Connect with account live event")
	public void user_login_to_cc_with_live_event_account() {
		connectLoginpage.login(TestData.CONNECT_LIVE_EVENT_USERNAME, TestData.CONNECT_PASSWORD);
	}
	
	@When("User login to Connect with account has Heart Beat survey in path")
	public void user_login_to_connect_with_heart_beat_survey_account() {
		connectLoginpage.login(TestData.CONNECT_LIVE_EVENT_USERNAME, TestData.CONNECT_PASSWORD);
	}

	@When("User enter email address then click 'Log in with Aduro'")
    public void user_enter_email_then_click_Login() {
        connectLoginpage.enterEmailAndNext(TestData.CONNECT_FORGOT_PASSWORD_ACCOUNT);
    }
	
	@When("User enter email address of not register member then click 'Log in with Aduro'")
    public void user_enter_email_not_register_member_then_click_Login() {
        connectLoginpage.enterEmailAndNext(TestData.CONNECT_NOT_REGISTERED_ACCOUNT);
    }

	@When("User login to Connect web with HPA account")
    public void user_login_to_cc_with_hpa_account() {
        connectLoginpage.login(TestData.CONNECT_HPA_ACCOUNT, TestData.CONNECT_PASSWORD);
    }

	@When("User login to Connect with account username {string} and password {string}")
	public void user_login_to_connect_with_account_username_and_password(String username, String password) {
		connectLoginpage.login(username, password);
	}

	@When("User click to SignUp link")
    public void user_click_to_signup_link() {
        connectLoginpage.clickSignUpLink();
    }

	@Then("User can see enter password page and {string} link displayed")
    public void user_can_see_enter_password_page(String linkText) {
        try {
            assertTrue(connectLoginpage.isEnterPasswordDisplay());
            assertTrue(connectLoginpage.verifyForgotPasswordDisplay(linkText));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Then("User can see the level number and level name")
	public void user_can_see_the_level_number_and_level_name() {
		try {
			assertTrue(connectHomePage.isLoginSuccess());
            assertTrue(connectHomePage.isLevelDisplay());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("User can see program in Home page")
    public void user_can_see_program_in_home_page() {
        try {
            assertTrue(connectHomePage.isLoginSuccess());
            assertTrue(connectHomePage.isMyPathDisplay());
            assertTrue(connectHomePage.isMyActivityDisplay());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Then("User can see {string} link")
	public void user_can_see_link(String linkText) {
		try {
			assertTrue(connectHomePage.verifyViewDetailsDisplay(linkText));
		} catch (Exception e) {
		    throw new TestScenarioFailException(e.getMessage());
		}
	}

	@Then("User click the link to see reset password page")
    public void user_click_forgot_password_link() {
	    try {
	        connectLoginpage.clickForgotPasswordLink();
            assertTrue(connectResetPasswordPage.isResetPasswordEmailDisplay());
            assertTrue(connectResetPasswordPage.isSendCodeBtnDisplay());
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

	@Then("User enter email then click 'Send Code'")
    public void user_enter_email_then_click_send_code() {
        try {
            connectResetPasswordPage.enterEmailAndSendCode(TestData.CONNECT_FORGOT_PASSWORD_ACCOUNT);
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

	@Then("User can see enter code page")
    public void user_can_see_enter_code_page() {
        try {
            assertTrue(connectResetPasswordPage.isResetPasswordEmailDisplay());
            assertTrue(connectResetPasswordPage.isSendCodeBtnDisplay());
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

	@Then("User enter their code into input code field and click 'Continue'")
    public void user_enter_code_and_continue() {
        try {
            String verificationCode = connectResetPasswordPage.getVerifyCode();
            connectResetPasswordPage.enterVerificationCodeAndContinue(verificationCode);
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

	@Then("User can see create {string} page")
    public void user_can_see_create_password_page(String text) {
        try {
            assertTrue(connectCreateNewPasswordPage.isLabelCreateNewPasswordDisplay(text));
            assertTrue(connectCreateNewPasswordPage.isInputNewPasswordDisplay());
            assertTrue(connectCreateNewPasswordPage.isInputVerifyPasswordDisplay());
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

	@When("User login to Connect with account having screening event")
    public void user_login_to_connect_with_account_have_screening_event() {
        connectLoginpage.login(TestData.CONNECT_SCREENING_USERNAME, TestData.CONNECT_SCREENING_PASSWORD);
    }
	
	@When("User click to Schedule a screening button")
	public void user_click_to_schedule_a_screening()
	{
		try {
			connectWellMetricsPage.clickScheduleAScreeningButton();
			connectWellMetricsPage.switchToNewOpenTab();
		} catch (Exception e){
		    throw new TestScenarioFailException(e.getMessage());
		}
	}

	@When("User check event Scheduler available")
	public void user_check_event_scheduler_available()
	{
		try {
			connectWellMetricsPage.clickScheduleAScreeningButton();
			connectScheduleServicesPage.switchToNewOpenTab();
			connectScheduleServicesPage.waitForPageCompleteLoading();
			if (connectScheduleServicesPage.isScheduleButtonDisplay()) {
                connectScheduleServicesPage.clickScheduleButton();
            };
			assertTrue(connectScheduleServicesPage.isSelectServicesTextDisplay());
		} catch (Exception e){
		    throw new TestScenarioFailException(e.getMessage());
		}
	}

	@When("User switch to latest open tab")
	public void user_switch_latest_open_tab()
	{
		try {
			connectWellMetricsPage.switchToNewOpenTab();
		} catch (Exception e){
		    throw new TestScenarioFailException(e.getMessage());
		}
	}

	@When("User switch to first tab")
	public void user_switch_first_open_tab()
	{
		try {
			connectWellMetricsPage.switchBackToFirstTab();
		} catch (Exception e){
		    throw new TestScenarioFailException(e.getMessage());
		}
	}

	@When("User access Wellmetrics page from top navigation")
	public void user_access_wellmetrics_page_from_top_navigation() {
         connectHomePage.clickMeMenu();
         connectHomePage.clickWellMetricsLink();
	}

	@When("User access HPA page from top navigation")
    public void user_access_hpa_page_from_top_navigation() {
         connectHomePage.clickMeMenu();
         connectHomePage.humanPerformanceLink();
    }

	@Then("User can see {string} page display successfully")
	public void user_can_see_wellmetrics_page(String title) {
	    try {
	        connectWellMetricsPage.isWellMetricsPageTitleDisplay(title);
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
	    
	}

	@Then("User can see value of Blood Pressure match expected {string}")
	public void user_can_see_value_of_blood_pressure_match_expected(String bloodPressure) {
	    try {
            connectWellMetricsPage.verifyBloodPressureValue(bloodPressure);
	    } catch (Exception e) {
			throw new TestScenarioFailException(e.getMessage());
		}
	}

	@Then("User can see Schedule Services page")
	public void schedule_services_page_displays_successfully(){
		try {
			if (connectScheduleServicesPage.isCancelButtonDisplays()) {
				assertTrue(connectScheduleServicesPage.isScheduleServicesDisplaysSuccessfully());
				assertTrue(connectScheduleServicesPage.isCancelButtonDisplays());
				assertTrue(connectScheduleServicesPage.isRescheduleButtonDisplays());
            } else {
                assertTrue(connectScheduleServicesPage.isSelectServicesTextDisplay());
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("User can see value of Total Cholesterol match expected {string}")
    public void user_can_see_value_of_total_cholesterol_match_expected(String totalChoresterol) {
        try {
            assertTrue(connectWellMetricsPage.verifyTotalCholesterolValue(totalChoresterol));
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

	@Then("User can see value of HDL match expected {string}")
    public void user_can_see_value_of_hdl_match_expected(String hdl) {
        try {
            assertTrue(connectWellMetricsPage.verifyHdlValue(hdl));
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

	@Then("User can see value of Triglycerides match expected {string}")
    public void user_can_see_value_of_triglyceride_match_expected(String triglyceride) {
        try {
            assertTrue(connectWellMetricsPage.verifyTriglyceridesValue(triglyceride));
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

	@Then("User can see value of LDL match expected {string}")
    public void user_can_see_value_of_ldl_match_expected(String ldl) {
        try {
            assertTrue(connectWellMetricsPage.verifyLdlValue(ldl));
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

    @Then("User can see value of TC:HDL match expected {string}")
    public void user_can_see_value_of_tc_hdl_match_expected(String tcHdl) {
        try {
            assertTrue(connectWellMetricsPage.verifyTcHdlValue(tcHdl));
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

    @Then("User can see value of LDL:HDL match expected {string}")
    public void user_can_see_value_of_ldl_hdl_match_expected(String ldlHdl) {
        try {
            assertTrue(connectWellMetricsPage.verifyLdlHdlValue(ldlHdl));
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

    @Then("User can see value of Blood Glucose match expected {string}")
    public void user_can_see_value_of_blood_glucose_match_expected(String bloodGlucose) {
        try {
            assertTrue(connectWellMetricsPage.verifyBloodGlucoseValue(bloodGlucose));
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

    @Then("User can see value of Waist match expected {string}")
    public void user_can_see_value_of_waist_match_expected(String waist) {
        try {
            assertTrue(connectWellMetricsPage.verifyWaistValue(waist));
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

    @Then("User can see value of Height match expected {string}")
    public void user_can_see_value_of_height_match_expected(String height) {
        try {
            connectWellMetricsPage.verifyHeightValue(height);
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

    @Then("User can see value of Weight match expected {string}")
    public void user_can_see_value_of_weight_match_expected(String weight) {
        try {
            assertTrue(connectWellMetricsPage.verifyWeightValue(weight));
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

    @Then("User can see value of BMI match expected {string}")
    public void user_can_see_value_of_mbi_match_expected(String bmi) {
        try {
            assertTrue(connectWellMetricsPage.verifyBmiValue(bmi));
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

    @Then("User can see {string} page have {string}, {string}")
    public void user_can_see_human_performance_page(String title, String flourishing, String hpa) {
        try {
            assertTrue(connectHumanPerformancePage.isHumanPerformanceTitleDisplay(title));
            assertTrue(connectHumanPerformancePage.isFlourishingIndexTitleDisplay(flourishing));
            assertTrue(connectHumanPerformancePage.isHumanPerformaceAssessmentTitleDisplay(hpa));
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }
    
    @Then("User can see flourishing index score is {string}")
    public void user_can_see_flouring_index_score(String score) {
        try {
            assertTrue(connectHumanPerformancePage.verifyFlourishingIndexScoreDisplay(score));
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }
    
    @Then("User can see {int} cards in Flourishing Index section")
    public void user_can_see_flouring_index_card(int numberCards) {
        try {
            assertTrue(connectHumanPerformancePage.verifyNumberFlourishingIndexCards(numberCards));
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }
    
    @Then("User can see card {int} in Flourishing Index is {string}")
    public void user_can_card_in_flourishing_index(int index, String title) {
        try {
            assertTrue(connectHumanPerformancePage.verifyFlourishingIndexCardValue(index, title));
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

    @Then("User can see HPA section have {int} cards in Top Strengths")
    public void user_can_see_hpa_top_strength_card(int numberCards) {
        try {
            assertTrue(connectHumanPerformancePage.verifyTopStrengthCards(numberCards));
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }
    
    @Then("User can see HPA section have {int} cards in Top Opportunities")
    public void user_can_see_hpa_top_opportunity_card(int numberCards) {
        try {
            assertTrue(connectHumanPerformancePage.verifyTopOpportunityCards(numberCards));
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }
    
    @Then("User can see {int} cards in All Scores section")
    public void user_can_see_all_score_card(int numberCards) {
        try {
            assertTrue(connectHumanPerformancePage.verifyAllScoreCards(numberCards));
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

    @Then("User is moved to the first registration page")
    public void user_move_to_first_registration_page() {
        try {
            assertTrue(connectRegistrationPage.isGetStartedDisplay());
            assertTrue(connectRegistrationPage.isFirstNameDisplay());
            assertTrue(connectRegistrationPage.isLastNameDisplay());
            assertTrue(connectRegistrationPage.isDOBDisplay());
            assertTrue(connectRegistrationPage.isEmployeeIdDisplay());
            assertTrue(connectRegistrationPage.isNextButtonDisplay());
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

    @Then("User book an available event")
    public void user_book_a_screening_event() {
        try {
            if (connectScheduleServicesPage.isCancelButtonDisplays()) {
                connectScheduleServicesPage.clickCancelCurrentEventButton();
                connectScheduleServicesPage.clickConfirmCancelButton();
            };
            if (connectScheduleServicesPage.isScheduleButtonDisplay()) {
                connectScheduleServicesPage.clickScheduleButton();
            };
            connectScheduleServicesPage.clickSelectLocationButton();
            connectScheduleServicesPage.clickFirstLocationLink();
            connectScheduleServicesPage.clickSelect1stEventButton();
            connectScheduleServicesPage.click900AMTimeButton();
            connectScheduleServicesPage.clickDoneAppointmentButton();
            connectScheduleServicesPage.checkConfirmAppointmentCheckBox();
            connectScheduleServicesPage.clickConfirmAppointmentButton();
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

    @Then("User can see confirmation Thank you to complete booking process")
    public void user_can_see_complete_booking_event_process() {
        try {
            assertTrue(connectScheduleServicesPage.isThankYouTextDisplay());
            assertTrue(connectScheduleServicesPage.isAppointmentConfirmedTextDisplay());
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

    @When("A member has not login to Connect")
    public void member_not_login_connect() {
        try {
            assertTrue(connectLoginpage.updateFirstTimeLoginFeatureCode
                    (TestData.CONNECT_CLIENT_NOT_LOGIN_ACCOUNT, TestData.CONNECT_PASSWORD));
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

    @When("User login to Connect for first time")
    public void user_login_to_cc_for_first_time() {
        connectLoginpage.login(TestData.CONNECT_CLIENT_NOT_LOGIN_ACCOUNT, TestData.CONNECT_PASSWORD);
    }

    @Then("User can see MFA setup page")
    public void user_can_see_mfa_setup_page() {
        try {
            assertTrue(connectLoginpage.verifyTwoFactoryDisplay("two-factor"));
            assertTrue(connectLoginpage.verifyAuthenticationDisplay("authentication"));
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

    @When("User can click Not Now to skip MFA")
    public void user_click_not_now_skip_mfa() {
        connectLoginpage.clickNotNowMFALink();
        connectLoginpage.clickFireVideoSkipLink();
        if (connectLoginpage.isGetStartedButtonDisplay()) {
            connectLoginpage.clickGetStartedButton();
        };
    }

    @Given("A new member is created in system")
    public void create_new_member_in_system() {
        String businessEmailAddress = null;
        try {
            businessEmailAddress = connectLoginpage.createNewEmployee(aduroId, newMemberEmail, firstName, lastName, memberID);
            Thread.sleep(20000);// wait for the employee created
        }
        catch(Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
        if (businessEmailAddress != newMemberEmail) {
            throw new TestScenarioFailException("Can't create new member");
        }
    }

    @Given("New member enter their email on login page and click Log In with Aduro")
    public void new_member_enter_email_and_click_login() {
        try {
             driver.navigate().to(GlobalParameters.CONNECT_URL);
             connectLoginpage.enterEmailAndNext(newMemberEmail);
        }
        catch(Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

    @Given("User start Registration flow and submit")
    public void user_start_register_flow_and_submit() {
        try {
            connectRegistrationPage.inputSignUpInfo(firstName, lastName, DOB, memberID);
        }
        catch(Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }
    @Given("User can see and enter password then submit")
    public void user_can_see_and_enter_password_then_submit() {
        try {
            assertTrue(connectRegistrationPage.isEnterPasswordDisplay());
            connectRegistrationPage.setPassword(TestData.CONNECT_PASSWORD, phoneNumber);
        }
        catch(Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

    @Given("User receive verification email")
    public void verify_user_receive_verification_email() {
        try {
            verificationEmailLink = connectRegistrationPage.getSignUpVerifyLink();
        }
        catch(Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
        if (verificationEmailLink == null) {
            throw new TestScenarioFailException("User don't receive verification email");
        }
    }

    @When("User click to verification link in email")
    public void user_click_to_verification_link_in_email() {
        try {
            driver.navigate().to(verificationEmailLink);
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

    @Then("User is moved to login screen with a green success message appears on the page")
    public void user_is_moved_to_login_screen_with_message() {
        try {
            assertTrue(connectLoginpage.verifyEmailVerifiedMessageDisplay());
            assertTrue(connectLoginpage.isEnterEmailDisplay());
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

    @When("User can not see Schedule a screening button")
	public void user_can_not_see_schedule_screening()
	{
		try {
			assertFalse(connectWellMetricsPage.isScheduleAScreeningButtonDisplay());
		} catch (Exception e){
		    throw new TestScenarioFailException(e.getMessage());
		}
	}

    @When("User switch back to second tab")
	public void user_switch_back_to_2nd_tab()
	{
		try {
			connectWellMetricsPage.switchTo2ndTab();
		} catch (Exception e){
		    throw new TestScenarioFailException(e.getMessage());
		}
	}

    @When("User refresh Wellmetrics page")
	public void user_refresh_connect_wellmetric_tab()
	{
		try {
			connectWellMetricsPage.refreshCurrentPage();
		} catch (Exception e){
		    throw new TestScenarioFailException(e.getMessage());
		}
	}
    
    @Then("User can see {string} option while booking event")
    public void user_see_flu_shots_option_while_booking(String addOnsOption) {
        try {
            switch (addOnsOption) {
 	        case "Flu Shots":
 	        	connectScheduleServicesPage.selectFluShotsServiceCheckBox();
 	            connectScheduleServicesPage.clickSelectLocationButton();
 	            assertTrue(connectScheduleServicesPage.isCheckboxBiometricScreeningChecked());
 	            assertTrue(connectScheduleServicesPage.isCheckboxFluShotsChecked());
 	            break;  
 	        case "Covid Vaccine":  
 	        	connectScheduleServicesPage.selectCovidVaccineServiceCheckBox();
 	            connectScheduleServicesPage.clickSelectLocationButton();
 	            assertTrue(connectScheduleServicesPage.isCheckboxBiometricScreeningChecked());
 	            assertTrue(connectScheduleServicesPage.isCheckboxCovidVaccineChecked());
 	            break;
 	        case "Covid Flu Shots":  
 	        	connectScheduleServicesPage.selectCovidFluShotServiceCheckBox();
 	            connectScheduleServicesPage.clickSelectLocationButton();
 	            assertTrue(connectScheduleServicesPage.isCheckboxBiometricScreeningChecked());
 	            assertTrue(connectScheduleServicesPage.isCheckboxCovidFluShotsChecked());
 	            break;
 	        default:
 	            break;
 		    }
            assertTrue(connectScheduleServicesPage.isFirstLocationLinkDisplay());
            connectScheduleServicesPage.clickFirstLocationLink();
            connectScheduleServicesPage.clickSelect1stEventButton();
            
        } catch (Exception e) {
            throw new TestScenarioFailException(e.getMessage());
        }
    }

    @Then("User search for {string} path in Discover page")
	public void user_search_in_discover_page(String keyword) {
		try {
			connectHomePage.clickDiscoverMenu();
			connectHomePage.inputSearchKeyword(keyword);
		} catch (Exception e){
		    throw new TestScenarioFailException(e.getMessage());
		}
	}

    @Then("User access path {string} and see {string} practice")
	public void access_path_and_see_practice(String pathName, String practiceName) {
		try {
			assertTrue(connectHomePage.verifyPathNameDisplay(pathName));
			connectHomePage.click1stPathName();
			assertTrue(connectPathDetailPage.verifyPathNameDisplay(pathName));
			assertTrue(connectPathDetailPage.verify1stPracticeNameDisplayInPath(practiceName));
		} catch (Exception e){
		    throw new TestScenarioFailException(e.getMessage());
		}
	}
    
    @Then("User can open {string} to see {string} survey")
	public void access_open_practice_and_see_survey(String practiceName, String surveyName) {
		try {
			connectPathDetailPage.click1stPracticeName();
			assertTrue(connectPathDetailPage.isSurveyCardDisplay());
			assertTrue(connectPathDetailPage.verifySurveyNameDisplay(surveyName));
		} catch (Exception e){
		    throw new TestScenarioFailException(e.getMessage());
		}
	}
}
