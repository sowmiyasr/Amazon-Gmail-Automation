import java.util.Set;
import java.util.List;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Application {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Success4\\eclipse-workspace\\Selen\\driver\\chromedriver_win32\\chromedriver.exe");
		// disabling browser alert
		ChromeOptions co = new ChromeOptions(); 
		co.addArguments("--disable-notifications");
		ChromeDriver d = new ChromeDriver(co);
		// google
		d.get("https://www.google.com/");
		d.manage().window().maximize();
		String currentHandle = d.getWindowHandle();
		System.out.println("WindowHandle ID " + currentHandle);
		Thread.sleep(2000);
		// Handling frame1
		d.switchTo().frame(0);
		Thread.sleep(2000);
		d.findElementByXPath("//button[@class='M6CB1c rr4y5c']").click();
		Thread.sleep(2000);
		d.switchTo().defaultContent();
		Thread.sleep(2000);
		String search = "amazon shopping login";
		d.findElementByXPath("//textarea[@id='APjFqb']").sendKeys(search, Keys.ENTER); 
		Thread.sleep(2000);
    /*  sweet alert know your location (allow,block)  */
    //Alert alert = driver.switchTo().alert();
    //alert.accept();
    //String alertmsg = alert.getText();
    //System.out.println(alertmsg);
		d.findElementByXPath("//span[@class='x2VHCd OSrXXb ob9lvb']").click();
		Thread.sleep(2000);
		d.findElementByXPath("//span[@id='nav-link-accountList-nav-line-1']").click();
		Thread.sleep(2000);
    //driver.navigate().refresh();
		//logging into amazon account
		String email = " ";  // pass your registered gmail address 
		d.findElementByXPath("//input[@type='email']").sendKeys(email, Keys.ENTER);
		String password = " ";    //password
		d.findElementByXPath("//input[@type='password']").sendKeys(password, Keys.ENTER);
		Thread.sleep(2000);
		d.findElementByXPath("//input[@type='text']").clear();
		Thread.sleep(2000);
		// searching for unicorn toy
		String searchitem = " unicorn toy";
		d.findElementByXPath("//input[@type='text']").sendKeys(searchitem, Keys.ENTER);
		Thread.sleep(2000);
        //Scroll down
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("window.scrollBy(0,450)", "");
		// clicking feature checkbox 
		d.findElementByXPath("(//a[@class='a-link-normal s-navigation-item'])[12]/child::*").click();
		String text = d.findElementByXPath("(//span[@class='a-size-base a-color-base a-text-bold'])[2]").getText();
		System.out.println("Selected feature character is " + text);
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,450)", "");
		// clicking brand checkbox 
		d.findElementByXPath("(//i[@class='a-icon a-icon-checkbox'])[6]").click();
    //String text2 = driver.findElementByXPath("(//span[@class='a-size-base a-color-base'])[32]").getText();
    //System.out.println("Selected Brandname is " + text2);
		Thread.sleep(2000);
		//choosing price between
		String minamount = "500";
		String maxamount = "3000";
		d.findElementByXPath("//input[@placeholder='Min']").sendKeys(minamount);
		Thread.sleep(2000);
		d.findElementByXPath("//input[@placeholder='Max']").sendKeys(maxamount);
		Thread.sleep(2000);
		WebElement goele = d.findElementByXPath("(//input[@type='submit'])[3]");
		
		js.executeScript("arguments[0].click();", goele);

    //WebElement thirdproduct = driver.findElementByXPath("//span[contains(text(),'Calm')]");
   //JavascriptExecutor executor1 = (JavascriptExecutor) driver;
   //executor1.executeScript("arguments[0].click();", thirdproduct);

		// driver.findElementByXPath("//span[@id='a-autoid-11-announce']").click();
   // driver.findElementByXPath("(//i[@class='a-icon a-icon-checkbox'])[20]").click();
   //String text3 = driver.findElementByXPath("(//span[@class='a-size-base a-color-base'])[29]").getText();
   //System.out.println("selected age between"+text3);
   // driver.findElementByXPath("(//i[@class='a-icon a-icon-checkbox'])[32]").click();
   // String text4 = driver.findElementByXPath("(//span[@class='a-size-base a-color-base'])[41]").getText();
   // System.out.println("Toy material have selected is "+text4);
		
		js.executeScript("window.scrollBy(0,350)", "");
    //driver.findElementByXPath("(//span[@class='a-expander-prompt'])[2]").click();
		d.findElementByXPath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]").click();
		String UnicornToy = d.getCurrentUrl();
		System.out.println("Selected Toy URL " + UnicornToy);
		Thread.sleep(2000);

		Set<String> windowHandles = d.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		for (String windowID : list) {
			System.out.println("WindowID " + windowID);
		}
		int size = list.size();
		System.out.println("No of windows " + size);
		d.switchTo().window(list.get(1));
		String pt = d.findElementById("productTitle").getText();
		System.out.println("Choice Product1 Title ---" + pt);

		Actions ac = new Actions(d);
		WebElement aEle = d.findElementByXPath("//span[@class='a-icon-alt'][1]");
		ac.moveToElement(aEle).build().perform();
