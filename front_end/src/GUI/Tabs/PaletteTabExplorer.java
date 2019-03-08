package GUI.Tabs;

import GUI.Palettes.Palette;
import GUI.Palettes.PaletteElement;
import GUI.Turtle.DisplayView;
import GUI.Turtle.BasicTurtleView;
import GUI.Turtle.AdvancedTurtleView;
import GUI.Turtle.CuteTurtleView;
import GUI.Turtle.GitLabView;
import javafx.scene.control.Tab;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class PaletteTabExplorer extends TabExplorer {

    private Palette<Rectangle> myColorPalette;
    private Palette<DisplayView> myTurtlePalette;
    private static final int FIRST_INDEX = 1;
    private static final int SECOND_INDEX = 2;
    private static final int THIRD_INDEX = 3;
    private static final int FOURTH_INDEX = 4;
    public static final int COLOR_PALETTE_WIDTH = 250;
    public static final int COLOR_PALETTE_HEIGHT = 50;
//    public static final List<DisplayView> TURTLE_SHAPES = List.of(new BasicTurtleView(), new AdvancedTurtleView(),
//            new CuteTurtleView(), new GitLabView());
//    public static final List<Color> PALETTE_COLORS = List.of()

    public PaletteTabExplorer(){
        createColorPalette();
        createTurtlePalette();
        Tab turtleTab = new Tab("Turtle Palette", myTurtlePalette);
        Tab colorTab = new Tab("Color Palette", myColorPalette);
        getTabs().addAll(turtleTab, colorTab);
    }

    private void createTurtlePalette(){
        myTurtlePalette = new Palette<>();
        myTurtlePalette.addPaletteElement(new PaletteElement<>(FIRST_INDEX, new BasicTurtleView()));
        myTurtlePalette.addPaletteElement(new PaletteElement<>(FOURTH_INDEX, new GitLabView()));
        myTurtlePalette.addPaletteElement(new PaletteElement<>(THIRD_INDEX, new CuteTurtleView()));
        myTurtlePalette.addPaletteElement(new PaletteElement<>(SECOND_INDEX, new AdvancedTurtleView()));
    }

    private void createColorPalette() {
        myColorPalette = new Palette<>();
        myColorPalette.addPaletteElement(new PaletteElement<>(FIRST_INDEX, new Rectangle(COLOR_PALETTE_WIDTH, COLOR_PALETTE_HEIGHT, Color.BLUE)));
        myColorPalette.addPaletteElement(new PaletteElement<>(FOURTH_INDEX, new Rectangle(COLOR_PALETTE_WIDTH, COLOR_PALETTE_HEIGHT, Color.ORANGE)));
        myColorPalette.addPaletteElement(new PaletteElement<>(SECOND_INDEX, new Rectangle(COLOR_PALETTE_WIDTH, COLOR_PALETTE_HEIGHT, Color.GREEN)));
        myColorPalette.addPaletteElement(new PaletteElement<>(THIRD_INDEX, new Rectangle(COLOR_PALETTE_WIDTH, COLOR_PALETTE_HEIGHT, Color.PINK)));
    }

    public Palette<Rectangle> getMyColorPalette() {
        return myColorPalette;
    }

    public Palette<DisplayView> getMyTurtlePalette() {
        return myTurtlePalette;
    }
}
