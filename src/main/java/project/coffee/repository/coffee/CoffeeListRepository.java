package project.coffee.repository.coffee;

import org.springframework.data.jpa.repository.JpaRepository;
import project.coffee.domain.entity.CoffeeList;

public interface CoffeeListRepository extends JpaRepository<CoffeeList, Long> {
}
