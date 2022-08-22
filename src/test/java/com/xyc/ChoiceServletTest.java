package com.xyc;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChoiceServletTest {


    @Test
    public void choiceActsTest() throws IOException {

        try (WebClient webClient = new WebClient()) {

            HtmlPage page = webClient.getPage("http://localhost:8080/go?name=kolya");

            HtmlElement desc_before = page.getHtmlElementById("desc_before");
            assertEquals("\n" +
                    "                25 января 1959 Вы в составе группы Дятлова прибыли в Ивдель, потом на автобусе в пос. Вижай и остались там на ночёвку.\n" +
                    "            ", desc_before.getTextContent());

            HtmlElement desc_after = page.getHtmlElementById("desc_after");
            assertEquals("\n" +
                    "                26 января 1959Вам нужно отправиться на грузовике до пос.41-й участок (квартал) и остаться там на ночёвку.\n" +
                    "            ", desc_after.getTextContent());


            HtmlForm form_go = page.getFormByName("form_go");
            List<HtmlRadioButtonInput> fieldset = form_go.getRadioButtonsByName("action");

            for (int i = 0; i < fieldset.size(); i++) {
                HtmlRadioButtonInput htmlRadioButtonInput = fieldset.get(i);
                if (htmlRadioButtonInput.getId().equals("next")) {
                    assertTrue(htmlRadioButtonInput.isChecked());

                    HtmlButton form_button = form_go.getButtonByName("form_button");
                    Page pageAfterClickWithNext = form_button.click();

                    assertEquals("http://localhost:8080/choiceAct?act=1&action=next&form_button=",
                            pageAfterClickWithNext.getUrl().toString());

                }

            }

            for (int i = 0; i < fieldset.size(); i++) {
                HtmlRadioButtonInput htmlRadioButtonInput = fieldset.get(i);
                if (htmlRadioButtonInput.getId().equals("void")) {
                    htmlRadioButtonInput.setChecked(true);
                    assertTrue(htmlRadioButtonInput.isChecked());

                    HtmlButton form_button = form_go.getButtonByName("form_button");
                    Page pageAfterClickWithNext = form_button.click();

                    assertEquals("http://localhost:8080/choiceAct?act=1&action=void&form_button=",
                            pageAfterClickWithNext.getUrl().toString());
                }
            }

            for (int i = 0; i < fieldset.size(); i++) {
                HtmlRadioButtonInput htmlRadioButtonInput = fieldset.get(i);
                if (htmlRadioButtonInput.getId().equals("back")) {
                    htmlRadioButtonInput.setChecked(true);
                    assertTrue(htmlRadioButtonInput.isChecked());

                    HtmlButton form_button = form_go.getButtonByName("form_button");
                    Page pageAfterClickWithNext = form_button.click();

                    assertEquals("http://localhost:8080/choiceAct?act=1&action=back&form_button=",
                            pageAfterClickWithNext.getUrl().toString());
                }
            }


        }

    }


}