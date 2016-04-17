package me.walkersneps.snepsbotx.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExecuteBashCommand {

    public List<String> executeCommand(String command) throws IOException{

        List <String> outputLines = new ArrayList<>();

        String result = null;

            Runtime r = Runtime.getRuntime();

            Process p = r.exec(command);

            BufferedReader in =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                result += inputLine;
                outputLines.add(inputLine);
                System.out.println("Added a line to the List");
            }
            in.close();

        return outputLines;

    }



} //class
