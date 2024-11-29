package biz.promanage.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Objects;

public class Otp {
    public static String getOTP(String userMobileNumber) throws IOException {
        String otp;
        String otpEndpoint = "https://pmbizapi.promanage.biz/api/promanage/otp/get/" + userMobileNumber + "?otpkey=4466";
        String line;
        String apiResponse = null;

        if (!Objects.equals(userMobileNumber, "9380835000")) {
            BufferedReader br = new BufferedReader(new InputStreamReader(new URL(otpEndpoint).openStream()));
            while ((line = br.readLine()) != null) {
                apiResponse = line;
            }
            assert apiResponse != null;
            otp = ExtractNumberFromString(apiResponse);
        } else {
            otp = "9999";
        }

        return otp;
    }

    public static void resetMobileNumber(String userMobileNumber) throws IOException {
        String otpEndpoint = "https://pmbizapi.promanage.biz/api/promanage/reset-mobile-daily-limit?mobileNumber=" + userMobileNumber;
        String line;
        String apiResponse = null;

            BufferedReader br = new BufferedReader(new InputStreamReader(new URL(otpEndpoint).openStream()));
            while ((line = br.readLine()) != null) {
                apiResponse = line;
            }
            assert apiResponse != null;
            System.out.println("Mobile resest : " + apiResponse);
    }

    public static String ExtractNumberFromString(String str) {
        return str.replaceAll("[^0-9]", "");
    }

}
