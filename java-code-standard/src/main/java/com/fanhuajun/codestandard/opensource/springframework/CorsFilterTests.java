package com.fanhuajun.codestandard.opensource.springframework;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CorsFilter;

public class CorsFilterTests {
	
	private CorsFilter filter;

	private final CorsConfiguration config = new CorsConfiguration();

	@Before
	public void setup() throws Exception {
		config.setAllowedOrigins(Arrays.asList("http://domain1.com", "http://domain2.com"));
		config.setAllowedMethods(Arrays.asList("GET", "POST"));
		config.setAllowedHeaders(Arrays.asList("header1", "header2"));
		config.setExposedHeaders(Arrays.asList("header3", "header4"));
		config.setMaxAge(123L);
		config.setAllowCredentials(false);
		filter = new CorsFilter(r -> config);
	}

	@Test
	public void validActualRequest() throws ServletException, IOException {

		MockHttpServletRequest request = new MockHttpServletRequest(HttpMethod.GET.name(), "/test.html");
		request.addHeader(HttpHeaders.ORIGIN, "http://domain2.com");
		request.addHeader("header2", "foo");
		MockHttpServletResponse response = new MockHttpServletResponse();

		FilterChain filterChain = (filterRequest, filterResponse) -> {
			assertEquals("http://domain2.com", response.getHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN));
			assertEquals("header3, header4", response.getHeader(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS));
		};
		filter.doFilter(request, response, filterChain);
	}

	@Test
	public void invalidActualRequest() throws ServletException, IOException {

		MockHttpServletRequest request = new MockHttpServletRequest(HttpMethod.DELETE.name(), "/test.html");
		request.addHeader(HttpHeaders.ORIGIN, "http://domain2.com");
		request.addHeader("header2", "foo");
		MockHttpServletResponse response = new MockHttpServletResponse();

		FilterChain filterChain = (filterRequest, filterResponse) -> {
			fail("Invalid requests must not be forwarded to the filter chain");
		};
		filter.doFilter(request, response, filterChain);
		assertNull(response.getHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN));
	}

	@Test
	public void validPreFlightRequest() throws ServletException, IOException {

		MockHttpServletRequest request = new MockHttpServletRequest(HttpMethod.OPTIONS.name(), "/test.html");
		request.addHeader(HttpHeaders.ORIGIN, "http://domain2.com");
		request.addHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD, HttpMethod.GET.name());
		request.addHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS, "header1, header2");
		MockHttpServletResponse response = new MockHttpServletResponse();

		FilterChain filterChain = (filterRequest, filterResponse) ->
				fail("Preflight requests must not be forwarded to the filter chain");
		filter.doFilter(request, response, filterChain);

		assertEquals("http://domain2.com", response.getHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN));
		assertEquals("header1, header2", response.getHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS));
		assertEquals("header3, header4", response.getHeader(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS));
		assertEquals(123L, Long.parseLong(response.getHeader(HttpHeaders.ACCESS_CONTROL_MAX_AGE)));
	}

	@Test
	public void invalidPreFlightRequest() throws ServletException, IOException {

		MockHttpServletRequest request = new MockHttpServletRequest(HttpMethod.OPTIONS.name(), "/test.html");
		request.addHeader(HttpHeaders.ORIGIN, "http://domain2.com");
		request.addHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD, HttpMethod.DELETE.name());
		request.addHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS, "header1, header2");
		MockHttpServletResponse response = new MockHttpServletResponse();

		FilterChain filterChain = (filterRequest, filterResponse) ->
				fail("Preflight requests must not be forwarded to the filter chain");
		filter.doFilter(request, response, filterChain);

		assertNull(response.getHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN));
	}

}