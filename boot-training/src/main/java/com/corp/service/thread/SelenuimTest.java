package com.corp.service.thread;

public class SelenuimTest {
    public static void main(String[] args) {
        // 对象/变量的声明和实例化
        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        WebDriver driver = new ChromeDriver();
        //注释以上两行代码，取消下面两行代码的注释，以使用Chrome
        //System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();

        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // 启动Fire fox并将其指向基本URL
        driver.get(baseUrl);

        // 获取标题的实际值
        actualTitle = driver.getTitle();

        /*
         * 将页面的实际标题与预期标题进行比较并打印
         * 结果为“Passed”或“Failed”
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        //关闭浏览器
        driver.close();
    }
}
