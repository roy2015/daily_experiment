package com.roy.miscellaneous.mainTest;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.UUID;

import javax.crypto.NoSuchPaddingException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author guojun
 * @date 2022/8/2 16:09
 */
@Slf4j
public class TestDataPlatformSign {

  static class Solution {
    /**通过AKSK生成密文*@paramprivateKeyString私钥*/
    private static String getCipherText(String privateKeyString) throws NoSuchAlgorithmException,
        InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, SignatureException {
      KeyFactory factory = KeyFactory.getInstance("RSA");
      PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyString));
      PrivateKey privateKey = factory.generatePrivate(privateKeySpec);
      Signature privateSignature = Signature.getInstance("SHA256withRSA");
      privateSignature.initSign(privateKey);
      String input = String.format("%s@%s", UUID.randomUUID(), 3600 * 2);
      privateSignature.update(input.getBytes(StandardCharsets.UTF_8));
      return input + "#" + new String(Base64.getEncoder().encode(privateSignature.sign()), StandardCharsets.UTF_8);
    }

  }


  public static void main(String[] args) throws Exception {
    log.info("{}", Solution.getCipherText("MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQChPPpO3aP4Nyjsipw49gUG/M78tJnUV9d8QcwjlB2NN2HGobJjrYbkgOsIx6SEqFUmvUxu3/xl5HJn2xC2+nCD0XS7rvHCDkECBhX49X+f46ZrqwlYvnmueKgw85xkGCSc4pESap8WKnoDvAqdXeCf/QQ+9FqSBj+9Qmv39tivJqUv3KoNPj+ATUIKG4vAHV5T+COf7yf9of6Np+Ya0hrbK9xqAYEI4+paqIjveUvOIGSz/eHPVfF8hDsbFBacrJAGsAZfAPjdW3a1cATInxaCxE4z4v/yOZPWAOzQDgumwT2/ERUtry8EEm9UpVnmZXT5g37yNEqNElSTEkla8ArxAgMBAAECggEAJtwea7GJWkJZD6Fcg3Hvxj5Z2JfiV0YQfjcRbyW8dZN6cjf4WYOx9hKIEuai5QH4+8w1xqcfGqOTWyp1/dOgGHT70Fwaki2DR2yWERmB99QTAPII36WQiBc2Wg3sjEcxU8pbMngV/W6hV5MTb9f3UjfVtSKJTZZJ+GAwy2Nn19ZxQTbYmw1F9nJDrfwBOFQ4mFzWo1Blk2C5qC61tG44CN8RB09dD3UnC82Zb5G9yVXa2iDd4y0Z4pjMlHCC+zNTgPwkF4y9D5rLib1sJsVf3IOUoxAhy2GbHZPFLec5gphQi0Tp3nvuwDB3yvRfWOtPMdAo40Iu8tyWXvG2zafEbQKBgQD86fEOYvsOwSRCMBY7DiwlJht4XoZdKzhjn6P+ScvU2jrWB3/uC0jlLvGpVQEEf66NzVQkpbjGl83ib6vmozsP2MHIhUvRm/5S0KaDrGX3z21liH2PSs+bEZXEbCuUbOCvfTxtf9gu8Dj23P2DjTat83khOphNA9KizzXto15E3wKBgQCjNKhVPpSqhPiRorFjfZWaSTanZUa95FEt/+Lol5ocuKdYtq6wt+i+dRu+/aho1r2fmctvM/iHddMYjFXdrTKSNqf2xMUj8YLSGeZ4HKLQ59Q1NTa3NrtXpNkQ3KhWnoNsmb/0oGgrI6ok/bkDNNnIWcN2YOWu6XswXubhkfVaLwKBgQC4Q6mBFdRcV5OXNXm85QJ8vlrdQ+EZGFgpHTJaHmIHXkfnj+dBA6/EaoNfH7NyF6SRY7ueR69r4UX7Z+kSTHLHhOEKuzMWMFUG+UWYQY65EcNeaicwswy2qgU36qeFqB27Pb88+BwFdrfKBBAgPE5ORklGUG6ODe7094sO7CvOeQKBgGX6IyyQm+goigDF/b1C3VW4ZZQXLiq9HRR3DVt0TvGfV8GQ9Hqrj5xiJGIksTRA6d9uA7WKbcKGls6B8a0/6Zd+21jP/rbE049ga6eljP6nvOs6QuQcKNdMw+1LU0w8Y7ZaI51BFZXPBSNz/kTIo0QTApVXWmz+quDAi9dqkjo1AoGAWXaEqspxbPhD1T1uV/ey+/W9UN1PiVKK5XbXRLi5BpDMt4XEZxySsK3uVNM/kELClzvkg0RHs90fL+dlzYp6g4QzwOMu1om0b/HtrBlePBxmEF5vJRhjgbvVu8S37pMgfzD+rw5NvMqZNv9tfNXn7l0MERSIxeGoOkalKUu1Fgk="));
  }
}
