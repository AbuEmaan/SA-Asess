
import com.google.common.io.BaseEncoding;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import javax.script.*;
import com.google.common.io.Files;


import java.io.*;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static org.junit.Assert.fail;

public class SAAssessmentSteps {


    @Given("^User opens page$")
    public void userOpenPage() {
     // TestBase.getDriver().get("http://salaamacademy.co.uk/admin");
        TestBase.getDriver().get("https://salaamacademy.co.uk/testing/index.php");


    }



    @Then("Update passwordsNew")
    public void update_PasswordNew() throws InterruptedException, IOException {
        WebDriver driver = TestBase.getDriver();

        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("Wise");

        driver.findElement(By.id("password")).sendKeys("W15eadmin");

        driver.findElement(By.xpath("//input[@value='Login']")).click();

        driver.findElement(By.linkText("ADMIN")).click();

        driver.findElement(By.linkText("User Admin")).click();


        // Create object of the Select class
        String file = System.getProperty("user.dir") + File.separator + "parentsByUserID.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int count = 1;
            String val = "";


            while ((line = br.readLine()) != null) {

                line = line.trim();
                System.out.println("Last Actioned student: '" + line + "'");
                driver.findElement(By.id("search")).sendKeys(line);
                driver.findElement(By.xpath("(//input[@value='Go'])[2]")).click();


                // click on student/user
                driver.findElement(By.xpath("//table[@class=' w-full']/tbody/tr/td[7]/nav/div/a[3]")).click();


                // set new password
                driver.findElement(By.id("passwordNew")).sendKeys("Password1");
                driver.findElement(By.id("passwordConfirm")).sendKeys("Password1");

                driver.findElement(By.id("passwordForceReset")).click();
                driver.findElement(By.xpath("//option[text()='Yes']")).click();

                driver.findElement(By.xpath("//input[@value='Submit']")).click();

                // Return to main screen
                driver.findElement(By.xpath("(//a[text()='User Admin'])[2]")).click();

                Thread.sleep(500);
            }


        }
    }



    @Then("Update passwords")
    public void update_Password() throws InterruptedException, IOException {
        WebDriver driver = TestBase.getDriver();

        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("Wise");

        driver.findElement(By.id("password")).sendKeys("W15eadmin");

        driver.findElement(By.xpath("//input[@value='Login']")).click();

        driver.findElement(By.linkText("ADMIN")).click();

        driver.findElement(By.linkText("User Admin")).click();

        //select class from drop down
        driver.findElement(By.id("limit")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//option[text()='All']")).click();

        Thread.sleep(1000);
        driver.findElement(By.id("filter")).click();
        driver.findElement(By.xpath("//option[text()='Role: Student']")).click();


       for ( int t =1; t<=508; t++)
        {

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//table[@class=' w-full']/tbody/tr["+t+"]")));

            try {
                String name = driver.findElement(By.xpath("//table[@class=' w-full']/tbody/tr[" + t + "]/td[2]")).getText();
                System.out.print("Student: " + name);
                driver.findElement(By.xpath("//table[@class=' w-full']/tbody/tr[" + t + "]/td[7]/nav/div/a[3]")).click();
            }catch(Exception e)
            {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//table[@class=' w-full']/tbody/tr["+t+"]")));

                String name = driver.findElement(By.xpath("//table[@class=' w-full']/tbody/tr[" + t + "]/td[2]")).getText();
                System.out.print("Student: " + name);
                driver.findElement(By.xpath("//table[@class=' w-full']/tbody/tr[" + t + "]/td[7]/nav/div/a[3]")).click();
            }

             // set new password

            driver.findElement(By.id("passwordNew")).sendKeys("Password1");
            driver.findElement(By.id("passwordConfirm")).sendKeys("Password1");

            driver.findElement(By.id("passwordForceReset")).click();
            driver.findElement(By.xpath("//option[text()='Yes']")).click();

            driver.findElement(By.xpath("//input[@value='Submit']")).click();

            // Return to main screen

            driver.findElement(By.xpath("(//a[text()='User Admin'])[2]")).click();

            Thread.sleep(500);


            /*Select selectType = new Select(driver.findElement(By.id("limit")));
            selectType.selectByVisibleText("All");

            Thread.sleep(2000);

            Select selectType1 = new Select(driver.findElement(By.id("filter")));
            selectType1.selectByVisibleText("Role: Student");

            //Select selectType = new Select(driver.findElement(By.id("limit")));
            selectType.selectByVisibleText("All");

             */


            driver.findElement(By.id("limit")).click();
            driver.findElement(By.xpath("//option[text()='All']")).click();

            Thread.sleep(1000);
            driver.findElement(By.id("filter")).click();
            driver.findElement(By.xpath("//option[text()='Role: Student']")).click();

            Thread.sleep(1000);
            driver.findElement(By.id("limit")).click();
            driver.findElement(By.xpath("//option[text()='All']")).click();



        }

    }





    @Then("User startes the process of setting results")
    public void user_startes_the_process_of_setting_results() throws InterruptedException, IOException {
        WebDriver driver =  TestBase.getDriver();

        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("Wise");

        driver.findElement(By.id("password")).sendKeys("W15eadmin");

        driver.findElement(By.xpath("//input[@value='Login']")).click();

        driver.findElement(By.linkText("ASSESS")).click();

        driver.findElement(By.linkText("Formal Assessment")).click();

        driver.findElement(By.linkText("Manage Internal Assessments")).click();

        // loop through options

        // Create object of the Select class
        String file = System.getProperty("user.dir")+ File.separator+ "classes.txt";
        String ClassesAlreadySet="";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int count =1;
            String val ="";
            String className="";
            String commentType="";

           // String textsamples = "00000165,00000188,00000148,00000157,00000203";
            String textsamples = "00000287";
            while ((line = br.readLine()) != null) {

                line = line.trim();

                //- comment this to test single row
              //  if (textsamples.contains(line)) {


                    System.out.println("Last Actioned Name: '" + line + "'");

                    val = line;
                   // className = "Quran";

                    if (!ClassesAlreadySet.contains(val)) {
                        //select class from drop down
                        Select selectType = new Select(driver.findElement(By.id("gibbonCourseClassID")));
                        selectType.selectByValue(val);
                        className = selectType.getAllSelectedOptions().get(0).getText();

                        if (className.startsWith("IS"))
                            commentType = "IS";

                        if (className.startsWith("QS.H"))
                            commentType = "Hifdh";

                        if (className.startsWith("QS.Q"))
                            commentType = "Quran";

                        if (className.startsWith("QS.K") || className.startsWith("QS.R") || className.startsWith("KS") || className.startsWith("QS.Y1"))
                            commentType = "Kaidah";

                        Thread.sleep(1000);
                        driver.findElement(By.xpath("//*[@id='gibbonCourseClassID']/following::input")).click();

                        // set data for all attributes

                        try {

                            int t = driver.findElements(By.xpath("//img[@title='Enter Data']")).size();
                            // do it by term
                            // int t = driver.findElements(By.xpath("//*[@title='Enter Data']/preceding::span[text()='AUTUMN TERM']")).size();

                            if (t > 0) {

                                for (int s = 1; s <= t; s++) {

                                    Select selectCourse = new Select(driver.findElement(By.id("gibbonCourseClassID")));
                                    selectCourse.selectByValue(val);
                                    driver.findElement(By.xpath("//*[@id='gibbonCourseClassID']/following::input")).click();
                                    Thread.sleep(1000);


                                    String dataRow = driver.findElement(By.xpath("(//img[@title='Enter Data'])[" + s + "]/../../../td[1]")).getText();

                                    driver.findElement(By.xpath("(//img[@title='Enter Data'])[" + s + "]")).click();


                                    // set the results

                                    // int studentCount = driver.findElements(By.xpath("//*[text()='Assessment Details']/following::select")).size();

                                    int studentCount = driver.findElements(By.xpath("//*[text()='Assessment Details']/following::textarea")).size();


                                    for (int h = 1; h <= studentCount; h++) {

                                     /*
                                    int lowerBound = 1;
                                    int upperBound = 3;

                                   if( !commentType.contains("IS") {

                                        Select studentAttainment = new Select(driver.findElement(By.xpath("//*[@id='" + h + "-attainmentValue']")));
                                        upperBound = studentAttainment.getOptions().size() - 1;
                                    }


                                    Random random = new Random();
                                    int randomNumber = random.nextInt(upperBound - lowerBound) + lowerBound;

                                   // studentAttainment.selectByIndex(randomNumber);

                                   */


                                        String comment = "";


                                        if (commentType.equals("Hifdh")) {
                                            comment = "TEST SCORE\r\n==================\r\nX out of 30\r\n\r\n\r\n==================\r\nATTAINMENT GRADE\r\n==================\r\nA*(30-29) \r\nA (28-26)\r\nB (25-23)\r\nC (22-20)\r\nR (19-1)\r\n\r\n==================\r\nATTENDANCE\r\n==================\r\nMeeting Expectation\r\nBelow Expectation\r\n\r\n==================\r\nBEHAVIOUR/ATTITUDE\r\n==================\r\nOutstanding\r\nExcellent\r\nGood\r\nSatisfactory\r\nNeeds Improvement\r\n\r\n==================\r\nHOMEWORK\r\n==================\r\nOutstanding\r\nExcellent\r\nGood\r\nSatisfactory\r\nNeeds Improvement\r\n\r\n\r\nCOMMENT\r\n================== \r\n\r\n\r\n\r\n";


                                        }

                                        if (commentType.equals("IS")) {
                                            comment = "LESSON ENGAGEMENT\r\n==================\r\nOutstanding\r\nExcellent\r\nGood\r\nSatisfactory\r\nNeeds Improvement\r\n\r\n\r\n==================\r\nATTENDANCE\r\n==================\r\nMeeting Expectation\r\nBelow Expectation \r\n\r\n\r\n==================\r\nBEHAVIOUR/ATTITUDE\r\n==================\r\nOutstanding\r\nExcellent\r\nGood\r\nSatisfactory\r\nNeeds Improvement\r\n\r\n\r\n==================\r\nCOMMENT\r\n==================\r\n\r\n\r\n";

                                        }

                                        if (commentType.equals("Quran")) {
                                            comment = "ATTAINMENT GRADE\r\n==================\r\nA*(30-29) \r\nA (28-26)\r\nB (25-23)\r\nC (22-20)\r\nR (19-1)\r\n\r\n==================\r\nATTENDANCE\r\n==================\r\nMeeting Expectation\r\nBelow Expectation\r\n\r\n\r\n==================\r\nBEHAVIOUR/ATTITUDE\r\n==================\r\nOutstanding\r\nGood\r\nSatisfactory\r\nNeeds Improvement\r\n\r\n==================\r\nHOMEWORK\r\n==================\r\nOutstanding\r\nExcellent\r\nGood\r\nSatisfactory\r\nNeeds Improvement\r\n\r\n==================\r\nCOMMENT\r\n==================  \r\n\r\n\r\n";

                                        }

                                        if (commentType.equals("Kaidah")) {
                                            comment = "TEST SCORE\r\n==================\r\nX out of 30\r\n\r\n\r\n==================\r\nATTAINMENT GRADE\r\n==================\r\nA*    (30-29) \r\nA     (28-26)\r\nB     (25-23)\r\nC     (22-20)\r\nR     (19-1)\r\n\r\n\r\n==================\r\nATTENDANCE\r\n==================\r\nMeeting Expectation\r\nBelow Expectation\r\n\r\n==================\r\nBEHAVIOUR/ATTITUDE\r\n==================\r\nOutstanding\r\nExcellent\r\nGood\r\nSatisfactory\r\nNeeds Improvement\r\n\r\n\r\n==================\r\nHOMEWORK\r\n==================\r\nOutstanding\r\nExcellent\r\nGood\r\nSatisfactory\r\nNeeds Improvement \r\n\r\n==================\r\nCOMMENT\r\n==================\r\n\r\n\r\n\r\n";
                                        }

                                        if (dataRow.contains("EOY Student Status"))
                                            comment = "";


                                        driver.findElement(By.id("comment" + h)).sendKeys(comment);

                                    }


                                    driver.findElement(By.id("completeDate")).sendKeys("10/12/2021");

                                    driver.findElement(By.xpath("//input[@value='Submit']")).click();
                                    driver.findElement(By.linkText("Manage Internal Assessments")).click();


                                }


                            }



                        } catch (Exception e) {
                            e.printStackTrace();
                            captureScreenshot(driver,"ScShot");
                        }

                        ClassesAlreadySet += val + ",";
                    }

//-comment out for single test
             //  }

            }

        }




    }

