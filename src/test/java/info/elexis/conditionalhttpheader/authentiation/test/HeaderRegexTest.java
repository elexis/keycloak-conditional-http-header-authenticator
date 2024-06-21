package info.elexis.conditionalhttpheader.authentiation.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import info.elexis.conditionalhttpheader.authentication.ConditionalHttpHeaderAuthenticator;
import jakarta.ws.rs.core.MultivaluedHashMap;

public class HeaderRegexTest {

	@Test
	public void test() {

		ConditionalHttpHeaderAuthenticator authenticator = new ConditionalHttpHeaderAuthenticator();

		MultivaluedHashMap<String, String> mvhm = new MultivaluedHashMap<String, String>();
		mvhm.add("X-Forwarded-For", "192.168.110.25");
		mvhm.add("cookie",
				"_ga=GA1.2.2100701919.1677049762; _ga_3LRD744TZV=GS1.1.1718870229.255.1.1718870238.0.0.0; _gid=GA1.2.695143360.1718794772");
		mvhm.add("x-forwarded-host", "my.workstation.ws");

		assertTrue(authenticator.containsMatchingRequestHeader(mvhm, "^x-forwarded-for: 192.168.110.*$"));
		assertTrue(authenticator.containsMatchingRequestHeader(mvhm, "x-forwarded-for: 192.168.110.*"));
		assertFalse(authenticator.containsMatchingRequestHeader(mvhm, "^x-forwarded-for: 192.168.109.*$"));
		assertFalse(authenticator.containsMatchingRequestHeader(mvhm, "x-forwarded-for: 192.168.109.*"));
		assertFalse(authenticator.containsMatchingRequestHeader(mvhm, "x-forwarded-host: 192.168.109.*"));
	}

}
