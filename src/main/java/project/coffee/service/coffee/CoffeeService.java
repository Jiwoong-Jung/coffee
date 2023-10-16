package project.coffee.service.coffee;

import project.coffee.domain.dto.coffee.CoffeeListDTO;
import project.coffee.domain.dto.coffee.OrderDetailDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CoffeeService {

    public void updateOrderDetail(int b_no, String review, String m_id);

    public List<OrderDetailDTO> getOrderDetailList(long b_no);

    public CoffeeListDTO findCoffee(long b_no);

    public int orderCoffee(String m_id, long b_no);

    boolean checkLoginHere(HttpServletRequest request, String m_id);
}
