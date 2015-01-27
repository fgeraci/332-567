package edu.rutgers.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import edu.rutgers.util.LoggerFactory;
import edu.rutgers.util.LoggerFactory.LOGGER_TYPE;
import edu.rutgers.util.LoggerFactory.Logger.LOG_TYPE;
import edu.rutgers.util.Utilities;

public class RequestFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		LoggerFactory.getLogger(LOGGER_TYPE.CONSOLE).log(Utilities.getDataStampString()+
				" - Filter: "+this+" - Session: "+((HttpServletRequest)request).getSession().getId(), LOG_TYPE.GRAL);
		chain.doFilter(request, response);
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		return "RequestFilter";
	}

}
