package project.coffee.domain.dto.mypage;

import lombok.*;
import project.coffee.domain.entity.OrderCoffee;
import project.coffee.domain.entity.Customer;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PresentOrderCoffee {
    private String m_id;
    private String title;
    private LocalDateTime r_startdate;
    private LocalDateTime r_enddate;
    private Long b_no;

    private Customer customer;

    //entity -> dto
    public PresentOrderCoffee(OrderCoffee orderCoffee){
        title = orderCoffee.getTitle();
        r_startdate = orderCoffee.getR_startdate();
        r_enddate = orderCoffee.getR_enddate();
        b_no = orderCoffee.getB_no();
        m_id = orderCoffee.getCustomer().getM_id();
    }


}
