package uz.pdp.appwarehouse.Service;

import org.apache.commons.lang3.RandomStringUtils;

import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Random {


    public String getRandom() {
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        return generatedString;
    }
    public String getRandomId(Integer length) {
        byte[] array = new byte[length];
        new java.util.Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString;
    }
    public Timestamp getDateNow() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        return timestamp;
    }



}
