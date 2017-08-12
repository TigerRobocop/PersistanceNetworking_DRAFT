package com.tigerrobocop.liv.localpersistence.Model;

import java.io.Serializable;

/**
 * Created by Livia on 12/08/2017.
 */

public class Car implements Serializable {

    public int id;
    public String name;
    public String year;


    public Car(int _id, String _name, String _year){
        this.id =_id;
        this.name = _name;
        this.year = _year;
            }
}
