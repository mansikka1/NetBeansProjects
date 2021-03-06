package wad.helloform;

import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.assertj.core.api.Assertions.assertThat;
import org.fluentlenium.adapter.FluentTest;
import static org.fluentlenium.core.filter.FilterConstructor.withName;
import static org.fluentlenium.core.filter.FilterConstructor.withText;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

@Points("7")
public class HelloFormTest extends FluentTest {

    public WebDriver webDriver = new HtmlUnitDriver();

    @Override
    public WebDriver getDefaultDriver() {
        return webDriver;
    }

    @ClassRule
    public static ServerRule server = new ServerRule();

    @Test
    public void titleChangesOnFormSubmit() {
        goTo("http://localhost:" + server.getPort() + "/");
        assertThat(pageSource()).doesNotContain("What did one computer say to the other?");
        assertThat(pageSource()).doesNotContain("010101101010101010101");

        fill("input[type=text]").with("What did one computer say to the other?");
        click("input[type=submit]");
        assertThat(title()).contains("What did one computer say to the other?");
    }

    @Test
    public void headerOneChangesOnFormSubmit() {
        goTo("http://localhost:" + server.getPort() + "/");
        assertThat(pageSource()).doesNotContain("What did one computer say to the other?");
        assertThat(pageSource()).doesNotContain("010101101010101010101");

        fill("input[type=text]").with("010101101010101010101");
        click("input[type=submit]");
        assertThat(find("h1", withText("010101101010101010101")).size() == 1);
    }

}
