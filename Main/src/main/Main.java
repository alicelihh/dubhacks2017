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


class Document {
    public String id, language, text;

    public Document(String id, String language, String text){
        this.id = id;
        this.language = language;
        this.text = text;
    }
}

class Documents {
    public List<Document> documents;

    public Documents() {
        this.documents = new ArrayList<Document>();
    }
    public void add(String id, String language, String text) {
        this.documents.add (new Document (id, language, text));
    }
}
/**
 *
 * @author ohheather
 */
public class Main {

    static String accessKey = "b7f914450ca64905afc8f5050d98958b";
    static String host = "https://westcentralus.api.cognitive.microsoft.com";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String sentimentAnalysis = "";
        String keyPhrases = "";
        try {
            Documents getSentimentDocument = new Documents ();
            getSentimentDocument.add ("1", "en", "I really enjoy the new XBox One S. It has a clean look, it has 4K/HDR resolution and it is affordable.");
            getSentimentDocument.add ("2", "es", "Este ha sido un dia terrible, llegué tarde al trabajo debido a un accidente automobilistico.");

            sentimentAnalysis = GetSentiment (getSentimentDocument);
            System.out.println (prettify (sentimentAnalysis));
            
        }
        catch (Exception e) {
            System.out.println (e);
        }
        testSentiment(sentimentAnalysis);
    }
    
    public static String GetSentiment (Documents documents) throws Exception {
        
        String path = "/text/analytics/v2.0/sentiment";
        String text = new Gson().toJson(documents);
        byte[] encoded_text = text.getBytes("UTF-8");

        URL url = new URL(host+path);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "text/json");
        connection.setRequestProperty("Ocp-Apim-Subscription-Key", accessKey);
        connection.setDoOutput(true);

        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.write(encoded_text, 0, encoded_text.length);
        wr.flush();
        wr.close();

        StringBuilder response = new StringBuilder ();
        BufferedReader in = new BufferedReader(
        new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();

        return response.toString();
    }
    
    public static String GetKeyPhrases (Documents documents) throws Exception {
        String path = "/text/analytics/v2.0/keyPhrases";
        String text = new Gson().toJson(documents);
        byte[] encoded_text = text.getBytes("UTF-8");

        URL url = new URL(host+path);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "text/json");
        connection.setRequestProperty("Ocp-Apim-Subscription-Key", accessKey);
        connection.setDoOutput(true);

        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.write(encoded_text, 0, encoded_text.length);
        wr.flush();
        wr.close();

        StringBuilder response = new StringBuilder ();
        BufferedReader in = new BufferedReader(
        new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();
        return response.toString();
    }
    
    public static String prettify(String json_text) {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(json_text).getAsJsonObject();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(json);
    }
    
    public static void testSentiment(String sentiment) {
        double sentimentScore = Double.parseDouble(sentiment.substring(23, 30));
        if (sentimentScore < 1) {
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
