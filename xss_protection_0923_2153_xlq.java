// 代码生成时间: 2025-09-23 21:53:04
package com.quarkus.xss;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

@Path("/xss")
public class XssProtection {

    private static final Pattern XSS_PATTERN = Pattern.compile(
        "<[^>]*script.*?>.*?<[^>]*\/script[^>]*>|<[^>]*iframe.*?>|<[^>]*object.*?>|<[^>]*embed.*?>|<[^>]*link.*?>|<[^>]*style.*?>|<[^>]*meta.*?",
        Pattern.CASE_INSENSITIVE | Pattern.DOTALL | Pattern.MULTILINE
    );

    @GET
    @Path("/protect")
    public Response protectXss(@QueryParam("input") String userInput) {
        try {
            if (userInput == null || userInput.trim().isEmpty()) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Input cannot be empty").build();
            }

            // Sanitize user input to prevent XSS
            String sanitizedInput = Jsoup.clean(userInput, Whitelist.basic());

            // Further check for any suspicious patterns
            Matcher matcher = XSS_PATTERN.matcher(sanitizedInput);
            if (matcher.find()) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Input contains XSS patterns").build();
            }

            return Response.ok("Input sanitized successfully").build();
        } catch (Exception e) {
            // Log the error and return a server error response
            return Response.serverError().entity("An error occurred: " + e.getMessage()).build();
        }
    }

    // Main method for testing purposes
    public static void main(String[] args) {
        // This main method is for demonstration purposes and should be removed in production
        System.out.println("XSS Protection service is running");
    }
}
