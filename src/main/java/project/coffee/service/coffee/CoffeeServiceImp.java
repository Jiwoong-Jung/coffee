package project.coffee.service.coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.coffee.domain.dto.coffee.CoffeeListDTO;
import project.coffee.domain.dto.coffee.OrderCoffeeDTO;
import project.coffee.domain.dto.coffee.OrderDetailDTO;
import project.coffee.domain.dto.coffee.CustomerDTO;

import project.coffee.domain.entity.OrderDetail;
import project.coffee.domain.entity.Customer;
import project.coffee.repository.coffee.CoffeeRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoffeeServiceImp implements CoffeeService {

    CoffeeRepository repository = null;

    @Autowired
    public CoffeeServiceImp(CoffeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void updateOrderDetail(int b_no, String review, String m_id) {

        CustomerDTO userdto = repository.getCustomer(m_id);
        CoffeeListDTO booklistdto = repository.getCoffee(b_no);
        OrderDetailDTO reviewdto = new OrderDetailDTO(booklistdto.getB_no(),booklistdto.getTitle(),userdto.getNickname(),review,m_id,booklistdto.dtoToEntity());

        repository.updateOrderDetail(reviewdto,userdto);
    }

    @Override
    public List<OrderDetailDTO> getOrderDetailList(long b_no) {
        List<OrderDetail> booklist = repository.getCoffeeList(b_no);
        List<OrderDetailDTO> result = new ArrayList();

        OrderDetailDTO review = null;

        for(int i=0; i<booklist.size(); i++){
            String answer = booklist.get(i).getAnswer();
            String nickname = booklist.get(i).getNickname();
            review = new OrderDetailDTO();

            review.setAnswer(answer);
            review.setNickname(nickname);

            result.add(review);
        }

        return result;
    }

    @Override
    public CoffeeListDTO findCoffee(long b_no) {
        return repository.getCoffee(b_no);
    }

    @Override
    public int orderCoffee(String m_id, long b_no) {
        CoffeeListDTO book = findCoffee(b_no);

        OrderCoffeeDTO rentalbookdto = new OrderCoffeeDTO();

        LocalDateTime time = LocalDateTime.now();

        rentalbookdto.setB_no(b_no);
        rentalbookdto.setTitle(book.getTitle());
        rentalbookdto.setR_startdate(time);
        rentalbookdto.setCustomer(Customer.builder().m_id(m_id).build());

        return repository.getMyCoffeeList(rentalbookdto);

    }
    @Override
    public boolean checkLoginHere(HttpServletRequest request, String m_id){
        HttpSession session = request.getSession();
        boolean isExist = false;
        String mid = null;
        if(m_id != null) {
           mid = (String) session.getAttribute("UID");
            if(m_id.equals(mid)){
                isExist=true;
            }
        }
        return isExist;
    }
}
