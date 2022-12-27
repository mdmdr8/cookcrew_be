package kfq.cookcrew.reciepe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
//    List<Recipe> findByTitleContaining(String title);
//    List<Recipe> findByTitleContains(String title);
//    List<Recipe> findByTitleIsContaining(String title);
//    List<Recipe> findByTitleLike(String title);
    @Query("SELECT r FROM Recipe r WHERE r.title LIKE %:title%") // 쿼리 테이블명은 Entity클래스명과 동일한 첫글자 대문자
    List<Recipe> searchByTitleLike(@Param("title") String title);

//    @Query(value = "update recipe r set r.cnt = r.cnt+1 where rno=:rNo")
//    public Integer incrementCnt(@Param("rno") Integer rNo);

    @Query("SELECT CASE WHEN r.cnt = null THEN 0 END as cnt FROM Recipe r WHERE r.rno=:rno")
    public Integer getCntByRno(@Param("rno") Integer rno);
}
