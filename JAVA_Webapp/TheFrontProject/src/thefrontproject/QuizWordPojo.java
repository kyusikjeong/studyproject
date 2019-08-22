/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thefrontproject;

import java.io.Serializable;

/**
 *
 * @author KOSTA
 */
public class QuizWordPojo implements Serializable{
    private String word;
    private String mean;
    
    public QuizWordPojo(String word, String mean) {
        this.word = word;
        this.mean = mean;
    }
    

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }
    
    
            
}