/*

    @Then("^User typing a search query$")
    public void userTypingSearchQuery() throws InterruptedException, ScriptException {




        WebDriver driver =  TestBase.getDriver();

        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("Wise");

        driver.findElement(By.id("password")).sendKeys("W15eadmin");

        driver.findElement(By.xpath("//input[@value='Login']")).click();

        driver.findElement(By.linkText("ASSESS")).click();

        driver.findElement(By.linkText("Formal Assessment")).click();

        driver.findElement(By.linkText("Manage Internal Assessments")).click();


        driver.findElement(By.linkText("Add Multiple Columns")).click();


        String file = System.getProperty("user.dir")+ File.separator+ "classes.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int count =1;
            while ((line = br.readLine()) != null) {

                line = line.trim();
                System.out.println("Last Actioned Name: '" + line +"'" );


                // Test Score
                clearAndSelectClass(driver,line);
                setColumnValues(driver, "Spring Term", "Test Score", "Marks (1-30)", "Marks (1-30)");

                // Attendance Score
                clearAndSelectClass(driver,line);
                setColumnValues(driver, "Spring Term", "Attendance Score", "Attendance (1-5)", "Attendance (1-5)");

                // Behaviour Score
                clearAndSelectClass(driver,line);
                setColumnValues(driver, "Spring Term", "Behaviour Score", "Behaviour (1-5)", "Behaviour (1-5)");

                // Homework
                clearAndSelectClass(driver,line);
                setColumnValues(driver, "Spring Term", "Homework Score", "Homework (1-10)", "Homework (1-10)");



            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
*/

    @Then("^User typing a search query new$")
    public void userTypingSearchQueryNew() throws InterruptedException, ScriptException {




        WebDriver driver =  TestBase.getDriver();

        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("Wise");

        driver.findElement(By.id("password")).sendKeys("W15eadmin");

        driver.findElement(By.xpath("//input[@value='Login']")).click();

        driver.findElement(By.linkText("ASSESS")).click();

        driver.findElement(By.linkText("Formal Assessment")).click();

        driver.findElement(By.linkText("Manage Internal Assessments")).click();


        driver.findElement(By.linkText("Add Multiple Columns")).click();


        String file = System.getProperty("user.dir")+ File.separator+ "classes.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int count =1;
            while ((line = br.readLine()) != null) {

                line = line.trim();
                System.out.println("Last Actioned Name: '" + line +"'" );



               String classSelected  = driver.findElement(By.xpath("(//*[text()='Basic Information']/following::option[@value='" + line + "'])[1]")).getText();
               String gradeScale="";

               if(classSelected.startsWith("IS"))
                   gradeScale="IS Attainment";


               if(classSelected.startsWith("QS.H"))
                   gradeScale="Hifdh Attainment";

               if(classSelected.startsWith("QS.Q"))
                   gradeScale="Quran Marks (1-30)";

               if(classSelected.startsWith("QS.K") || classSelected.startsWith("KS.K")   )
                    gradeScale="Kaidah Attainment";

                if(classSelected.startsWith("KS.RM") || classSelected.startsWith("QS.RM") )
                    gradeScale="Reception Attainment";

                if(classSelected.startsWith("KS.Y1") || classSelected.startsWith("QS.Y1")  )
                    gradeScale="Year 1 Attainment";



                // Set Autumn
                clearAndSelectClass(driver,line);
               setColumnValues(driver, "AUTUMN TERM", gradeScale, gradeScale, gradeScale);

               /*
                // Set Spring
                clearAndSelectClass(driver,line);
                setColumnValues(driver, "SPRING TERM", gradeScale, gradeScale, gradeScale);

                // Set Spring Summer
                clearAndSelectClass(driver,line);
                setColumnValues(driver, "SUMMER TERM", gradeScale, gradeScale, gradeScale);

                // Set Final Status
                if(!classSelected.startsWith("IS")) {
                    clearAndSelectClass(driver, line);
                    setColumnValues(driver, "SUMMER TERM", "EOY Student Status", "EOY Student Status", "EOY Student Status");
                }
                */

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }



    }


    public void clearAndSelectClass(WebDriver driver, String line) {
        //clear the pre selected items
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(driver.findElement(By.id("gibbonCourseClassIDMulti")))
                .doubleClick()
                .build();
        mouseOverHome.perform();

        // add the
        Actions builder1 = new Actions(driver);
        Action mouseOverHome1 = builder1
                .moveToElement(driver.findElement(By.xpath("(//*[text()='Basic Information']/following::option[@value='" + line + "'])[1]")))
                .doubleClick()
                .build();
        mouseOverHome1.perform();
    }

    public void setColumnValues(WebDriver driver, String Term, String Name, String Desc, String GradeScale) {

        driver.findElement(By.id("name")).sendKeys(Name);
        driver.findElement(By.id("description")).sendKeys(Desc);

        Select selectType = new Select(driver.findElement(By.id("type")));
        selectType.selectByVisibleText(Term);

        Select selectScale = new Select(driver.findElement(By.id("gibbonScaleIDAttainment")));

        if(GradeScale.equals("IS Attainment"))
            driver.findElement(By.xpath("//input[@id='attainment1' and @value='N']")).click();
        else
            selectScale.selectByVisibleText(GradeScale);


        driver.findElement(By.id("effort1")).click();
        driver.findElement(By.id("uploadedResponse1")).click();

        driver.findElement(By.xpath("//input[@value='Submit']")).click();


    }





    @When("^User clicks search button$")
    public void userClicksSearchButton() {

        //logger.info("user clicks search button");

        TestBase
                .getDriver()
                .findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input"))
                .click();

//        delay();

        // fail this step to report screenshot to reportportal
        fail();
    }

    private void takeScreenshot(String message) {
        byte[] screenshot = ((TakesScreenshot) TestBase.getDriver()).getScreenshotAs(OutputType.BYTES);

       // logger.info("RP_MESSAGE#BASE64#{}#{}",
           //     BaseEncoding.base64().encode(screenshot),
             //   message);
    }

    private void delay() {

        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static String captureScreenshot (WebDriver driver, String screenshotName){

        try {
            TakesScreenshot ts = (TakesScreenshot)driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String dest = "/Users/CD6255ABQA/Desktop/Debug Images/" + screenshotName + ".png";

            String file = System.getProperty("user.dir")+ File.separator+ "screenshots" + File.separator+ screenshotName + ".png";
            File destination = new File(dest);
            Files.copy(source, destination);

           // FileUtils.copyFile(source, destination);
            return dest;
        }

        catch (IOException e) {return e.getMessage();}
    }
}
