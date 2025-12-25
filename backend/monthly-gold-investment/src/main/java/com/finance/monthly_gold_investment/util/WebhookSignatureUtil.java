package com.finance.monthly_gold_investment.util;

import java.util.HexFormat;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class WebhookSignatureUtil {

    public static boolean verify(String payload,
                                 String actualSignature,
                                 String secret) {

        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes(), "HmacSHA256"));
            byte[] hash = mac.doFinal(payload.getBytes());
            String generated = HexFormat.of().formatHex(hash);

            return generated.equals(actualSignature);
        } catch (Exception e) {
            return false;
        }
    }
}
