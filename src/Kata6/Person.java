/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kata6;

/**
 *
 * @author josevicentecabanas
 */
public class Person {
    private final Integer id;
    private final String mail;

    public Person(Integer id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    public Integer getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }
    
}
