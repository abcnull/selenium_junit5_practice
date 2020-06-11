package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/6/10 20:15
 */
public class ContactPage extends BasePage {
    // “+” 添加按钮
    By addButton = By.className("member_colLeft_top_addBtn");
    // “添加部门” 按钮
    By addDepartmentButton = By.linkText("添加部门");
    // 添加部门的名称
    By nameInput = By.name("name");
    // 选择部门
    By departmentInput = By.className("js_parent_party_name");
    // 具体部门
    By departmentButton = By.xpath("(//div[@role=\"tree\"])[2]//a");

    // 三个点
    By threePoints = By.xpath("(//span[@class=\"icon jstree-contextmenu-hover\"])[last()]");
    // 删除
    By deleteButton = By.xpath("(//a[contains(text(), \"删除\")])[last()]");

    // 标签
    By labelButton = By.xpath("//a[@href='#contacts/tag']");
    // 三个点
    By label3Points = By.className("ww_icon_MoreBlue");
    // 删除
    By deleteLabel = By.xpath("//a[@on-click='removeTag']");

    /**
     * 有参构造器
     *
     * @param driver 驱动
     */
    public ContactPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void addDepartment() {
        clickButton(addButton);
        clickButton(addDepartmentButton);
        sendKeys(nameInput, "1");
        clickButton(departmentInput);
        clickButton(departmentButton);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void deleteDepartment() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickButton(threePoints);
        clickButton(deleteButton);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void addLabel() {
        clickButton(labelButton);
        clickButton(addButton);
        sendKeys(nameInput, "1");
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void deleteLabel() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickButton(label3Points);
        clickButton(deleteLabel);
        actions.sendKeys(Keys.ENTER).perform();
    }
}
