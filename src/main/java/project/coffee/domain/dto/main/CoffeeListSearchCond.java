package project.coffee.domain.dto.main;

import lombok.Data;

/**
 * 책 검색 (사용자 입력 값)
 */
@Data
public class CoffeeListSearchCond {

    private String bookTitle;

    public CoffeeListSearchCond(){}

    public CoffeeListSearchCond(String bookTitle){
        this.bookTitle = bookTitle;
    }
}
