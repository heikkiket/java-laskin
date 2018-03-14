package Calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private TextField outputTxt;
    @FXML
    private Text resultTxt;


    @FXML
    private void proccesNum(ActionEvent event){
        outputTxt.requestFocus();
        outputTxt.setStyle("-fx-display-caret: false;");
        String value=((Button)event.getSource()).getText();
        String output=outputTxt.getText();
        String id=((Button)event.getSource()).getId();

        if (output.equals("0")){outputTxt.setText("");output="";} //To start removing leading zero

        resultTxt.setText(id);
        outputTxt.setText(output+value);
    }

    @FXML
    private void proccessOperator (ActionEvent event){

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
        outputTxt.setStyle("-fx-display-caret: true;");
    }
}
