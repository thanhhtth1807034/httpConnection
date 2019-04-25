package mainThread;


import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;

public class HttpUrlConnection {
    public static void main(String[] args) {
        try {
            System.out.println("---Send Http GET request---");
            HttpUrlConnection.call_get();
;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void call_get() throws IOException {
        String url = "https://www.w3schools.com/js/json_demo_array.txt";
        URL obj = new URL(url);
        HttpURLConnection huc = (HttpURLConnection) obj.openConnection();

        huc.setRequestMethod("GET");

//        huc.setRequestProperty("User-Agent", "Mozilla/5.0");
        huc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        int responseCode = huc.getResponseCode();
        System.out.println("Send Get request to Url: " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream()));
        String line;
        StringBuffer response = new StringBuffer();
        while ((line = br.readLine()) != null) {
            response.append(line);
        }
        br.close();
        System.out.println(response.toString());


    }
}
