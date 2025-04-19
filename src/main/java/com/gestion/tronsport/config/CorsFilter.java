package com.gestion.tronsport.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;

        // Get the origin from the request
        String origin = request.getHeader("Origin");

        // List of allowed origins
        String[] allowedOrigins = {
            "http://localhost:5173",
            "http://localhost:5174",
            "https://tronsport-frontend.onrender.com",
            "https://gestion-tronsport-idgt.vercel.app",
            "https://gestion-tronsport-idqt.vercel.app"
        };

        // Check if the origin is allowed
        boolean allowed = false;
        if (origin != null) {
            for (String allowedOrigin : allowedOrigins) {
                if (origin.equals(allowedOrigin)) {
                    response.setHeader("Access-Control-Allow-Origin", origin);
                    allowed = true;
                    break;
                }
            }
        }

        // If origin is not in the allowed list, use a default (you can change this behavior)
        if (!allowed) {
            response.setHeader("Access-Control-Allow-Origin", "https://gestion-tronsport-idqt.vercel.app");
        }
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, PATCH, HEAD");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, authorization, content-type, Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Expose-Headers", "Authorization");

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }
}
