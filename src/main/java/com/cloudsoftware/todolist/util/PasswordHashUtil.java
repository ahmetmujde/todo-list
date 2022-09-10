package com.cloudsoftware.todolist.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class PasswordHashUtil {

    public static String sha512(String password) {
        String hashedPassword = DigestUtils.sha512Hex("salt" + password);
        return Base64.encodeBase64String(hashedPassword.getBytes());
    }
}
