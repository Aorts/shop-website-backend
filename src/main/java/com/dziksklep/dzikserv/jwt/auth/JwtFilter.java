package com.dziksklep.dzikserv.jwt.auth;

import org.springframework.web.filter.GenericFilterBean;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    public JwtFilter() {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;
        String authHeader = request.getHeader("authorization");
        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(200);
            chain.doFilter(req, res);
        } else {
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                throw new ServletException("Missing or invalid Authorization header");
            }

            String token = authHeader.substring(7);

            try {
                Claims claims = (Claims)Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
                request.setAttribute("claims", claims);
            } catch (SignatureException var9) {
                throw new ServletException("Invalid token.");
            }

            chain.doFilter(req, res);
        }

    }
}
