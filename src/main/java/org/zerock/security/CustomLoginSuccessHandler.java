package org.zerock.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
  // 유저인증이 성공하면 처리되는 핸들러
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication auth) throws IOException, ServletException {

    log.warn("Login Success");

    List<String> roleNames = new ArrayList<>();
    // [ROLE_ADMIN, ROLE_MEMBER]
    auth.getAuthorities().forEach(authority -> {

      roleNames.add(authority.getAuthority());

    });

    log.warn("ROLE NAMES: " + roleNames);
    // 배열에 권한이 포함되어 있다면 페이지로 이동해준다.
    if (roleNames.contains("ROLE_ADMIN")) {

      response.sendRedirect("/sample/admin");
      return;
    }

    if (roleNames.contains("ROLE_MEMBER")) {

      response.sendRedirect("/sample/member");
      return;
    }

    response.sendRedirect("/");
  }
}


