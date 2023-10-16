package project.coffee.service.main;


import project.coffee.domain.dto.main.CoffeeListSearchCond;
import project.coffee.domain.entity.CoffeeList;
import java.util.List;

public interface CoffeeListService {

    List<CoffeeList> findBooks(CoffeeListSearchCond bookListSearch);

}
