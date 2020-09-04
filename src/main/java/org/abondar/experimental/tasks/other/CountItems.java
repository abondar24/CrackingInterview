package org.abondar.experimental.tasks.other;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CountItems {
    public static void main(String[] args) {
        System.setProperty("http.agent", "Chrome");
        try {
            URL url = new URL("https://coderbyte.com/api/challenges/json/age-counting");
            try {
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();

                String json = new Scanner(inputStream, StandardCharsets.UTF_8).useDelimiter("\\Z").next();

                String startSub = "{\"data\":\"";
                String endSub = "\"}";

                String data = json.substring(json.indexOf(startSub) + startSub.length());
                data = data.substring(0, data.indexOf(endSub));
                data = data.replace(",", "");

                String[] dataArr = data.split(" ");

                String ageStart = "age";
                List<Integer> ages = new ArrayList<>();
                for (String d : dataArr) {
                    if (d.startsWith(ageStart)) {
                        String[] ag = d.split("=");
                        ages.add(Integer.valueOf(ag[1]));
                    }
                }

                long counter = ages
                        .stream()
                        .filter(ag -> ag >= 50)
                        .count();

                System.out.println(counter);


            } catch (IOException ioEx) {
                System.out.println(ioEx);
            }
        } catch (MalformedURLException malEx) {
            System.out.println(malEx);
        }
    }
}

