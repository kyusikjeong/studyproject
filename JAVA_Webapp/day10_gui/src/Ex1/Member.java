/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

/**
 *
 * @author KOSTA
 */
public class Member {
    private String id,name;
    private int age;
    public Member(){
        
    }

    public Member(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
}
