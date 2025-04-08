package com.example.mybatis3.memo;

import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class MemoService {
  @Autowired
  private MemoDao memoDao;

  // 글을 작성 -> 리스트로 간다? 작성한 글읽기로 이동?
  public int save(Memo memo) {
     // 현재 memo 의 mno 는 값이 없다
    // DAO 에서 @SelectKey 를 이용해서 memo 의 mno 에 시퀀스 값을 저장
    memoDao.save(memo);
    // DAO 호출이 끝나고 하면, DAO 가 생성해서 저장한 mno 값이 memo 에 들어있다
    return memo.getMno();
  }

  public List<Memo> findAll() {
    return memoDao.findAll();
  }

  public Optional<Memo> findByMno(int mno) {
    return memoDao.findByMno(mno);
  }

  public boolean update(Memo memo) {
    // 변경 못하면 0, 변경하면 변경한 갯수
    return memoDao.update(memo)>0;
  }

  public boolean delete(int mno)   {
    return memoDao.delete(mno)>0;
  }

  // Service 도 테스트를 할 수 있다
  // 하지만 에러를 해결할 수 있어야 한다
  // Service 가 안되면 Dao 도 안된다는 것이기 때문.
}
