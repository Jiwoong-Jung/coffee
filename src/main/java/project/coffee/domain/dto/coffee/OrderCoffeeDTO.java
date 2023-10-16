package project.coffee.domain.dto.coffee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.coffee.domain.entity.OrderCoffee;
import project.coffee.domain.entity.Customer;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCoffeeDTO {

    private Long id;

    private Customer customer;

    private Long b_no;
    private String title;

    private LocalDateTime r_startdate;

    private LocalDateTime r_enddate;

    public OrderCoffeeDTO(OrderCoffee rentalbook){
        this.id = rentalbook.getId();
        this.customer = rentalbook.getCustomer();
        this.b_no = rentalbook.getB_no();
        this.title = rentalbook.getTitle();
        this.r_startdate = rentalbook.getR_startdate();
        this.r_enddate = rentalbook.getR_enddate();
    }

    public OrderCoffee dtoToEntity(){
        return  OrderCoffee.builder()
                .id(id)
                .customer(customer)
                .b_no(b_no)
                .title(title)
                .r_startdate(r_startdate)
                .r_enddate(r_enddate)
                .build();
    }
}
