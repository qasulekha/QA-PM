package biz.promanage.utils;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Properties;
import java.util.logging.FileHandler;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.microsoft.azure.storage.core.Base64;

import biz.promanage.base.BaseTest;
import biz.promanage.reports.ExtentManager;

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

	public void mailWithAttachment(String subject, String content) throws IOException {

		final String username = "qa@sulekha.com";
		final String password = "Testing82026";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "outlook.office365.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("qa@sulekha.com"));
//			message.setRecipients(Message.RecipientType.TO,
//					InternetAddress.parse("MohamedNN@sulekha.com,mohamedjaleel@sulekha.com,manivannanr@sulekha.com,sriniv@sulekha.com,JagadishwaranG@sulekha.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("MohamedNN@sulekha.com,JagadishwaranG@sulekha.com,mohamedjaleel@sulekha.com,MohamedAsifM@promanage.biz"));
			message.setSubject(subject);
			// message.setText(content);

			// message.setContent(content, "text/html");
			Multipart multipart = new MimeMultipart();
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(content, "text/html");
			// messageBodyPart.setText(content);
			// Set text message part
			multipart.addBodyPart(messageBodyPart);
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			String filename = "Promanage_extent_report_%s.png";
			DataSource source = new FileDataSource(filename);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(filename);
			multipart.addBodyPart(messageBodyPart2);

			// Send the complete message parts
			message.setContent(multipart);
			message.addHeader("X-Priority", "1");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	public void mailWithAttachmentfile(String subject, String content) throws IOException {
	    final String username = "qa@sulekha.com";
	    final String password = "Testing82026";

	    Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", "outlook.office365.com");
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.ssl.protocols", "TLSv1.2");

	    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	        }
	    });

	    try {
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("qa@sulekha.com"));
	        message.setRecipients(Message.RecipientType.TO,
	            InternetAddress.parse("JagadishwaranG@sulekha.com,mohamedjaleel@sulekha.com,Rakeshm@promanage.biz,MohamedAsifM@promanage.biz"));
	        message.setSubject(subject);

	        Multipart multipart = new MimeMultipart();

	        // body part
	        MimeBodyPart bodyPart = new MimeBodyPart();
	        bodyPart.setContent(content, "text/html");
	        multipart.addBodyPart(bodyPart);

	        // get latest screenshot from folder
	        File screenshotDir = new File("screenshots");
	        if (screenshotDir.exists() && screenshotDir.isDirectory()) {
	            File[] files = screenshotDir.listFiles(File::isFile);

	            if (files != null && files.length > 0) {
	                // sort by last modified
	                Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
	                File latestFile = files[0]; // latest screenshot

	                MimeBodyPart attachPart = new MimeBodyPart();
	                DataSource source = new FileDataSource(latestFile);
	                attachPart.setDataHandler(new DataHandler(source));
	                attachPart.setFileName(latestFile.getName());
	                multipart.addBodyPart(attachPart);

	                System.out.println("📎 Attached screenshot: " + latestFile.getAbsolutePath());
	            } else {
	                System.err.println("⚠ No screenshots found in: " + screenshotDir.getAbsolutePath());
	            }
	        } else {
	            System.err.println("⚠ Screenshot folder not found: " + screenshotDir.getAbsolutePath());
	        }

	        message.setContent(multipart);
	        message.addHeader("X-Priority", "1");

	        Transport.send(message);
	        System.out.println("✅ Email sent successfully with latest screenshot");

	    } catch (MessagingException e) {
	        throw new RuntimeException(e);
	    }
	}
	 // directory to save screenshots
    private static final String SCREENSHOTS_DIR = "screenshots";
    private static final String AZURE_BASE_URL = "http://lscdn.azureedge.net/jenkins/Capshine/";

    public String takeScreenshots() {
        String screenshotName = String.format("Promanage_extent_report_%s.png", DateTimeUtil.getDateTime());
        String imagePath = Paths.get(SCREENSHOTS_DIR, screenshotName).toString();
        String azureFilePath = AZURE_BASE_URL + screenshotName;

        try {
            // Take screenshot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(imagePath));  // ✅ using FileUtils

            // Encode as Base64 for Extent Report
            byte[] encoded = org.apache.commons.codec.binary.Base64.encodeBase64(FileUtils.readFileToByteArray(new File(imagePath)));
            String base64Image = new String(encoded, StandardCharsets.US_ASCII);

            // Upload to Azure
            AzureFileUpload.ScreenShot(new File(imagePath));

            // Add screenshot to Extent Report
            Reporter.log(String.format("<a href='%s'><img src='%s' height='400' width='400'/></a>", azureFilePath, azureFilePath));
            ExtentManager.getTest().info(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());

            return imagePath; // ✅ return local path (for email attachment)

        } catch (IOException e) {
            test.log(Status.FAIL, "Failed to take screenshot: " + e.getMessage());
            return null;
        }
    }

	

	public void mail(String subject, String content,String scrpath) throws IOException {

		final String username = "qa@sulekha.com";
		final String password = "Testing92025";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "outlook.office365.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("qa@sulekha.com"));
//			message.setRecipients(Message.RecipientType.TO,
//					InternetAddress.parse("MohamedNN@sulekha.com,mohamedjaleel@sulekha.com,manivannanr@sulekha.com,sriniv@sulekha.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("MohamedNN@sulekha.com,mohamedjaleel@sulekha.com,JagadishwaranG@sulekha.com"));
			message.setSubject(subject);
			message.setContent(content, "text/html");
			// message.setText(content);
			message.addHeader("X-Priority", "1");
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static String timestamp() {
		// Timestamp to make each screenshot name unique
		return new SimpleDateFormat("yyyy-MM-dd HH-mm").format(new Date());
	}

	public void snap(RemoteWebDriver driver) {
		try {
			// To create reference of TakesScreenshot
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			// Call method to capture screenshot
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			// Copy files to specific location
			// result.getName() will return name of test case so that screenshot name will
			// be same as test case name
			FileUtils.copyFile(src, new File("./reports/" + timestamp() + ".jpg"));
			System.out.println("Successfully captured a screenshot");
		}

		catch (IOException e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());
			e.printStackTrace();
		}
	}
}
