
package Calculadora;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author braul
 */
public class CalculadoraController implements Initializable {

    @FXML
    private Label labPantalla;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    //BOTONES DE LA CALCULADORA
    @FXML
    private void clic_Siete(ActionEvent event) {
        digitoPantalla("7");
    }

    @FXML
    private void clic_Ocho(ActionEvent event) {
        digitoPantalla("8");
    }

    @FXML
    private void clic_Nueve(ActionEvent event) {
        digitoPantalla("9");
    }

    @FXML
    private void clic_Cuatro(ActionEvent event) {
        digitoPantalla("4");
    }

    @FXML
    private void clic_Cinco(ActionEvent event) {
        digitoPantalla("5");
    }

    @FXML
    private void clic_Seis(ActionEvent event) {
        digitoPantalla("6");
    }

    @FXML
    private void clic_Uno(ActionEvent event) {
        digitoPantalla("1");
    }

    @FXML
    private void clic_Dos(ActionEvent event) {
        digitoPantalla("2");
    }

    @FXML
    private void clic_Tres(ActionEvent event) {
        digitoPantalla("3");
    }

    @FXML
    private void clic_Cero(ActionEvent event) {
        digitoPantalla("0");
    }

    @FXML
    private void clic_Punto(ActionEvent event) {
        if(!Punto && !Digito){
            labPantalla.setText("0.");  
            Digito = true;
        }
        else if(!Punto){
            String valActual = labPantalla.getText();
            labPantalla.setText(valActual + ".");
        }
        Punto = false;
    }
    
    //VARIABLES ENVARGADAS DE MOSTRAR LOS RESULTADOS EN LA PANTALLA DE LA CALCULADORA
    private boolean Digito = false;
    private boolean Punto = false;
    private int numOperandos = 0;
    private double Operando1, Operando2;
    private char Operador = ' ';
    
    //METODO ENCARGADO DE PONER UN NÚMERO DENTRO DE LA PANTALLA
    private void digitoPantalla(String numero){
        if(!Digito && numero.equals("0"))
            return;
        
        if(!Digito){
            labPantalla.setText("");
            Punto = false;
        }
        
        String valActual = labPantalla.getText();
        labPantalla.setText(valActual + numero);
        Digito = true;
    }

    //BOTON AC DE LA CALCULADORA
    @FXML
    private void clic_Borrar(ActionEvent event) {
        Digito = false;
        Punto = false;
        numOperandos = 0;
        Operando1 = 0;
        Operando2 = 0;
        Operador = ' ';
        labPantalla.setText("0");
    }

    //BOTNO +/- DE LA CALCULADORA
    @FXML
    private void clic_Valor(ActionEvent event) {
        if(Digito)
            labPantalla.setText("-"+labPantalla.getText());
    }

    //BOTON % DE LA CALCULADORA
    @FXML
    private void clic_Porcentaje(ActionEvent event) {
        if(numOperandos==0){
            labPantalla.setText("0");
            return;
        }
        
        double valor = Double.parseDouble(labPantalla.getText());
        double porcentaje = (Operando1*valor)/100;
        labPantalla.setText(String.valueOf(porcentaje));
        Digito = true;
        Punto = true;
    }
    
    //METODOS DE LOS BOTONES DE LAS OPERACIONES DE LA CALCULADORA
    @FXML
    private void clic_Division(ActionEvent event) {
        valOperador("/");
    }

    @FXML
    private void clic_Multiplicacion(ActionEvent event) {
        valOperador("*");
    }

    @FXML
    private void clic_Resta(ActionEvent event) {
        valOperador("-");
    }

    @FXML
    private void clic_Suma(ActionEvent event) {
        valOperador("+");
    }

    @FXML
    private void clic_Igual(ActionEvent event) {
        valOperador("=");
    }
    
    //METODO ENCARGADO DE REALIZAR LAS OPERACIONES BASICAS
    private void valOperador(String Operador){
        if(Digito)
            numOperandos++;
        
        if(numOperandos==1)
            Operando1 = Double.parseDouble(labPantalla.getText());
        
        if(numOperandos==2){
            Operando2 = Double.parseDouble(labPantalla.getText());
            switch(this.Operador){
                case '+':
                    Operando1 = Operando1 + Operando2;
                    break;
                    
                case '-':
                    Operando1 = Operando1 - Operando2;
                    break; 
                    
                case '*':
                    Operando1 = Operando1 * Operando2;
                    break;  
                    
                case '/':
                    Operando1 = Operando1 / Operando2;
                    break;
                    
                case '=':
                    Operando1 = Operando1 = Operando2;
                    break;                    
            }
            labPantalla.setText(String.valueOf(Operando1));
            numOperandos = 1;
            Punto = false;
        }            
        Digito = false;
        this.Operador = Operador.charAt(0);
    }

    

   
}
