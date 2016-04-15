package me.walkersneps.snepsbotx.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExecuteBashCommand {

    public List<String> executeCommand(String command) {

        List <String> outputLines = new ArrayList<>();

        Process p;
        try {
            //p = Runtime.getRuntime().exec(command);
            p = Runtime.getRuntime().exec(new String[]{"bash", "-c", command});

            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            System.out.println("Created BufferedReader");

            String line;

            while ((line = reader.readLine()) != null) {
                outputLines.add(line);
                System.out.println("Added a string to List outputLines");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return outputLines;

    }



} //class
