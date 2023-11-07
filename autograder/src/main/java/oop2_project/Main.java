package oop2_project;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        UnzipUtility unzipper = new UnzipUtility();
        
        try {
            String destination = unzipper.unzip("/Users/jerrellejohnson/Desktop/tesing/LuggageManagementSystem.zip");
            System.out.println("Unzipped to: " + destination);
        } catch (IOException e) {
            e.printStackTrace();
            //System.out.println(e);
        }
    }
}