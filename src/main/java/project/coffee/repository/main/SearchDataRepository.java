package project.coffee.repository.main;

import org.springframework.data.jpa.repository.JpaRepository;
import project.coffee.domain.entity.CoffeeList;

import java.util.List;

public interface SearchDataRepository extends JpaRepository<CoffeeList, Long> {
    List<CoffeeList> findByTitleLike(String bookTitle);

}
