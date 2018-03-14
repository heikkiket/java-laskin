package Calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Dmitri Tsyganok
 */

public class Controller {

    @FXML
    private TextField outputTxt;
    @FXML
    private TextArea resultTxt;
    
    Boolean newStart = true;



    @FXML
    private void proccesNum(ActionEvent event){
        newStart=false;
        outputTxt.requestFocus();
        //outputTxt.setStyle("-fx-display-caret: false;");
        String value=((Button)event.getSource()).getText();
        //String id=((Button)event.getSource()).getId();

        String output=clearstart();

        //resultTxt.setText(id);
        outputTxt.setText(output+value);
    }

    @FXML
    private void proccessSqrt (ActionEvent event) {
        String output=clearstart();
        outputTxt.setText(output+"sqrt(");
    }

    @FXML
    private void proccessOperator (ActionEvent event){
        resultTxt.setText(outputTxt.getText());
        String lauseke = outputTxt.getText();
        Lauseke kysymys = new Lauseke();
        kysymys.lueLauseke(lauseke);
        outputTxt.setText(String.valueOf(kysymys.laske()));
        newStart = true;
    }

    @FXML
    private void proccessClear(ActionEvent event) {
        outputTxt.setText("0");
    }

    @FXML
    private void proccessBack(ActionEvent event) {
        outputTxt.requestFocus();
        String valueOf=outputTxt.getText();
        if (valueOf.length()>1) {outputTxt.setText(valueOf.substring(0,valueOf.length()-1));}
        else {outputTxt.setText("0");}
    }

    @FXML
    private void proccessMC(ActionEvent event){
        resultTxt.setText("clicked");
        //outputTxt.setStyle("-fx-display-caret: true;");
    }
    @FXML
    private String clearstart(){
        //if(newStart) {proccessClear(ActionEvent);}
        String output=outputTxt.getText();
        if (output.equals("0")){outputTxt.setText("");output="";} //To start removing leading zero
        return (output);
    }

}
