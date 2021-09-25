package ui;

import java.awt.*;

public class InterfaceTools {
    // Dimensiones utilizadas para los componentes
    private final Dimension dimensionPanelField = new Dimension(300, 30);
    private final Dimension dimensionLabelField = new Dimension(90, 25);
    private final Dimension dimensionTextField = new Dimension(80, 25);


    // Valores para formato interfaz
    private final Color colorOne = new Color(86, 116, 153);
    private final Color colorTwo = new Color(226, 44, 93);
    private final Color colorThree = new Color(30, 42, 72);
    private final Color colorFour = new Color(255, 255, 255);
    private final Font fontLabel= new Font("Arial",Font.BOLD,12);

    public Dimension getDimensionPanelField() {
        return dimensionPanelField;
    }

    public Dimension getDimensionLabelField() {
        return dimensionLabelField;
    }


    public Dimension getDimensionTextField() {
        return dimensionTextField;
    }

    public Color getColorOne() {
        return colorOne;
    }

    public Color getColorTwo() {
        return colorTwo;
    }

    public Color getColorThree() {
        return colorThree;
    }

    public Color getColorFour() {
        return colorFour;
    }

    public Font getFontLabel() {
        return fontLabel;
    }

    public InterfaceTools() {
    }
}
