/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apuestas;
/**
 * @version 22/02/2023
 * @author Emiliano
 */

public class Apuesta {

    /**
     * @return devuelve los goles de local
     */
    public int getGoles_local() {
        return goles_local;
    }

    /**
     * @param goles_local asigna los goles marcados de local
     */
    public void setGoles_local(int goles_local) {
        this.goles_local = goles_local;
    }

    /**
     * @return devuelve los goles marcados de visitante
     */
    public int getGoles_visitante() {
        return goles_visitante;
    }

    /**
     * @param goles_visitante asigna los goles marcados de visitante
     */
    public void setGoles_visitante(int goles_visitante) {
        this.goles_visitante = goles_visitante;
    }

    /**
     * @return devuelve la cantidad apostada
     */
    public int getApostado() {
        return apostado;
    }

    /**
     * @param apostado asigna la cantidad de dinero apostada
     */
    public void setApostado(int apostado) {
        this.apostado = apostado;
    }

    /**
     * Estos son los atributos de la clase Apuesta
     */
    private int dinero_disp;
    private int goles_local;
    private int goles_visitante;
    private int apostado;

    /*Contructor por defecto*/
    /**
     * Es el constructor de la clase Apuesta
     */
    public Apuesta() {
    }
/**
 * Constructor de la clase Apuesta para asignar los atributos de la propia clase
 * @param dinero_disp parametro de dinero apostado
 * @param goles_local goles marcados de local
 * @param goles_visitante  goles marcados de visitante
 */
    /*Contructor por parámetros*/
    public Apuesta(int dinero_disp, int goles_local, int goles_visitante) {
        this.dinero_disp = dinero_disp;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
        this.apostado = 0;
    }
    /*Método para obtener el valor del atributo dinero_disp*/
/**
 * 
 * @return metodo que devuelve la cantidad de dinero apostada
 */
    public int getDinero_disp() {
        return dinero_disp;
    }
    
/**
 * metodo que modifica el valor del atributo dinero
 * @param dinero_disp  parametro de entrada del dinero apostado
 */
    public void setDinero_disp(int dinero_disp) {
        this.dinero_disp = dinero_disp;
    }

  
    /**
     * Método para apostar.
     * Permite elegir la cantidad a apostar, no pudiendo ser inferior a 1 ni superior a tu saldo disponible
     * @param dinero cantidad de dinero apostado
     * @throws Exception 
     */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1€");
        }

        if (dinero > getDinero_disp()) {
            throw new Exception("No se puede apostar mas de lo que tienes");
        }
        {
            setDinero_disp(dinero - getDinero_disp());
            setApostado(dinero);
        }
    }
  
    
/**
 * Método que comprueba si se ha acertado el resultado del partido
     * En caso de que lo haya acertado devuelve true. Chequea que no se metan menos de 0 goles
 * @param local 
 * @param visitante
 * @return devuelve verdadero cuando la apuesta es ganadora
 * @throws Exception 
 */
    public boolean comprobar_resultado(int local, int visitante) throws Exception {
        boolean acertado = false;
        if ((local < 0) || (visitante) < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (getGoles_local() == local && getGoles_visitante() == visitante) {
            acertado = true;
        }
        return acertado;
    }
  
/**
 *  Método para cobrar la apuesta.
     * Comprueba que se acertó el resultado y, en ese caso, añade el valor apostado multiplicado por 10
     * al saldo disponible
     * Este método se va a probar con Junit
 * @param cantidad_goles_local parametro de los goles anotados de local
 * @param cantidad_goles_visit parametro de los goles anotados de visitante
 * @throws Exception 
 */
    void cobrar_apuesta(int cantidad_goles_local, int cantidad_goles_visit) throws Exception {

        if (comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == false) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        setDinero_disp(getDinero_disp() * 10);

    }
}