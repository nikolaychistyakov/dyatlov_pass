package com.xyc;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InitActsTest {


    @Test
    public void checkActTest() {

        Map<String, Act> acts = InitActs.getActs();

        assertEquals("25 января 1959<br> " +
                        "Вы в составе группы Дятлова прибыли в Ивдель, потом на автобусе в пос. " +
                        "Вижай и остались там на ночёвку.",
                acts.get("1").getTitleBefore());

    }

}