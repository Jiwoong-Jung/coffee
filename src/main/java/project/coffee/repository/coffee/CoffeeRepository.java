package project.coffee.repository.coffee;

import project.coffee.domain.dto.coffee.CoffeeListDTO;
import project.coffee.domain.dto.coffee.OrderCoffeeDTO;
import project.coffee.domain.dto.coffee.OrderDetailDTO;
import project.coffee.domain.dto.coffee.CustomerDTO;
import project.coffee.domain.entity.OrderDetail;

import java.util.List;

public interface CoffeeRepository {

    public void updateOrderDetail(OrderDetailDTO reviewdto, CustomerDTO userdto);

    public CoffeeListDTO getCoffee(long b_no);

    public CustomerDTO getCustomer(String m_id);

    public List<OrderDetail> getCoffeeList(long b_no);

    public int getMyCoffeeList(OrderCoffeeDTO rentalbootdto);
}
