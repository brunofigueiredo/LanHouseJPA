/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.validators;

/**
 *
 * @author bruno_figueiredo
 */
public class Validadores {
    
     public static boolean SoNumeros(String texto) {
        for (char letra : texto.toCharArray()) {
            if (letra < '0' || letra > '9') {
                return false;
            }
        }
        return true;

    }


    public static boolean verificaAno(String texto) {
        if (texto.length() != 4) {
            return false;
        } else {
            for (char letra : texto.toCharArray()) {
                if (letra < '0' || letra > '9') {
                    return false;
                }
            }
        }
        return true;
    }
}
    

