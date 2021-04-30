/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import javax.naming.CommunicationException;

/**
 *
 * @author mfarias
 */
class Cliente {
    private String nombre;
    private String rot;

    Cliente(String n,String rot) {
        setNombre(n);
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() throws CommunicationException {       
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public String getRot() {
		return rot;
	}

	public void setRot(String rot) {
		this.rot = rot;
	}




}
