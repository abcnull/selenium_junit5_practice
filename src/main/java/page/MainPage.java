package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * @author abcnull@qq.com
 * @version 1.0.0
 * @date 2020/6/10 20:15
 */
public class MainPage extends BasePage {
    /**
     * 无参构造器
     */
    public MainPage() throws IOException, ParseException {
        super();
        driver.get("https://work.weixin.qq.com/wework_admin/frame#index");
        // 登录操作

        // 写入 cookie 操作
//        FileWriter fileWriter = new FileWriter("src\\main\\resources\\cookies.txt");
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//        for (Cookie cookie : driver.manage().getCookies()) {
//            bufferedWriter.write(
//                    cookie.getName() + ";" +
//                            cookie.getValue() + ";" +
//                            cookie.getDomain() + ";" +
//                            cookie.getPath() + ";" +
//                            cookie.getExpiry() + ";" +
//                            cookie.isSecure()
//            );
//            bufferedWriter.newLine();
//        }
//        bufferedWriter.close();


        // 从文件读取 cookie 操作
//        FileReader fileReader = new FileReader("src\\main\\resources\\cookies.txt");
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        String line;
//        while ((line = bufferedReader.readLine()) != null) {
//            StringTokenizer stringTokenizer = new StringTokenizer(line, ";");
//            String name = stringTokenizer.nextToken();
//            String value = stringTokenizer.nextToken();
//            String domain = stringTokenizer.nextToken();
//            String path = stringTokenizer.nextToken();
//            Date expiry = null;
//            String tmp = stringTokenizer.nextToken();
//            if (!tmp.equals("null")) {
//                SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
//                expiry = sdf.parse(tmp);
//            }
//            boolean isSecure = Boolean.valueOf(stringTokenizer.nextToken());
//            Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure);
//            driver.manage().addCookie(cookie);
//        }
        Cookie cookie = new Cookie("wwrtx.sid", "S9BUd1hBU6ym7asrX2oUgBW4HJlIq9L1ez3pEmFUjeJxbhM-6nCJbtfNUVFu80_B");
        driver.manage().addCookie(cookie);
        driver.get("https://work.weixin.qq.com/wework_admin/frame#index");
    }

    /**
     * 转到联系人页
     */
    public void getToContact() {
        clickButton(By.linkText("通讯录"));
    }
}
