package biz.promanage.utils;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import biz.promanage.base.BaseTest;

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

public class TeamsAlert extends BaseTest {
	public void Teamsjson(String source, String arg, String status, String url)
			throws MalformedURLException, IOException, InterruptedException {

		String json1 = "{\r\n" + "    \"@context\": \"https://schema.org/extensions\",\r\n"
				+ "    \"@type\": \"MessageCard\",\r\n" + "    \"themeColor\": \"0072C6\",\r\n" + "    \"title\": \""
				+ source + " Alert\",\r\n" + "    \"text\": \"" + arg + "\",\r\n" + "    \"potentialAction\": [\r\n"
				+ "    	{\r\n" + "            \"@type\": \"OpenUri\",\r\n"
				+ "            \"name\": \"Click and View Screenshot\",\r\n" + "            \"targets\": [\r\n"
				+ "                {\r\n" + "                    \"os\": \"default\",\r\n"
				+ "                    \"uri\": \"" + url + "\"\r\n" + "                }\r\n" + "            ]\r\n"
				+ "        }\r\n" + "    ]\r\n" + "}";

		System.out.println("Alerts came");
		if (status.equalsIgnoreCase("fail") && source.equalsIgnoreCase("Promanage")) {
			sendJson(json1, "Promanage");
		}
		
		else if (status.equalsIgnoreCase("pass") && source.equalsIgnoreCase("Promanage")) {
			sendJson1(json1, "Promanage");
		} else {
			sendJson(json1, "Retry");
		}

	}

	// For Failure Teams Alert
	public void sendJson(String json, String src) throws MalformedURLException, IOException, InterruptedException {

		try {
			String url;

			if (src.equalsIgnoreCase("Promanage")) {
				// For LS-Tech(Alert)
				//url = "https://sulekhacom.webhook.office.com/webhookb2/4828b35e-b03a-4a45-8812-e2ebd8b9b9c8@453f0eb0-f553-4141-b377-de75359b3aa1/IncomingWebhook/d87209b84eae4decb55cb106d3a6afd4/878d65a8-b354-402f-ade9-a53db3b910b0/V2DAO09lzN3roWPGl3sapXfAJktTO42zOWGstk6rCFHOU1";
				// For LS-Testing channel
				 url ="https://sulekhacom.webhook.office.com/webhookb2/4828b35e-b03a-4a45-8812-e2ebd8b9b9c8@453f0eb0-f553-4141-b377-de75359b3aa1/IncomingWebhook/d87209b84eae4decb55cb106d3a6afd4/878d65a8-b354-402f-ade9-a53db3b910b0/V2DAO09lzN3roWPGl3sapXfAJktTO42zOWGstk6rCFHOU1";
			} else {
				// For LS-Tech(Alert)
				//url="https://sulekhacom.webhook.office.com/webhookb/60ebdfe4-9e51-4a25-8588-7bb6d413d32f@453f0eb0-f553-4141-b377-de75359b3aa1/IncomingWebhook/7f8ce28a65d94b658c3f5d811a58808b/0b8eddc0-3a0e-4938-a14f-5625f674948e/V20cwGa6mYYwL_Yzb2fnxHSI645VzHBZW7uK_e7fMgzEo1";
				// For LS-Testing channel
				url ="https://sulekhacom.webhook.office.com/webhookb2/4828b35e-b03a-4a45-8812-e2ebd8b9b9c8@453f0eb0-f553-4141-b377-de75359b3aa1/IncomingWebhook/5e5e06c172264113b20c22d869937e47/878d65a8-b354-402f-ade9-a53db3b910b0/V2Vt9z7amdcwgBaYrGWBDQ3roPlo5r6FQzXYqqAYanDs41";
			}
			URL myurl = new URL(url);
			HttpURLConnection con = (HttpURLConnection) myurl.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json;");
			// con.setRequestProperty("Content-Type", "application/json;");
//			con.setRequestProperty("Accept", "application/json,text/plain");
			con.setRequestProperty("Method", "POST");
			con.setDoOutput(true);
			Thread.sleep(5000);
			OutputStream os = con.getOutputStream();
			System.out.println(json);
			os.write(json.toString().getBytes("UTF-8"));
			os.close();
			System.out.println(con.getResponseCode());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// For Pass Teams Alert
	public void sendJson1(String json, String src) throws MalformedURLException, IOException, InterruptedException {

		try {
			String url;
			if (src.equalsIgnoreCase("Promanage")) {

				// For LS-Tech(Alert)
				//url = "https://sulekhacom.webhook.office.com/webhookb2/60ebdfe4-9e51-4a25-8588-7bb6d413d32f@453f0eb0-f553-4141-b377-de75359b3aa1/IncomingWebhook/980fdd0937354a2db71088dd3f53b895/0b8eddc0-3a0e-4938-a14f-5625f674948e/V2NaPm9cGJ4WmrlosgPaYBpldJdcAeiLfofu6vboEZsCA1";
				// For LS-Testing channel
				 url = "https://sulekhacom.webhook.office.com/webhookb2/4828b35e-b03a-4a45-8812-e2ebd8b9b9c8@453f0eb0-f553-4141-b377-de75359b3aa1/IncomingWebhook/3f3b24ca6b7544ac83d76543422de91f/878d65a8-b354-402f-ade9-a53db3b910b0/V2mqnNO4aRSkUbdyQc65f6U-sgSCwjD8Htwa_MtQZOrnY1";
			} else {
				// For LS-Tech(Alert)
				//url = "https://sulekhacom.webhook.office.com/webhookb2/60ebdfe4-9e51-4a25-8588-7bb6d413d32f@453f0eb0-f553-4141-b377-de75359b3aa1/IncomingWebhook/a8926e580a3c4ac58719ff55f330fd42/878d65a8-b354-402f-ade9-a53db3b910b0";
				// For LS-Testing channel
				url ="https://sulekhacom.webhook.office.com/webhookb2/4828b35e-b03a-4a45-8812-e2ebd8b9b9c8@453f0eb0-f553-4141-b377-de75359b3aa1/IncomingWebhook/5e5e06c172264113b20c22d869937e47/878d65a8-b354-402f-ade9-a53db3b910b0/V2Vt9z7amdcwgBaYrGWBDQ3roPlo5r6FQzXYqqAYanDs41";
			}

			URL myurl = new URL(url);
			HttpURLConnection con = (HttpURLConnection) myurl.openConnection();
			// con.setRequestProperty("Content-Type", "application/json;");
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json;");
//			con.setRequestProperty("Accept", "application/json,text/plain");
//			con.setRequestProperty("Method", "POST");
			con.setDoOutput(true);
			Thread.sleep(5000);
			OutputStream os = con.getOutputStream();
			System.out.println(json);
			os.write(json.toString().getBytes("UTF-8"));
			os.close();
			System.out.println(con.getResponseCode());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
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
