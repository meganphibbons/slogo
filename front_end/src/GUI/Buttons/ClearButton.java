package GUI.Buttons;

import GUI.Commands.CommandExecutable;
import GUI.Commands.Language;
import GUI.Commands.LanguageChangeable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.function.Consumer;

public class ClearButton extends Button implements CommandExecutable, LanguageChangeable {

    private static final String CLEAR_BUTTON_NAME = "Clear";
    public static final String CLEAR_SCREEN = "ClearScreen";
    private Consumer<String> myCommandAccess;
    private Language myLanguage;

    /**
     * Constructor for the clear button.  The ClearButton needs access to the commandline because it needs to be able
     * to clear the text in the commandline
     * @param commandLine access to the text area to be cleared when the clear button is pressed
     */
    public ClearButton(TextArea commandLine){
        this.setText(CLEAR_BUTTON_NAME);
        myLanguage = Language.ENGLISH;
        this.setOnAction(event -> {
            commandLine.setText("");
            runCommand(CLEAR_SCREEN);
        });
    }

    @Override
    public void giveAbilityToRunCommands(Consumer<String> commandAccess) {
        myCommandAccess = commandAccess;
    }

    @Override
    public void runCommand(String command) {
        myCommandAccess.accept(myLanguage.getTranslatedWord(command));
    }

    @Override
    public void setLanguage(Language newLanguage) {
        myLanguage = newLanguage;
        setText(newLanguage.getTranslatedWord(CLEAR_BUTTON_NAME));
    }

    //TODO: If never used, remove
    public String getMyName(){
        return CLEAR_BUTTON_NAME;
    }
}
