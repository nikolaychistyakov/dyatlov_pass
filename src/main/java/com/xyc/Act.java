package com.xyc;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Act {
    int id;
    String image;
    String titleAct;
    String titleBefore;
    String titleAfter;
    List<String> descAction;
}
