package com.whitecircleschool.POMWithCucumber2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	//There is one usernmae textbox
	//private WebElement username = driver.findElement(By.name("userName"));
	@FindBy(name="userName") 
	private WebElement username;
	
	//There is one password textbox
	@FindBy(name="password")
	private WebElement password;
		
	//There is one Login button
	@FindBy(name="login")
	private WebElement submit;
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void applicationLogin(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		submit.click();
	}

}
