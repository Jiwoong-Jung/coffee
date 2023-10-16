package project.coffee.repository.main;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import project.coffee.domain.dto.main.CoffeeListSearchCond;
import project.coffee.domain.entity.CoffeeList;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class CoffeeListRepositoryJpa implements CoffeeListRepoitory {

    private final SearchDataRepository repository;

    /**
     * 책 검색
     * @param cond
     * @return
     */
    @Override
    public List<CoffeeList> findAll(CoffeeListSearchCond cond) {
        String bookTitle = cond.getBookTitle();

        if (StringUtils.hasText(bookTitle)){
            return repository.findByTitleLike("%"+ bookTitle + "%");
        } else {
            return repository.findAll();
        }
    }
}
