package project.coffee.domain.dto.coffee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.coffee.domain.entity.CoffeeList;
import project.coffee.domain.entity.OrderDetail;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDTO {
    private Long b_no;
    private String title;
    private String nickname;
    private String answer;
    private String userId;
    private CoffeeList coffeeList;

    public OrderDetailDTO(OrderDetail orderDetail) {
        this.b_no = orderDetail.getId();
        this.title = orderDetail.getTitle();
        this.nickname = orderDetail.getNickname();
        this.answer = orderDetail.getAnswer();
        this.userId = orderDetail.getCustomer().getM_id();
        this.coffeeList = orderDetail.getCoffeeList();
    }

    public OrderDetail dtoToEntity(CustomerDTO userdto){

        return OrderDetail.builder()
                .title(title)
                .nickname(userdto.getNickname())
                .answer(answer)
                .customer(userdto.dtoToEntity())
                .coffeeList(coffeeList)
                .build();
    }

    public OrderDetail dtoToEntity(){

        return OrderDetail.builder()
                .title(title)
                .nickname(nickname)
                .answer(answer)
                .coffeeList(coffeeList)
                .build();
    }
}
