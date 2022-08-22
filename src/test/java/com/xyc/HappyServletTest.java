package com.xyc;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HappyServletTest {

    @Test
    public void checkBackTest() throws IOException {

        try(WebClient webClient = new WebClient()) {

            HtmlPage page = webClient.getPage("http://localhost:8080/go?name=admin&start_button=");
            HtmlForm form_go = page.getFormByName("form_go");
            List<HtmlRadioButtonInput> fieldset = form_go.getRadioButtonsByName("action");

            for (int i = 0; i < fieldset.size(); i++) {
                HtmlRadioButtonInput htmlRadioButtonInput = fieldset.get(i);
                if (htmlRadioButtonInput.getId().equals("back")) {
                    htmlRadioButtonInput.setChecked(true);
                    assertTrue(htmlRadioButtonInput.isChecked());

                    HtmlButton form_button = form_go.getButtonByName("form_button");
                    HtmlPage pageAfterClickWithNextAndVoid = form_button.click();

                    assertEquals("http://localhost:8080/choiceAct?act=1&action=back&form_button=",
                            pageAfterClickWithNextAndVoid.getUrl().toString());

                    HtmlElement desc_die = pageAfterClickWithNextAndVoid.getHtmlElementById("desc_happy");
                    assertEquals("\n" +
                            "          HAPPY END\n" +
                            "        ", desc_die.getTextContent());

                    HtmlForm form_die = pageAfterClickWithNextAndVoid.getFormByName("form_go");
                    HtmlButton form_button_die = form_die.getButtonByName("form_button");
                    HtmlPage clickOnButtonDieServlet = form_button_die.click();
                    URL url = clickOnButtonDieServlet.getUrl();
                    assertEquals("http://localhost:8080/startNew?form_button=", url.toString());

                }
            }



        }

    }

}