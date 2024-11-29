package biz.promanage.utils;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/*public class TeamsAlert {
    public static void SendAlertToTeams(String statusMsg, String screenshotUrl) throws InterruptedException, IOException {
        String url= "https://sulekhacom.webhook.office.com/webhookb2/4828b35e-b03a-4a45-8812-e2ebd8b9b9c8@453f0eb0-f553-4141-b377-de75359b3aa1/IncomingWebhook/a8257044b64c4ad3918c6424179bda14/5967805f-09ad-4126-a924-39e1773a4db3";
        String teamsAlertTxt = GetJsonText(statusMsg,screenshotUrl);
        URL myurl = new URL(url);
        HttpURLConnection con = (HttpURLConnection) myurl.openConnection();
        con.setRequestProperty("Content-Type", "application/json;");
        con.setRequestProperty("Method", "POST");
        con.setDoOutput(true);
        Thread.sleep(5000);
        OutputStream os = con.getOutputStream();
        System.out.println(teamsAlertTxt);
        os.write(teamsAlertTxt.getBytes("UTF-8"));
        os.close();
        System.out.println(con.getResponseCode());
    }
    private static String GetJsonText(String StatusMsg, String screenshotUrl) {
      return  "{\r\n" +
                "    \"@context\": \"https://schema.org/extensions\",\r\n" +
                "    \"@type\": \"MessageCard\",\r\n" +
                "    \"themeColor\": \"0072C6\",\r\n" +
                "    \"title\": \"Promanage Alert\",\r\n" +
                "    \"text\": \"" + StatusMsg + "\",\r\n" +
                "    \"potentialAction\": [\r\n" +
                "        {\r\n" +
                "            \"@type\": \"OpenUri\",\r\n" +
                "            \"name\": \"Click and View Screenshot\",\r\n" +
                "            \"targets\": [\r\n" +
                "                {\r\n" +
                "                    \"os\": \"default\",\r\n" +
                "                    \"uri\": \"" + screenshotUrl + "\"\r\n" +
                "                }\r\n" +
                "            ]\r\n" +
                "        }\r\n" +
                "    ]\r\n" +
                "}";


    }
}*/

public class TeamsAlert {
    private static final String WEBHOOK_URL = "https://sulekhacom.webhook.office.com/webhookb2/4828b35e-b03a-4a45-8812-e2ebd8b9b9c8@453f0eb0-f553-4141-b377-de75359b3aa1/IncomingWebhook/a8257044b64c4ad3918c6424179bda14/5967805f-09ad-4126-a924-39e1773a4db3";

    public static void sendAlertToTeams(String statusMsg, String screenshotUrl) throws IOException {
        String teamsAlertTxt = getJsonText(statusMsg, screenshotUrl);
        URL url = new URL(WEBHOOK_URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        OutputStream os = con.getOutputStream();
        os.write(teamsAlertTxt.getBytes("UTF-8"));
        os.close();

        System.out.println("HTTP Response Code: " + con.getResponseCode());
    }

    private static String getJsonText(String statusMsg, String screenshotUrl) {
        return "{\n" +
                "    \"@context\": \"https://schema.org/extensions\",\n" +
                "    \"@type\": \"MessageCard\",\n" +
                "    \"themeColor\": \"0072C6\",\n" +
                "    \"title\": \"Promanage Alert\",\n" +
                "    \"text\": \"" + statusMsg + "\",\n" +
                "    \"potentialAction\": [\n" +
                "        {\n" +
                "            \"@type\": \"OpenUri\",\n" +
                "            \"name\": \"Click and View Screenshot\",\n" +
                "            \"targets\": [\n" +
                "                {\n" +
                "                    \"os\": \"default\",\n" +
                "                    \"uri\": \"" + "imgurl" + "\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }
}
