package keywordriven;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FuntionalLibrary {
	public static WebDriver driver=null;
	public static String Result="";
	public static String AlertText="";
	
	
	public void myfuction4() throws IOException
	{
		try
		{
			
			int i=5;
			i=i/0;
			RunManager.Result_Status.setCellValue("Pass");
			Result="Pass";
			
		}catch (Exception IE1)
		{
			String Comments=IE1.getMessage();
			RunManager.Resultcomment.setCellValue("Object Not Found and Exception is :-"+Comments);
			RunManager.Result_Status.setCellValue("Failed");
			//ResultFileTest.write(fileOut);
			Result="Failed";
			
			
		}
		
	}
	public void myfuction5()
	{
		try
		{
			System.out.println("We are in 5");
			RunManager.Result_Status.setCellValue("Pass");
			Result="Pass";
		}catch (Exception IE1)
		{
			RunManager.Result_Status.setCellValue("Failed");
			Result="Failed";
		}
	}
	
	public void Login_OpenUI() throws IOException
	{
			try
				{
					driver=new FirefoxDriver();
					driver.get("http://onecrm-acc-siebel.gen.local/ecommunications_oui/start.swe?");
					Thread.sleep(2000);
					String URL=RunManager.HashMap_DataSheet.get("URL");
					String UserName=RunManager.HashMap_DataSheet.get("Username");
					RunManager.Agent1.setCellValue(UserName);
					String Password=RunManager.HashMap_DataSheet.get("Password");
					driver.get(URL);
					driver.manage().deleteAllCookies();
					driver.manage().window().maximize();
					driver.findElement(By.name("SWEUserName")).sendKeys(UserName);
					driver.findElement(By.name("SWEPassword")).sendKeys(Password);
					//Click on Login button
					driver.findElement(By.id("s_swepi_22")).click();
					Thread.sleep(22000);
					RunManager.Result_Status.setCellValue("Pass");
					Result="Pass";
				}catch(Exception LaunchA)
				{
					String Comments=LaunchA.getMessage();
					RunManager.Resultcomment.setCellValue("Object Not Found and Exception is :-"+Comments);
					RunManager.Result_Status.setCellValue("Failed");
					Result="Failed";
           
				}
        
	}
	
	public void Open_TBUI_Flow() throws IOException
	{	
		try
		{
			String Postcode=RunManager.HashMap_DataSheet.get("Postcode");
			String Housenumber=RunManager.HashMap_DataSheet.get("Housenumber");
			String Portfoli=RunManager.HashMap_DataSheet.get("Portfolio");
			//Set Result Sheet
			RunManager.PostalCode1.setCellValue(Postcode);
			RunManager.HouseNumber1.setCellValue(Housenumber);
			RunManager.Portfolio1.setCellValue(Portfoli);
			
			WebElement Taken= driver.findElement(By.xpath("//div[@id='s_toolbar']/ul/li[@id='tb_9']"));
			Taken.click();
			Thread.sleep(2000);
			WebElement NewInitialOrder=driver.findElement(By.xpath("//div[@id='s_TaskUIPane']/ul/li/ul/li[@class='dynatree-lastsib']/ul/li/span/a"));
			NewInitialOrder.click();
			Thread.sleep(5000);
			WebElement PostCode= driver.findElement(By.xpath("//*[@id='a_3']/div/table/tbody/tr[4]/td[3]/div/input"));
			PostCode.sendKeys(Postcode);
			WebElement HouseNumber= driver.findElement(By.xpath("//*[@id='a_3']/div/table/tbody/tr[5]/td[3]/div/input"));
			HouseNumber.sendKeys(Housenumber);
			WebElement ControleerPostcode= driver.findElement(By.xpath("//button[@id='s_3_1_5_0_Ctrl']"));
			ControleerPostcode.click();
			Thread.sleep(10000);
			//Select Portfolio
			WebElement Portfolio=driver.findElement(By.xpath("//input[@name='s_3_1_4_0']"));
			Portfolio.click();
			Thread.sleep(1000);
			Portfolio.sendKeys(Portfoli);
			Thread.sleep(2000);
			//Click on Stad
			driver.findElement(By.xpath("//*[@id='a_3']/div/table/tbody/tr[10]/td[3]/div/input")).click();
			Thread.sleep(2000);
			WebElement Zoeken=driver.findElement(By.xpath("//button[@id='s_3_1_6_0_Ctrl']"));
			Zoeken.click();
			Thread.sleep(20000);
			if (isAlertPresent()) 
			{
				RunManager.Resultcomment.setCellValue("UnWanted Alert Message is displayed :-"+FuntionalLibrary.AlertText);
				RunManager.Result_Status.setCellValue("Failed");
				Result="Failed";
				Siebel_OpenUI_Logout();
			}
			else
			{
				//Select Second Row
				WebElement SelectPackage=driver.findElement(By.xpath("//table[@id='s_4_l']/tbody/tr[2]"));
				SelectPackage.click();
				WebElement Selectren=driver.findElement(By.xpath("//button[@id='s_1_1_0_0_Ctrl']"));
				Selectren.click();
				Thread.sleep(5000);
				//Select Technology Type
				WebElement selectTechnologytype=driver.findElement(By.xpath("//table[@id='s_2_l']/tbody/tr[2]"));
				selectTechnologytype.click();
				Thread.sleep(4000);
				WebElement Volgende=driver.findElement(By.xpath("//button[@id='s_5_1_3_0_Ctrl']"));
				Volgende.click();
				Thread.sleep(15000);
				if (isAlertPresent())
				{
					RunManager.Resultcomment.setCellValue("UnWanted Alert Message is displayed :-"+FuntionalLibrary.AlertText);
					RunManager.Result_Status.setCellValue("Failed");
					Result="Failed";
					Siebel_OpenUI_Logout();
				}
				else			
				{

				//Select NL Line
					WebElement SelectNLLine=driver.findElement(By.xpath("//table[@id='s_4_l']/tbody/tr[2]"));
					SelectNLLine.click();
					Thread.sleep(2000);
					//Click on Selectren button
					WebElement NLLineSelectren=driver.findElement(By.xpath("//button[@id='s_5_1_1_0_Ctrl']"));
					NLLineSelectren.click();
					Thread.sleep(14000);
					WebElement Verbindingen=driver.findElement(By.xpath("//table[@id='s_3_l']/tbody/tr[2]"));
					Verbindingen.click();
					Thread.sleep(2000);
					WebElement VolgendeNLline=driver.findElement(By.xpath("//button[@id='s_6_1_1_0_Ctrl']"));
					VolgendeNLline.click();
					Thread.sleep(80000);
					//Click on Anapasan Button
					WebElement Anapasan=driver.findElement(By.xpath("//button[@id='s_2_1_26_0_Ctrl']"));
					Anapasan.click();
					Thread.sleep(15000);
					WebElement Voltiood=driver.findElement(By.xpath("//button[@id='GRPITEM[~^`grpItemId2`^~[LINK']"));
					Voltiood.click();
					Thread.sleep(15000);
					//Select Asset
					WebElement SelectAsset=driver.findElement(By.xpath("//table[@id='s_2_l']/tbody/tr[2]"));
					SelectAsset.click();
					Thread.sleep(2000);
					//Click on Volgende on Anapasan product
					WebElement VoltioodAnapasanProduct=driver.findElement(By.xpath("//button[@id='s_1_1_2_0_Ctrl']"));
					VoltioodAnapasanProduct.click();
					Thread.sleep(6000);
					//Query Service Account
					WebElement QueryServiceAccount=driver.findElement(By.xpath("//button[@id='s_3_1_7_0_Ctrl']"));
					QueryServiceAccount.click();
					Thread.sleep(3000);
					WebElement EnterbedriefAccount=driver.findElement(By.xpath("//*[@id='1_s_3_l_AccountTypeCode']"));
					EnterbedriefAccount.click();
					Thread.sleep(2000);
					//
					WebElement EnterAccount=driver.findElement(By.xpath("//*[@id='1_AccountTypeCode']"));
					EnterAccount.sendKeys("Bedrijf");
					Thread.sleep(2000);
					//Click on outside textbox
					driver.findElement(By.xpath("//*[@id='1_s_3_l_Account_Status']")).click();
					//Click on Go Button
					WebElement ClickonGoButton=driver.findElement(By.xpath("//button[@id='s_3_1_4_0_Ctrl']"));
					ClickonGoButton.click();
					Thread.sleep(5000);
					//Select Account
					WebElement SelectAccountname=driver.findElement(By.xpath("//table[@id='s_3_l']/tbody/tr[2]"));
					SelectAccountname.click();
					Thread.sleep(2000);
					//click on next button on Select Service Account
					WebElement ClickOnNextbutton=driver.findElement(By.xpath("//button[@id='s_1_1_2_0_Ctrl']"));
					ClickOnNextbutton.click();
					Thread.sleep(15000);
					WebElement SelectContact=driver.findElement(By.xpath("//table[@id='s_3_l']/tbody/tr[2]"));
					SelectContact.click();
					Thread.sleep(3000);
					//Select TextBox
					driver.findElement(By.xpath("//*[@id='a_4']/div/table/tbody/tr[2]/td[4]/div/input")).click();
					Thread.sleep(2000);
					WebElement ContactNext=driver.findElement(By.xpath("//button[@id='s_2_1_2_0_Ctrl']"));
					ContactNext.click();
					Thread.sleep(10000);
					//Select corrosponding address
					WebElement SelectAddress=driver.findElement(By.xpath("//table[@id='s_3_l']/tbody/tr[2]"));
					SelectAddress.click();
					Thread.sleep(2000);
					WebElement NextAddressButton=driver.findElement(By.xpath("//button[@id='s_1_1_2_0_Ctrl']"));
					NextAddressButton.click();
					Thread.sleep(10000);
					//Select BillingProfile
					WebElement SelectBillingAddress=driver.findElement(By.xpath("//table[@id='s_2_l']/tbody/tr[2]"));
					SelectBillingAddress.click();
					Thread.sleep(2000);
					WebElement NextSelectBillingAddress=driver.findElement(By.xpath("//button[@id='s_1_1_2_0_Ctrl']"));
					NextSelectBillingAddress.click();
					Thread.sleep(15000);
					//Enter Comments Field
					driver.findElement(By.xpath("//*[@id='a_3']/div/table/tbody/tr[10]/td[6]/div/textarea")).sendKeys("Test Automation Demo");
					driver.findElement(By.xpath("//input[@name='s_1_1_0_0']")).click();
					driver.findElement(By.xpath("//input[@name='s_1_1_0_0']")).sendKeys("KPN Inbound SAVE");
					//String OrderNumber = driver.findElement(By.xpath("//input[@name='s_3_1_77_0']")).getText();
					//System.out.println("Order Number :- "+OrderNumber );
					driver.findElement(By.xpath("//input[@name='s_1_1_4_0']")).click();
					Thread.sleep(2000);
					//
					driver.findElement(By.xpath("//*[@id='a_6']/div[2]/div[2]/input[2]")).click();
					//Click on Next button on Order Summary page
					driver.findElement(By.xpath("//div[@id='s_S_A4_div']/div/span/button[@id='s_4_1_1_0_Ctrl']")).click();
					Thread.sleep(30000);
					RunManager.Result_Status.setCellValue("Pass");
					Result="Pass";
				}
			}
		}catch(Exception LaunchA)
		{
			String Comments=LaunchA.getMessage();
			RunManager.Resultcomment.setCellValue("Object Not Found and Exception is :-"+Comments);
			RunManager.Result_Status.setCellValue("Failed");
			Result="Failed";
			Siebel_OpenUI_Logout();
   
		}
	}
	
	public void NavigateOrderScreen() throws IOException
	{
			try
				{
					WebElement OrderLink=driver.findElement(By.linkText("Orders"));
					OrderLink.click();
					Thread.sleep(4000);
					String OrderNumber=driver.findElement(By.xpath("//div[@id='s_S_A4_div']/div/form/div/table/tbody/tr[1]/td")).getText();
					//System.out.println("OrderNumber :-"+OrderNumber);
					//OrderNumber1
					RunManager.OrderNumber1.setCellValue(OrderNumber);
					//Enter Order Number to Search
					WebElement Text_OrderNr=driver.findElement(By.xpath("//input[@name='s_2_1_11_0']"));
					Text_OrderNr.sendKeys(OrderNumber);
					//Click on Go Button
					driver.findElement(By.xpath("//button[@id='s_2_1_10_0_Ctrl']")).click();
					Thread.sleep(12000);
					String Text_OrderStatus=driver.findElement(By.xpath("//*[@id='1_s_2_l_Status']")).getText();
					RunManager.OrderStatus1.setCellValue(Text_OrderStatus);
					//Click on Order Nr
					driver.findElement(By.xpath("//*[@id='1_s_2_l_KPN_Order_Number']/a")).click();
					Thread.sleep(5000);
					RunManager.Result_Status.setCellValue("Pass");
					Result="Pass";
				}catch(Exception LaunchA)
				{
					String Comments=LaunchA.getMessage();
					RunManager.Resultcomment.setCellValue("Object Not Found and Exception is :-"+Comments);
					RunManager.Result_Status.setCellValue("Failed");
					Result="Failed";
					Siebel_OpenUI_Logout();
           
				}
        
	}
	public static boolean isAlertPresent() 
	{ 
	    try 
	    { 
	    	AlertText=driver.switchTo().alert().getText();
			System.out.println("Alert Text :- "+AlertText);
			driver.switchTo().alert().accept();
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }   // catch 
	}
	public void Siebel_OpenUI_Logout() throws IOException
	{
			try
				{
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='tb_0']")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//div[@class='siebui-tb-popup-bottom']/div[@id='tb_item_4']")).click();
					Thread.sleep(3000);
					driver.close(); 
					RunManager.Result_Status.setCellValue("Pass");
					Result="Pass";
				}catch(Exception LaunchA)
				{
					String Comments=LaunchA.getMessage();
					RunManager.Resultcomment.setCellValue("Object Not Found and Exception is :-"+Comments);
					RunManager.Result_Status.setCellValue("Failed");
					Result="Failed";
           
				}
        
	}
	
	
	
	
}

