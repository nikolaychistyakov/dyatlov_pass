package com.xyc;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EndTest {

    @Test
    public void endActTest() throws IOException {

        try (WebClient webClient = new WebClient()) {


            HtmlPage page = webClient.getPage("http://localhost:8080/choiceAct?act=6&action=next&form_button=");

            HtmlForm form_go = page.getFormByName("form_go");
            List<HtmlRadioButtonInput> fieldset = form_go.getRadioButtonsByName("action");

            for (int i = 0; i < fieldset.size(); i++) {
                HtmlRadioButtonInput htmlRadioButtonInput = fieldset.get(i);
                if (htmlRadioButtonInput.getId().equals("next")) {
                    assertTrue(htmlRadioButtonInput.isChecked());

                    HtmlButton form_button = form_go.getButtonByName("form_button");
                    Page pageAfterClickWithNext = form_button.click();

                    assertEquals("http://localhost:8080/choiceAct?act=7&action=next&form_button=",
                            pageAfterClickWithNext.getUrl().toString());
                }
            }
        }
    }

    @Test
    public void startAfterEndActTest() throws IOException {
        try (WebClient webClient = new WebClient()) {

            HtmlPage pageAct6 = webClient.getPage("http://localhost:8080/choiceAct?act=6&action=next&form_button=");

            HtmlForm formAct6 = pageAct6.getFormByName("form_go");
            List<HtmlRadioButtonInput> radioButtonsAct6 = formAct6.getRadioButtonsByName("action");

            for (int i = 0; i < radioButtonsAct6.size(); i++) {
                HtmlRadioButtonInput htmlRadioButtonInput = radioButtonsAct6.get(i);
                if (htmlRadioButtonInput.getId().equals("next")) {
                    assertTrue(htmlRadioButtonInput.isChecked());

                    HtmlButton form_button = formAct6.getButtonByName("form_button");
                    HtmlPage pageAct7 = form_button.click();

                    assertEquals("http://localhost:8080/choiceAct?act=7&action=next&form_button=",
                            pageAct7.getUrl().toString());

                    HtmlElement desc_end = pageAct7.getHtmlElementById("desc_end");
                    assertEquals("\n" +
                            "            1 февраля 1959 вся тургруппа Дятлова погибает.\n" +
                            "        ", desc_end.getTextContent());

                    HtmlForm formAct7 = pageAct7.getFormByName("form_go");
                    HtmlButton buttonAct7 = formAct7.getButtonByName("form_button");
                    Page click = buttonAct7.click();

                    assertEquals("http://localhost:8080/startNew?form_button=", click.getUrl().toString());

                }
            }
        }
    }
}