//		 String rating = driver.findElementByXPath("(//span[@class='a-icon-alt'])[1]").getText();
//		 System.out.println("Rating "+rating);
//		 String price = driver.findElementByXPath("(//span[@class='a-price-whole'])[1]").getText();
//		 System.out.println("Price of the Toy "+price);
//		 String dt = driver.findElementByXPath("(//span[@class='a-text-bold'])[1]").getText();
//		 System.out.println("Delivery Date "+dt);
//	     String pd = driver.findElementByXPath("//ul[@class='a-unordered-list a-vertical a-spacing-mini']").getText();
//	     System.out.println("About this item "+pd);
	
		js.executeScript("window.scrollBy(0,350)", "");
		d.findElementById("add-to-cart-button").click();

//	     WebElement cartele = driver.findElementByClassName("nav-cart-icon nav-sprite");
//	     ac.contextClick(cartele).perform();
		d.findElementById("nav-cart-count-container").click();
		d.findElementByXPath("//span[@class='a-button-text a-declarative'][1]").click();
		// product quantity should 1
		WebElement quantity = d.findElementByXPath("//select[@id='quantity'][1]");
		Select noofitems = new Select(quantity);
		boolean multiple = noofitems.isMultiple();
		System.out.println(multiple);
		noofitems.selectByIndex(1);
		Thread.sleep(1000);
	
		js.executeScript("window.scrollBy(0,350)", "");
		
		// ADDING PRODUCT 2 FROM CART
		
		WebElement secondproduct = d.findElementByXPath("(//a[@class='a-link-normal sc-product-link'])[8]");
	
		js.executeScript("arguments[0].click();", secondproduct);
		Set<String> windowHandles1 = d.getWindowHandles();
		List<String> list1 = new ArrayList<String>(windowHandles1);
		for (String windowID1 : list1) {
			System.out.println("WindowID " + windowID1);
		}
		int size1 = list1.size();
		System.out.println("No of windows  " + size1);
		d.switchTo().window(list1.get(2));
		String pd2 = d.findElementById("productTitle").getText();
		System.out.println("CART Product2 Title --- " + pd2);
		String product2Url = d.getCurrentUrl();
		System.out.println("URL of the Product --- " + product2Url);
		String product2price = d.findElementByXPath("(//span[@class='a-price-whole'])[1]").getText();
		System.out.println("Price of the product  ---" + product2price);
		d.close();
		d.switchTo().window(list.get(1));
		//checkout for selected 2 products
		d.findElementByName("proceedToRetailCheckout").click();
		Thread.sleep(2000);
		d.switchTo().window(list1.get(0));

    
		// ADDING PRODUCT 3 FORM WISHLIST

	    //MainMenu
		WebElement mainMenu = d.findElementByXPath("//span[contains(text(),'Hello, Sowmisaran')]");
		Actions actions = new Actions(d);
        //Mouse hover action on the mainmenu
		actions.moveToElement(mainMenu);
		Thread.sleep(2000);
		//Mouse hover action on the submenu
		WebElement subMenu = d.findElementByXPath("//span[contains(text(),'Your Wish List')]");
		actions.moveToElement(subMenu);
		actions.click().build().perform();
		
		js.executeScript("window.scrollBy(0,450)", "");
		
        // selecting product from wishlist items 
		d.findElementById("pab-IRPFKWXDIW5L2").click();
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,-450)", "");
		// adding it into the cart
		d.findElementById("nav-cart-count-container").click();
   //WebElement viewcartele = driver.findElementByXPath("//span[@class='a-button a-button-base a-button-small g-cart-view-btn']");
   //actions.moveToElement(viewcartele);
    //actions.click().build().perform();
		Thread.sleep(1000);
		// going to cart items
		d.findElementByXPath("(//span[@class='a-button-text a-declarative'])[1]").click();
		// product quantity should 1
		WebElement quantity2 = d.findElementByXPath("//select[@id='quantity'][1]");
		Select noofitems2 = new Select(quantity2);
		boolean multiple2 = noofitems2.isMultiple();
		System.out.println(multiple2);
		noofitems2.selectByIndex(1);
		Thread.sleep(1000);
		// clicking on 3rd product to get details of the product
		WebElement thirdproduct = d.findElementByXPath("//span[contains(text(),'Calm')]");
		
		js.executeScript("arguments[0].click();", thirdproduct);
    //actions.moveToElement(thirdproduct);
    //actions.click().build().perform();

		Set<String> windowHandles2 = d.getWindowHandles();
		List<String> list2 = new ArrayList<String>(windowHandles2);
		for (String windowID2 : list2) {
			System.out.println("WindowID " + windowID2);
		}
		int size2 = list2.size();
		System.out.println("No of windows  " + size2);
		d.switchTo().window(list2.get(2));

		String pd3 = d.findElementByXPath("//span[@id='productTitle']").getText();
		System.out.println("WISLIST Product3 Title " + pd3);
		String product3price = d.findElementByXPath("//span[@id='price']").getText();
		System.out.println("Price of the product  -" + product3price);
		String product3url = d.getCurrentUrl();
		System.out.println("URL of the Product ---" + product3url);
		Thread.sleep(1000);
		d.close();
		d.switchTo().window(list2.get(0));
		Thread.sleep(1000);
		// closing existing checkout page of only 2 products
		d.switchTo().window(list2.get(1)); 
		d.close();
		//mainpage
		d.switchTo().window(list2.get(0));
		// final checkout page of all 3 selected products
		d.findElementByName("proceedToRetailCheckout").click();
		String addr = d.findElementByXPath("//*[contains(text(),'MADANAPALLE')]").getText();
		System.out.println("SHIPPING ADDRESS -"+addr);

		String total = d.findElementByXPath("//*[contains(text(),'.00')]").getText();
		System.out.println("ORDER TOTAL PRICE --- "+total);
		
		// sending order details to registered email address
		
		d.navigate().to("http://www.google.com");
		
		String search1 = "Gmail login";
		d.findElementByXPath("//textarea[@id='APjFqb']").sendKeys(search1, Keys.ENTER); 
		Thread.sleep(2000);
		d.findElementByXPath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]").click();
		d.findElementByXPath(".//*[text()[contains(.,\"Sign in\")]]").click();
		String mailid = " ";    // pass your gmail address
		d.findElementByXPath("//input[@class='whsOnd zHQkBf']").sendKeys(mailid, Keys.ENTER);

		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(d, 10);
		WebElement passwordElement = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
		passwordElement.click();
		passwordElement.clear();
		passwordElement.sendKeys("  ", Keys.ENTER); // pass your password

		WebDriverWait wait1 = new WebDriverWait(d, 10);
		WebElement compose = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='T-I T-I-KE L3']")));
		compose.click();
	
		String mailid1 = "   ";   // give your gmail address
		WebDriverWait wait2 = new WebDriverWait(d, 10);
		WebElement toele = wait2
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='agP aFw']")));
		toele.click();
		toele.clear();
		toele.sendKeys(mailid1);
	
		String subject = "AMAZON - ORDER PLACED";
		d.findElementByXPath("//input[@name='subjectbox']").sendKeys(subject);
		Thread.sleep(2000);
		d.findElementByXPath("//div[@class='Am Al editable LW-avf tS-tW']").sendKeys("\n       HELLO SOWMIYA                          "
			   	+ "\nName of the Product --"+pt+"        \nName of the Product 2 --"+pd2+"     "
		            + "\nPrice of the Product 2 --"+product2price+
		              "\nName of the Product 3 --"+pd3+"\nPrice "
		       	+ "of the Product --"+product3price+"\n       THANK YOU FOR SHOPPING   ");
		Thread.sleep(4000);
		//Attaching file
		Robot r = new Robot();
		r.setAutoDelay(2000);
		WebElement attachele = d.findElementByXPath("//div[@class='a1 aaA aMZ']");
		
		js.executeScript("arguments[0].click();", attachele);
		//d1.findElementByXPath("//div[@class='a1 aaA aMZ']").click();
		StringSelection imgpath = new StringSelection("file:///C:/Users/Success4/Pictures/a-img.webp");   // path for an img
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(imgpath,null);
		r.setAutoDelay(3000);
		     
	  r.keyPress(KeyEvent.VK_CONTROL);
	  r.keyPress(KeyEvent.VK_V);	 
	  r.keyRelease(KeyEvent.VK_CONTROL);
	  r.keyRelease(KeyEvent.VK_V);	 
	      
		r.setAutoDelay(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_ENTER);
		
		d.findElementByXPath("//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']").click();
		Thread.sleep(2000);
		d.quit();
	}
}
