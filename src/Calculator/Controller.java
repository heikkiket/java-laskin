package Calculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author Dmitri Tsyganok
 */

public class Controller {

    @FXML
        private TextField outputTxt;
    @FXML
        private Text resultTxt;
    @FXML
        private VBox mainVBox;

    
    Boolean newStart = true;

    @FXML
    private void initialize(){

        mainVBox.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                //String ret= returnKey(event);
                //resultTxt.setText(event.getCode().toString()+ret);
                outputTxt.setText(clearStart()+returnKey(event));
                newStart=false;
            }
        });
        //mainVBox.requestFocus();
        resultTxt.requestFocus();
    }


    @FXML
    private void processNum(ActionEvent event){
        outputTxt.setText(clearStart()+((Button)event.getSource()).getText());
        newStart=false;
    }

    @FXML
    private void processOp(ActionEvent event){
        newStart=false;
        outputTxt.setText(clearStart()+((Button)event.getSource()).getId());
    }

    @FXML
    private void processEqual(ActionEvent event){
        String lauseke = outputTxt.getText();
        Lauseke kysymys = new Lauseke();
        kysymys.lueLauseke(lauseke);
        String vastaus=String.valueOf(kysymys.laske());
        outputTxt.setText(vastaus);
        newStart = true;
        resultTxt.setText(lauseke+" = "+vastaus);
    }

    @FXML
    private void processClear(ActionEvent event) {
        outputTxt.setText("0");
    }

    @FXML
    private void processBack(ActionEvent event) {
        String valueOf=outputTxt.getText();
        if (valueOf.length()>1) {outputTxt.setText(valueOf.substring(0,valueOf.length()-1));}
        else {outputTxt.setText("0");}
    }

    @FXML
    private void processMC(ActionEvent event){
        //resultTxt.setText("clicked");
    }
    @FXML
    private String clearStart(){
        String output=outputTxt.getText();
        if (output.equals("0")){outputTxt.setText("");output="";} //To start removing leading zero
        if (newStart) return (""); //Clear if new caclulation
        else return (output);
    }

    @FXML
    private String returnKey(KeyEvent event){
        switch (event.getCode()) {
            case PERIOD:
            case COMMA:
                return (".");
            case DIGIT0:
                return ("0");
            case DIGIT1:
                return ("1");
            case DIGIT2:
                return ("2");
            case DIGIT3:
                return ("3");
            case DIGIT4:
                return ("4");
            case DIGIT5:
                return ("5");
            case DIGIT6:
                return ("6");
            case DIGIT7:
                return ("7");
            case DIGIT8:
                return ("8");
            case DIGIT9:
                return ("9");
            case MINUS:
                return("-");
            case PLUS:
                return ("+");
            case BACK_SPACE:
                {
                    String valueOf = outputTxt.getText();
                    if (valueOf.length() > 1) {
                        outputTxt.setText(valueOf.substring(0, valueOf.length() - 1));
                    } else {
                        outputTxt.setText("0");
                    }
                    return ("");
                    }
            default:
                return ("");
        }
    }

}