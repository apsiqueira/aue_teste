/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.testeestagio.util;

import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBase;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author power
 */
public class  Utilitarios {

    //limpar tela universal
    public void limpaTela(JPanel container) {

        Component components[] = container.getComponents();

        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText(null);

            }
        }

    }
    
    
    public  void habilitarEdicao(JPanel container){
      
       Component listaComponents[]=container.getComponents();
      
        
       for(Component component:listaComponents){
         if(component instanceof JTextField){
         ((JTextField) component).setEditable(true);
         }
       
       }
    
    
    }
    
     public  void desabilitarEdicao(JPanel container){
      
       Component listaComponents[]=container.getComponents();
      
        
       for(Component component:listaComponents){
         if(component instanceof JTextField){
         ((JTextField) component).setEditable(false);
         }
       
       }
    
    
    }

    public static boolean consegueConectar(String address) {
        try {
            URL url = new URL(address);
            URLConnection connection = url.openConnection();
            connection.connect();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
