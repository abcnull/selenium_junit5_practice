package testcase;

import org.junit.jupiter.api.*;
import page.ContactPage;
import page.MainPage;

import java.io.IOException;
import java.text.ParseException;

/**
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/6/10 20:18
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContactTest {
    private static MainPage mainPage;
    private static ContactPage contactPage;


    @BeforeAll
    public static void initPage() throws IOException, ParseException {
        mainPage = new MainPage();
        contactPage = new ContactPage(mainPage.driver);
        mainPage.getToContact();
    }

    @Order(1)
    @Test
    public void addDepartmentTest() {
        contactPage.addDepartment();
    }

    @Order(2)
    @Test
    public void deleteDepartmentTest() {
        contactPage.deleteDepartment();
    }

    @Order(3)
    @Test
    public void addLableTest() {
        contactPage.addLabel();
    }

    @Order(4)
    @Test
    public void deleteLableTest() {
        contactPage.deleteLabel();
    }

    @AfterAll
    public static void end() {
        contactPage.je.executeScript("alert('测试完成，浏览器即将关闭！')");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        contactPage.driver.quit();
    }
}
