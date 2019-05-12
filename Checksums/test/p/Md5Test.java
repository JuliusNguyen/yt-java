package p;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class Md5Test {
	@Test
	public void happyFlowString() throws NoSuchAlgorithmException {
		assertEquals("ED076287532E86365E841E92BFC50D8C", new Md5().of("Hello World!"));
	}
	
	@Test
	public void happyFlowStream() throws NoSuchAlgorithmException, IOException {
		try(InputStream is = new ByteArrayInputStream("Hello World!".getBytes())) {
			assertEquals("ED076287532E86365E841E92BFC50D8C", new Md5().of(is));
		}
	}
}
