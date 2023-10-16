package project.coffee.service.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.coffee.domain.dto.mypage.OrderDetailDTO;
import project.coffee.domain.dto.mypage.PostOrderCoffee;
import project.coffee.domain.dto.mypage.PresentOrderCoffee;
import project.coffee.domain.entity.OrderCoffee;
import project.coffee.domain.entity.OrderDetail;
import project.coffee.repository.mypage.MyPageRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyPageServiceImp implements MyPageService{

    MyPageRepository repository = null;

    @Autowired
    public MyPageServiceImp(MyPageRepository repository) {
        this.repository = repository;
    }

    public List<PostOrderCoffee> getPostOrder(String UID_se){
        List<OrderCoffee> rental = repository.getOrder(UID_se);
        List<PostOrderCoffee> post = new ArrayList();
        PostOrderCoffee book = null;
        LocalDateTime now = LocalDateTime.now();



        for(int i=rental.size()-1; i>=0; i--){
            if(now.isAfter(rental.get(i).getR_enddate())){
                book = new PostOrderCoffee(rental.get(i));
                post.add(book);
            }
        }
        return post;
    }

    public List<PresentOrderCoffee> getPresentOrder(String UID_se){
        List<OrderCoffee> rental = repository.getOrder(UID_se);
        List<PresentOrderCoffee> present = new ArrayList();
        PresentOrderCoffee book = null;
        LocalDateTime now = LocalDateTime.now();



        for(int i=0; i<rental.size(); i++){
            if(now.isBefore(rental.get(i).getR_enddate())){
                book = new PresentOrderCoffee(rental.get(i));
                present.add(book);
            }
        }
        return present;
    }

    public List<OrderDetailDTO> getOrderDetail(String UID_se){


        List<OrderDetailDTO> result = new ArrayList();
        List<OrderDetail> temp = repository.getOrderDetail(UID_se);


        OrderDetailDTO dto;

        for(int i=0; i<temp.size(); i++){
            dto = new OrderDetailDTO(temp.get(i));

            result.add(dto);
        }

        return result;
    }

    @Transactional
    public String deleteOrderDetail(int review_num){
        String delete = repository.deleteOrderDetail(review_num);
        return "delete";
    }

    @Transactional
    public String updateOrderDetail(String answer,int review_num){
        String update= repository.updateOrderDetail(answer,review_num);
        return "update";
    }
}
