package com.production.testing.InterviewPreparation;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.util.Base64;
import java.util.Date;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.crypto.RSAEncrypter;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

public class EncryptionDataClass {
	private RSAPublicKey pubkey;
	private RSAPrivateKey pvtkey;
	private RSAPublicKey pubkey_jwe;
	private RSAPrivateKey pvtkey_jwe;
	public EncryptionDataClass()
	{
		String pubcert = "/Users/sartway/eclipse-workspace/InterviewPreparation/src/main/resources/public_key.pem";
		String pvtcert = "/Users/sartway/eclipse-workspace/InterviewPreparation/src/main/resources/private_key.pem";
		String public_cert_jwe = "/Users/sartway/eclipse-workspace/InterviewPreparation/src/main/resources/public_jwe.pem";
		String private_cert_jwe = "/Users/sartway/eclipse-workspace/InterviewPreparation/src/main/resources/private_jwe.pem";
		try
		{
			File pubfile=new File(pubcert);
			File pvtfile=new File(pvtcert);
			String pubkey=new String(Files.readAllBytes(pubfile.toPath()), Charset.defaultCharset());
			String pubkeyPEM = pubkey
				      .replace("-----BEGIN PUBLIC KEY-----", "")
				      .replaceAll(System.lineSeparator(), "")
				      .replace("-----END PUBLIC KEY-----", "")
				      .replaceAll("\\r\\n", "")
				      .replaceAll("[\\r\\n]", "");
			byte[] encoded = Base64.getDecoder().decode(pubkeyPEM);

		    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(encoded);
		    this.pubkey = (RSAPublicKey) keyFactory.generatePublic(keySpec);
		    
		    String pvtkey=new String(Files.readAllBytes(pvtfile.toPath()), Charset.defaultCharset());
		    String pvtkeyPEM = pvtkey
		    		.replaceAll("-----BEGIN PRIVATE KEY-----", "")
		    		.replaceAll(System.lineSeparator(), "")
		    		.replaceAll("-----END PRIVATE KEY-----", "")
				    .replaceAll("\\r\\n", "")
				    .replaceAll("[\\r\\n]", "");
		    byte[] decoded = Base64.getDecoder().decode(pvtkeyPEM);
		    PKCS8EncodedKeySpec keySpecpvt = new PKCS8EncodedKeySpec(decoded);
		    this.pvtkey= (RSAPrivateKey) keyFactory.generatePrivate(keySpecpvt);
		    System.out.println("JWS Cert initialisation success");
		    File pubjwefile = new File(public_cert_jwe);
		    File pvtjwefile = new File(private_cert_jwe);
		    String pubjwekey = new String(Files.readAllBytes(pubjwefile.toPath()), Charset.defaultCharset());
		    String pvtjwekey = new String(Files.readAllBytes(pvtjwefile.toPath()), Charset.defaultCharset());
		    String pubjwepem = pubjwekey
		    		  .replace("-----BEGIN PUBLIC KEY-----", "")
				      .replaceAll(System.lineSeparator(), "")
				      .replace("-----END PUBLIC KEY-----", "")
				      .replaceAll("\\r\\n", "")
				      .replaceAll("[\\r\\n]", "");
		    
		    byte[] encoded_jwe = Base64.getDecoder().decode(pubjwepem);
		    X509EncodedKeySpec keySpecjwe = new X509EncodedKeySpec(encoded_jwe);
		    this.pubkey_jwe = (RSAPublicKey) keyFactory.generatePublic(keySpecjwe);
		    
		    String pvtjwepem = pvtjwekey
		    		.replaceAll("-----BEGIN PRIVATE KEY-----", "")
		    		.replaceAll(System.lineSeparator(), "")
		    		.replaceAll("-----END PRIVATE KEY-----", "")
				    .replaceAll("\\r\\n", "")
				    .replaceAll("[\\r\\n]", "");
		    
		    byte[] decoded_jwe = Base64.getDecoder().decode(pvtjwepem);
		    PKCS8EncodedKeySpec keySpecpvtjwe = new PKCS8EncodedKeySpec(decoded_jwe);
		    this.pvtkey_jwe = (RSAPrivateKey) keyFactory.generatePrivate(keySpecpvtjwe);
		    System.out.println("JWE Cert initialisation success");
		    System.out.println("Cert initialisation success");
		}catch(Exception E)
		{
			System.err.println(E.getLocalizedMessage());
		}
	}
	
	public String encryptedMessage(String password)
	{
		JWSSigner signer = new RSASSASigner(this.pvtkey);
		JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.RS256).build();
		JWSObject jwsObj = new JWSObject(header, new Payload(password));
		JWSVerifier verifier = new RSASSAVerifier(this.pubkey);
		//String encPassword = jwsObj.serialize();
		try {
			//jwsObj = JWSObject.parse(encPassword);
			jwsObj.sign(signer);
			String encPassword = jwsObj.serialize();
			if(jwsObj.verify(verifier)==true)
			{
				System.out.println("JWS Signing is successful");
				return encPassword;
			} else {
				return "Encryption failed";
			}
		} catch (JOSEException e) {
			System.out.println("JWS Signature JOSE error");
			return e.getMessage();
		}
	}
	
	
	public String decryptString(String encPassword)
	{
		JWSObject jwsObj;
		try {
			jwsObj=JWSObject.parse(encPassword);
		} catch(Exception e)
		{
			return e.getMessage();
		}
		JWSVerifier verifier = new RSASSAVerifier(this.pubkey);
		try {
			if(jwsObj.verify(verifier)==true)
			{
				return jwsObj.getPayload().toString();
			} else {
				return "decryption failed";
			}
		} catch (JOSEException e) {
			return e.getMessage();
		}
		
	}
	
	public String jweEncrypt(String password)
	{
		try {
			JWSVerifier verifier = new RSASSAVerifier(this.pubkey);
			JWSSigner signer = new RSASSASigner(this.pvtkey);
			SignedJWT signedjwt = new SignedJWT(
					new JWSHeader.Builder(JWSAlgorithm.RS256).build(),
					new JWTClaimsSet.Builder()
					.subject(password)
					.issueTime(new Date())
					.build()
					);
			signedjwt.sign(signer);
			JWEObject jweObject = new JWEObject(
					new JWEHeader.Builder(JWEAlgorithm.RSA_OAEP_256, EncryptionMethod.A256GCM)
					.contentType("JWT")
					.build(),
					new Payload(signedjwt)
					);
			jweObject.encrypt(new RSAEncrypter(this.pubkey_jwe));
			return jweObject.serialize();
		} catch (JOSEException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
			
	}
	
	public String jwedecrypt(String encPassword)
	{
		try {
			JWEObject jweObj = JWEObject.parse(encPassword);
			jweObj.decrypt(new RSADecrypter(this.pvtkey_jwe));
			SignedJWT signedjwt = jweObj.getPayload().toSignedJWT();
			JWSVerifier verifier = new RSASSAVerifier(this.pubkey);
			if(signedjwt.verify(verifier))
			{
				System.out.println("JWE Decryption successful");
				return signedjwt.getJWTClaimsSet().getSubject();
			} else {
				System.out.println("JWE/JWS Decryption failed");
				return "JWE/JWS Decryption failed";
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		} catch (JOSEException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		
	}

}
