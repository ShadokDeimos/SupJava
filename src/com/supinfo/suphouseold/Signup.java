package com.supinfo.suphouseold;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Signup extends HttpServlet {
    public static final String VUE = "/WEB-INF/signup.jsp";
    public static final String SIGNUP_EMAIL = "email";
    public static final String SIGNUP_PASS = "password";
    public static final String SIGNUP_CONF = "confirm";
    public static final String SIGNUP_USERNAME = "username";
    public static final String WARN_ERRORS = "errors";
    public static final String WARN_RESULTS = "results";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affiche la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String results;
        Map<String, String> errors = new HashMap<String, String>();
        /* Ici on récupère les champs du formulaire */
        String email = request.getParameter( SIGNUP_EMAIL );
        String password = request.getParameter (SIGNUP_PASS );
        String confirm = request.getParameter (SIGNUP_CONF );
        String username = request.getParameter (SIGNUP_USERNAME );

        try {
            validationEmail(email);
        } catch (Exception e) {
            errors.put(SIGNUP_EMAIL, e.getMessage());
        }
        try {
            validationPassword(password, confirm);
        } catch (Exception e) {
            errors.put(SIGNUP_PASS, e.getMessage());
        }
        try {
            validationUsername( username );
        } catch (Exception e) {
            errors.put(SIGNUP_USERNAME, e.getMessage());
        }

        if (errors.isEmpty()) {
            results = "Sign Up Sucess !";
        } else {
            results = "Sign Up Failed.";
        }

        request.setAttribute( WARN_ERRORS, errors);
        request.setAttribute( WARN_RESULTS, results);

        /* On transmet au JSP */
        this.getServletContext().getRequestDispatcher( VUE ).forward(request, response);
    }

    private void validationEmail( String email) throws Exception{
        if ( email != null && email.trim().length() != 0) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" )) {
                throw new Exception( "Enter valid mail please." );
            }
        } else {
            throw new Exception( "Please enter valid mail." );
        }
    }

    private void validationPassword( String password, String confirm ) throws Exception{
        if ( password != null && password.trim().length() != 0 && confirm != null && confirm.trim().length() != 0) {
            if ( !password.equals(confirm)) {
                throw new Exception("Password not identical. Please try again.");
            } else if (password.trim().length() < 3) {
                throw new Exception("Password must contain 3 chars min.");
            }
        } else {
            throw new Exception("Please enter your password and your confirm password");
        }
    }

    private void validationUsername( String username ) throws Exception{
        if ( username != null && username.trim().length() < 3) {
            throw new Exception("Username must contain 3 chars min.");
        }
    }
}
