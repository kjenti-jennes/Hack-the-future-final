import com.google.gson.stream.JsonReader;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        String api = "http://maze-staging.bewire.org/maze";
        String url = api + "?teamId=cf15c5e5-4596-4757-a486-6fd19e3759e1";
        int count = 0;

        while(true) {
            HttpResponse<JsonNode> getResponse = Unirest.get(url).asJson();


            String json = getResponse.getBody().toString();
            //System.out.println(json);

            JSONObject jsonObject = new JSONObject(json);

            String maze = jsonObject.getString("mazeId");
            String post = api+ "/" + maze;
            String image = api + "/" + maze + "/image";

            //System.out.println(image);

            URL url1 = new URL(image);
            BufferedImage image1 = ImageIO.read(url1);
            int height = image1.getHeight();
            int width = image1.getWidth();
            //System.out.println("Height : "+ height);
            //System.out.println("Width : "+ width);

            if (height <= 65 && width <= 65) {
                count++;
                System.out.println(count);
                HttpResponse<JsonNode> postResponse = Unirest.post(post)
                        .header("Content-Type", "application/json")
                        .body("{\"cells\": [{\"x\": 0,\"y\": 0},{\"x\": 0,\"y\": 1},{\"x\": 1,\"y\": 1}]}")
                        .asJson();
                HttpResponse<JsonNode> postResponse2 = Unirest.post(post)
                        .header("Content-Type", "application/json")
                        .body("{\"cells\": [{\"x\": 0,\"y\": 0},{\"x\": 1,\"y\": 0},{\"x\": 1,\"y\": 1}]}")
                        .asJson();
                HttpResponse<JsonNode> postResponse3 = Unirest.post(post)
                        .header("Content-Type", "application/json")
                        .body("{\"cells\": [{\"x\": 1,\"y\": 0},{\"x\": 0,\"y\": 0},{\"x\": 0,\"y\": 1}]}")
                        .asJson();
            }

        }


        //System.out.println(postResponse.getBody().toPrettyString());


        /*

        HttpResponse<JsonNode> response = Unirest.post("http://httpbin.org/post")
                .header("accept", "application/json")
                .queryString("apiKey", "123")
                .field("parameter", "value")
                .field("firstname", "Gary")
                .asJson();

         */


        // HttpResponse<JsonNode> getResponseImage = Unirest.get(url).asJson();





        //String x = jsonObject.get("cells").toString();
        // JsonReader jsonReader = Json.createReader(new StringReader(yourString));

        // JsonNode jsonNode =

        //System.out.println(maze);
        // System.out.println(x);










        //  System.out.println(x);


        //   String postUrl = api + "/" + maze;
        //   System.out.println(postUrl);




        //  HttpResponse<JsonNode> postResponse = Unirest.post(url)
        //         .body("{\"name\":\"Sam Baeldung\", \"city\":\"viena\"}")
        //         .asJson();

        //    System.out.println(postResponse.getBody().toPrettyString());


    }
}
