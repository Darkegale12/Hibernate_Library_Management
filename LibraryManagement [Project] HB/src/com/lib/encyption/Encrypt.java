package com.lib.encyption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {
 public static final String encryptMyISBN(String isbn) {
	 try {
         // Get MD5 MessageDigest instance
         MessageDigest md = MessageDigest.getInstance("MD5");

         // Convert ISBN string to bytes and update digest
         md.update(isbn.getBytes());

         // Get the hash's bytes
         byte[] digest = md.digest();

         // Convert bytes to hexadecimal format
         StringBuilder encisbn = new StringBuilder();
         for (byte b : digest) {
             encisbn.append(String.format("%02x", b));
         }

         return encisbn.toString(); // Return the hashed ISBN
     } catch (NoSuchAlgorithmException e) {
         throw new RuntimeException("Error: MD5 Algorithm not found", e);
     }
 }
 }

