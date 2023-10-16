package project.coffee.domain.dto.coffee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.coffee.domain.entity.CoffeeList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeListDTO {

    private Long b_no;
    private String author;
    private String title;

    public CoffeeListDTO(CoffeeList booklist){
        this.b_no = booklist.getB_no();
        this.author = booklist.getAuthor();
        this.title = booklist.getTitle();
    }

    public CoffeeList dtoToEntity(){
        return CoffeeList.builder()
                .b_no(b_no)
                .author(author)
                .title(title)
                .build();
    }
}
