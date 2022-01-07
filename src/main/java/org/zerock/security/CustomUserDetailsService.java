package org.zerock.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;
import org.zerock.security.domain.CustomUser;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {

  @Setter(onMethod_ = {@Autowired})
  private MemberMapper memberMapper;


  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

    log.warn("Load User By UserName : " + userName);

    // 유저정보 + 권한정보
    MemberVO userInfoAuth = memberMapper.read(userName);

    log.warn("queried by member mapper: " + userInfoAuth);

    // 사용자 정보가 없다면 null 처리
    return userInfoAuth == null ? null : new CustomUser(userInfoAuth);
  }

}
