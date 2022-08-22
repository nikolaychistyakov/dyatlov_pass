package com.xyc;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IndexServletTest {
    @Test
    public void homeStartPageTest() throws IOException {
        try (final WebClient webClient = new WebClient()) {

            HtmlPage htmlPage = webClient.getPage("http://localhost:8080/start");
            assertEquals("Dyatlov Pass", htmlPage.getTitleText());

            HtmlElement desc_start = htmlPage.getHtmlElementById("desc_start");
            assertEquals("23 января 1959 года группа туристов во главе\n" +
                    "                с Игорем Дятловым отправилась в поход по Уральским горам,\n" +
                    "                из которого никто не вернулся. Смерть девяти туристов стала одной из загадок века.\n" +
                    "            ", desc_start.getTextContent());

            HtmlElement desc_go_start = htmlPage.getHtmlElementById("desc_go_start");
            assertEquals("\n" +
                    "                Отправляйся в гущу событий и узнай, что там произошло\n" +
                    "            ", desc_go_start.getTextContent());

            HtmlForm startForm = htmlPage.getFormByName("form_go");

            HtmlInput name = startForm.getInputByName("name");
            assertEquals("Ваше имя", name.getPlaceholder());

            HtmlButton start_button = startForm.getButtonByName("start_button");
            Page pageAfterClickOnStartButtonWithoutName = start_button.click();

            URL url = pageAfterClickOnStartButtonWithoutName.getUrl();
            assertEquals("http://localhost:8080/start", url.toString());

            name.setValue("Kolya");
            Page pageAfterClickOnStartButtonWithName = start_button.click();
            URL url2 = pageAfterClickOnStartButtonWithName.getUrl();
            assertEquals("http://localhost:8080/go?name=Kolya&start_button=", url2.toString());


        }


    }

}