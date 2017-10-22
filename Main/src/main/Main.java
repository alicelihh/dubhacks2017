/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



/**
 *
 * @author ohheather
 */
public class Main {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String sentimentAnalysis = "";
        // String keyPhrases = "";
//        try {
//            Documents getSentimentDocument = new Documents ();
//            
//
//            sentimentAnalysis = GetSentiment (getSentimentDocument);
//            System.out.println (prettify(sentimentAnalysis));
//            
//        }
//        catch (Exception e) {
//            System.out.println (e);
//        }
        // testSentiment(sentimentAnalysis);
    }
    
  
    public static void testSentiment(String sentiment) {
        double sentimentScore = Double.parseDouble(sentiment.substring(23, 30));
        if (sentimentScore < .2) {
            String keyPhrases = "";
            Documents getKeyPhrasesDocument = new Documents ();
            getKeyPhrasesDocument.add ("1", "en", "I really enjoy the new XBox One S. It has a clean look, it has 4K/HDR resolution and it is affordable.");
            
            try {
                keyPhrases = GetKeyPhrases (getKeyPhrasesDocument);
                System.out.println (prettify (keyPhrases));
            } 
            catch (Exception e) {
                System.out.println (e);
            }
            testKeyPhrases(keyPhrases);
        }
    }
    
    public static void testKeyPhrases(String keyPhrases){
        String[] flagWord = new String[]{"a", "b", "c", "d"};
        for (String word : flagWord) {
            if (keyPhrases.contains(word)) {
                flag();
                break;
            }
        }
    }
    
    public static void flag(){
        // do something to call the popups.
    }
    
}
