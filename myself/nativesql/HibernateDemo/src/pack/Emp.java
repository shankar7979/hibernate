/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pack;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author shankar
 */
@Entity
public class Emp {
    @Id
    private int id;
    private String name;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }



}
