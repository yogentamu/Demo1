package com.qa.git;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class G1Messenger {

	public static void main(String[]args) {
	
		
		
	WebDriverManager.chromedriver()	.setup();
    WebDriver yogen=new ChromeDriver();
    
    yogen.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	yogen.get("http://google.com");
	
	yogen.findElement(By.name("q")).sendKeys("messenger");
		
		//how to move from ul to div -use decendent: child of //li--going to li -class name
       //upto here nothing is going to be selected
	
	   //*******use findElements???
	List<WebElement>list=yogen.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
		
	System.out.println("Total number of suggestion:  "+list.size());
	
	for(int i=0;i<list.size();i++) {
		//make sure to use .gettext()too.
		
		System.out.println(i+": "+list.get(i).getText());
	
		//using first get index-gettext-contains to check the title we wanted 
		//it iterate and keep checking 
	if (list.get(i).getText().contains("messenger login")) {
		
		list.get(i).click();
		String title=yogen.getTitle();
		System.out.println("This is the selected one:: "+title);
	//the moment key word is found we use break and it come  out and termnate the for loop, it wont look for other suggestion
		break;
	}	
		
		
	}
	yogen.close();
	
	}
	
}
