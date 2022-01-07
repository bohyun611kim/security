package org.zerock.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {


  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException exception) throws IOException, ServletException {

    String msg = "Invalid username and password";

    if (exception instanceof BadCredentialsException) {
      msg = "invalid secret key";
    }

    setDefaultFailureUrl("/login?error=true&exception=" + msg);

    super.onAuthenticationFailure(request, response, exception);

    log.warn(">>> 로그인 실패");

    log.warn("exception type :" + exception.getClass().getName());
    log.warn("exception message :" + exception.getMessage());


    // response.sendRedirect("/customLogin");
  }
}


