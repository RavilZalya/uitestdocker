import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
class ContainerStartedOnceTest {

    @Container
    private static final BrowserWebDriverContainer BROWSER_CONTAINER = new BrowserWebDriverContainer()
            .withCapabilities((new ChromeOptions().setHeadless(true)));

    private static WebDriver browser;

    @BeforeAll
    static void configureBrowser() {
        browser = BROWSER_CONTAINER.getWebDriver();
    }

    @Test
    @DisplayName("The testproject.io web site should have the correct title")
    void testProjectWebSiteShouldHaveCorrectTitle() {
        browser.get("https://www.yahoo.com");
        System.out.println("==================================================================");
        System.out.println(browser.getTitle());
        System.out.println("==================================================================");
        browser.get("https://www.yandex.ru");
        System.out.println("==================================================================");
        System.out.println(browser.getTitle());
        System.out.println("==================================================================");
        browser.get("https://www.ad-juster.com");
        System.out.println("==================================================================");
        System.out.println(browser.getTitle());
        System.out.println("==================================================================");
        browser.get("https://www.cnn.com");
        System.out.println("==================================================================");
        System.out.println(browser.getTitle());
        System.out.println("==================================================================");
        browser.get("https://www.testproject.io");
        System.out.println("==================================================================");
        System.out.println(browser.getTitle());
        System.out.println("==================================================================");
        assertThat(browser.getTitle())
                .isEqualTo("Community Powered Test Automation – TestProject");
    }

    @Test
    @DisplayName("The testproject.io blog should have the correct title")
    void testProjectBlogShouldHaveCorrectTitle() {
        browser.get("https://blog.testproject.io/");
        System.out.println("==================================================================");
        System.out.println(browser.getTitle());
        System.out.println("==================================================================");
        assertThat(browser.getTitle())
                .isEqualTo("TestProject - Test Automation Blog");
    }

}
