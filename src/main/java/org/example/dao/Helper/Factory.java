package org.example.dao.Helper;

import org.example.dao.Type.Paragraph;
import org.example.dao.Type.Text;

public class Factory {
    private static Text tempText = new Text();
    private static Paragraph tempParagraph = new Paragraph();

    public static Text createNewText() {
        tempText = null;
        tempText = new Text();
        return tempText;
    }

    public static Paragraph createNewParagraph() {
        tempParagraph = null;
        tempParagraph = new Paragraph();
        return tempParagraph;
    }

    public static Object createSpecialFieldValue(Class<?> fieldType, String value) {
        if (fieldType.equals(Text.class)) return createNewText().set(value);
        else if (fieldType.equals(Paragraph.class)) return createNewParagraph().set(value);
        else throw new IllegalArgumentException("Invalid special field type");
    }

}
