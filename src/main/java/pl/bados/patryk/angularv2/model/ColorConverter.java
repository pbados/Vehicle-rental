package pl.bados.patryk.angularv2.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ColorConverter implements AttributeConverter<Color, String> {

    @Override
    public String convertToDatabaseColumn(Color attribute) {
        switch (attribute) {
            case BLUE:
                return "blue";
            case RED:
                return "red";
            case WHITE:
                return "white";
            case BLACK:
                return "black";
            case GREEN:
                return "green";
            case YELLOW:
                return "yellow";
            case ORANGE:
                return "orange";
            case BROWN:
                return "brown";
            case GREY:
                return "grey";
            default:
                throw new IllegalArgumentException("Unknown" + attribute);
        }
    }

    @Override
    public Color convertToEntityAttribute(String dbData) {
        //konstrutor enuma
        switch (dbData) {
            case "blue":
                return Color.BLUE;
            case "red":
                return Color.RED;
            case "white":
                return Color.WHITE;
            case "black":
                return Color.BLACK;
            case "green":
                return Color.GREEN;
            case "yellow":
                return Color.YELLOW;
            case "orange":
                return Color.ORANGE;
            case "brown":
                return Color.BROWN;
            case "grey":
                return Color.GREY;
            default:
                throw new IllegalArgumentException("Unknown" + dbData);
        }
    }
}
