package fr.spiritofphoenix.sop.auth.api.filter;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class CORSFilterTest {

	private static final String ACCESS_CONTROL_ALLOW_HEADERS_CORS = "Origin, X-Requested-With, Content-Type, Accept";
	private static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
	private static final String ACCESS_CONTROL_MAX_AGE_ONE_HOUR = "3600";
	private static final String ACCESS_CONTROL_MAX_AGE = "Access-Control-Max-Age";
	private static final String ACCESS_CONTROL_ALLOW_METHODS_ANY = "OPTIONS, GET, POST, PUT, DELETE";
	private static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
	private static final String ACCESS_CONTOL_ALLOW_ORIGIN_ANYWHERE = "*";
	private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
	private static final MockHttpServletRequest request = new MockHttpServletRequest();
	private static final MockHttpServletResponse response = new MockHttpServletResponse();

	@Test
	public void testCORSFilterAllowedOrigin() throws ServletException, IOException {
		CORSFilter filter = new CORSFilter();
		filter.doFilter(request, response, new MockFilterChain());
		assertTrue(response.getHeader(ACCESS_CONTROL_ALLOW_ORIGIN).equals(ACCESS_CONTOL_ALLOW_ORIGIN_ANYWHERE));
	}

	@Test
	public void testCORSFilterAllowedMethods() throws ServletException, IOException {
		CORSFilter filter = new CORSFilter();
		filter.doFilter(request, response, new MockFilterChain());
		assertTrue(response.getHeader(ACCESS_CONTROL_ALLOW_METHODS).equals(ACCESS_CONTROL_ALLOW_METHODS_ANY));
	}

	@Test
	public void testCORSFilterAllowedMaxAge() throws ServletException, IOException {
		CORSFilter filter = new CORSFilter();
		filter.doFilter(request, response, new MockFilterChain());
		assertTrue(response.getHeader(ACCESS_CONTROL_MAX_AGE).equals(ACCESS_CONTROL_MAX_AGE_ONE_HOUR));
	}

	@Test
	public void testCORSFilterAllowedHeaders() throws ServletException, IOException {
		CORSFilter filter = new CORSFilter();
		filter.doFilter(request, response, new MockFilterChain());
		assertTrue(response.getHeader(ACCESS_CONTROL_ALLOW_HEADERS).equals(ACCESS_CONTROL_ALLOW_HEADERS_CORS));
	}
}
