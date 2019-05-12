package p;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

/**
 * This class allows to generate MD5 checksums.
 * 
 * @author Julio
 */
public class Md5 {
	
	/** Block size to use for reading streams. */
	private static final int BLOCK_SIZE = 1024;
	
	/**
	 * Generates the md5 value for a given string.
	 * 
	 * @param s the string
	 * @return md5 of the string
	 * @throws NoSuchAlgorithmException in case the MD5 algorithm is not implemented
	 */
	public String of(String s) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(s.getBytes());
		return DatatypeConverter.printHexBinary(md.digest());
	}
	
	/**
	 * Generates the md5 value for a given stream.
	 * 
	 * @param is the stream
	 * @return md5 of the stream
	 * @throws IOException in case an error occurs during I/O
	 * @throws NoSuchAlgorithmException if the MD5 algorithm is not implemented
	 */
	public String of(InputStream is) throws IOException, NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] buffer = new byte[BLOCK_SIZE];
		int bytesRead = 0;
		while((bytesRead = is.read(buffer, 0, BLOCK_SIZE)) != -1) {
			md.update(buffer, 0, bytesRead);
		}
		return DatatypeConverter.printHexBinary(md.digest());
	}
}
