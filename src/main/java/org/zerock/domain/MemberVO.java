package org.zerock.domain;

import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class MemberVO {

  private String userid;

  private String userpw;

  private String userName;

  private boolean enabled;

  private int failCnt; // 로그인 실패 카운터

  private Date regDate;

  private Date updateDate;

  private List<AuthVO> authList; // 권한정보

}
