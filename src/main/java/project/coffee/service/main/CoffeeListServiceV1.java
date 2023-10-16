package project.coffee.service.main;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.coffee.domain.dto.main.CoffeeListSearchCond;
import project.coffee.domain.entity.CoffeeList;
import project.coffee.repository.main.CoffeeListRepoitory;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoffeeListServiceV1 implements CoffeeListService {

    private final CoffeeListRepoitory coffeeListRepoitory;


    @Override
    public List<CoffeeList> findBooks(CoffeeListSearchCond cond) {
        return coffeeListRepoitory.findAll(cond);
    }
}
