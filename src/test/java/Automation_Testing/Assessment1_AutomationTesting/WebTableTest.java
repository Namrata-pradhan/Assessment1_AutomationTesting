package Automation_Testing.Assessment1_AutomationTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableTest{
	WebDriver driver;
	@Test
	public void openBrowser() {
		//Launching Browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		
		//Initalizing chromedriver
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Navigate to the ToolsQA website with the web table
		driver.get("https://demoqa.com/webtables");
		
		//Locate the web table Element
		WebElement table=driver.findElement(By.xpath("//div[@class='ReactTable -striped -highlight']/div"));
		
		//Get the column headers
		java.util.List<WebElement> headers=table.findElements(By.xpath(".//div[@role='columnheader']"));
		for (WebElement header:headers) {
			System.out.print(header.getText()+"/t");
		}
		System.out.println();
		
		//Get all the rows of the table
		java.util.List<WebElement> rows=table .findElements(By.xpath(".//div[@role='row']"));
		
		//Iterate through each row
		for (WebElement row:rows) {
			//get all cells in the row
			java.util.List<WebElement> cells=row.findElements(By.xpath(".//div[@role='gridcell']"));
			
			//iterate through each cell
			
			for (WebElement cell:cells) {
				//Print the text of each cell
				System.out.print(cell.getText()+"\t");
			}
			System.out.println();
		}
		
		//close Browser
		driver.quit();
		
	}
}