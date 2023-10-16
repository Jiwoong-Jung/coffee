package project.coffee.repository.mypage;

import project.coffee.domain.entity.OrderCoffee;
import project.coffee.domain.entity.OrderDetail;

import java.util.List;

public interface MyPageRepository {

    List<OrderCoffee> getOrder(String UID_se);

    public List<OrderDetail> getOrderDetail(String UID_se);

    public String deleteOrderDetail(int review_num);

    public String updateOrderDetail(String answer,int review_num);
}
