package project.coffee.repository.upload;

import org.springframework.data.jpa.repository.JpaRepository;
import project.coffee.domain.entity.CoffeeImage;

public interface CoffeeImageRepository extends JpaRepository<CoffeeImage, Long> {
}
