package project.coffee.domain.dto.mypage;

import lombok.Data;
import project.coffee.domain.entity.CoffeeList;
import project.coffee.domain.entity.OrderDetail;

@Data
public class OrderDetailDTO {
    private Long id;
    private String title;
    private String nickname;
    private String answer;
    private String userId;
    private CoffeeList coffeeList;

    public OrderDetailDTO(OrderDetail orderDetail) {
        this.id = orderDetail.getId();
        this.title = orderDetail.getTitle();
        this.nickname = orderDetail.getNickname();
        this.answer = orderDetail.getAnswer();
        this.userId = orderDetail.getCustomer().getM_id();
        this.coffeeList = orderDetail.getCoffeeList();
    }

}
