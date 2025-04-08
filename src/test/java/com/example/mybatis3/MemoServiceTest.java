package com.example.mybatis3;

import com.example.mybatis3.memo.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MemoServiceTest {
  @Autowired
  private MemoService memoService;

  @Test
  public void saveTest() {
    Memo memo = new Memo(null,"연습", "연습 연습", "spring", null);
    System.out.println(memo);

    memoService.save(memo);
    System.out.print(memo);
  }

  @Test
  public void findAllTest() {
    List<Memo> memos = memoService.findAll();
    System.out.println(memos);
    assertNotEquals(0, memos.size());
  }
  // isPresent = 값이 들었다
  @Test
  public void findByMnoTest() {
    assertEquals(true, memoService.findByMno(6).isPresent());
  }

  @Transactional    // test 에 사용할 경우 취소를 의미
  @Test
  public void updateTest() {
    Memo memo = new Memo(6, "변경", "변경", null, null);
    // 이해하기 쉽게 true, false 로 표시
    assertEquals(true, memoService.update(memo));
  }

  @Transactional
  @Test
  public void deleteTest() {
    assertEquals(true, memoService.delete(6));
  }
}
