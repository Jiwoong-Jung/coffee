package project.coffee.service.mypage;

import project.coffee.domain.dto.mypage.OrderDetailDTO;
import project.coffee.domain.dto.mypage.PostOrderCoffee;
import project.coffee.domain.dto.mypage.PresentOrderCoffee;

import java.util.List;

public interface MyPageService {

    public List<PostOrderCoffee> getPostOrder(String UID_se);

    public List<PresentOrderCoffee> getPresentOrder(String UID_Se);

    public List<OrderDetailDTO> getOrderDetail(String UID_se);

    public String deleteOrderDetail(int review_num);

    String updateOrderDetail(String answer, int review_num);

}
