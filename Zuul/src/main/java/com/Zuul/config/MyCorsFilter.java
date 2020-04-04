package com.Zuul.config;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
//@Configuration
public class MyCorsFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//		if (request.getMethod().equals("OPTIONS")){
//			HttpStatus.valueOf(200);
//			return;
//		}
		response.setHeader("Access-Control-Allow-Origin", "*");//允许跨域
    	response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,DELETE,PUT");
    	response.setHeader("Access-Control-Max-Age", "3600");
    	response.setHeader("Access-Control-Allow-Headers", "tokenId,Authorization");
    	response.setHeader("Access-Control-Allow-Credentials", "TRUE");

        filterChain.doFilter(request, response);
    }
}