package project.coffee.repository.main;

import project.coffee.domain.dto.main.CoffeeListSearchCond;
import project.coffee.domain.entity.CoffeeList;

import java.util.List;

public interface CoffeeListRepoitory {

    List<CoffeeList> findAll(CoffeeListSearchCond cond);

}
