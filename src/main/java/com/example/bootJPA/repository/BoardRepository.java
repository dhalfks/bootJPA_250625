package com.example.bootJPA.repository;

/* JpaRepository<테이블명, id Type> */

import com.example.bootJPA.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardCustomRepository {
    /* id가 아닌 다른 조건으로 값을 검색할 때 사용 */

//    @Query("select b from Board b where b.writer = ?1")
//    List<Board> findByWriter(String writer);
    
    /* read count 순위로 상위 5개 가져오기 */
    List<Board> findTop5ByOrderByReadCountDesc();

    /* cmtQty 순으로 상위 5개 가져오기 */
    List<Board> findTop5ByOrderByCmtQtyDesc();
}
