package project.coffee.service.regist;

import org.springframework.stereotype.Service;
import project.coffee.domain.entity.Customer;
import project.coffee.repository.regist.CustomerRepository;

import java.util.List;

@Service
public class RegistService {
    private final CustomerRepository customerRepository;

    public RegistService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //user 정보 저장
    public void regist(Customer customer){
        customerRepository.save(customer);
    }

    /*모든데이터 받아온 것을 idList에 저장
    새로 입력된 id 와 list 내의 id값을 비교해서 같으면 break/ 다르면 checkNum에 숫자 추가
    checkNum의 숫자랑 idList 숫자가 다르면(동일 id값이면) false/ 아니면 true
    */
    public String checkId(String id){
        List<Customer> idList = customerRepository.findAll();
        int checkNum = 0;
        String returnChk = "true";
        for (Customer list : idList) {
            if ((list.getM_id()).equals(id)) {
                break;
            } else {
                checkNum += 1;
            }
        }
        if (checkNum != idList.size()) {
            returnChk =  "false";
        }
        return returnChk;
    }

    //닉네임 동일할시
    public String checkNick(String nickname){
        List<Customer> idList = customerRepository.findAll();
        int checkNum = 0;
        String returnChk = "true";
        for (Customer list : idList) {
            if ((list.getNickname()).equals(nickname)) {
                break;
            } else {
                checkNum += 1;
            }
        }
        if (checkNum != idList.size()) {
            returnChk =  "false";
        }
        return returnChk;
    }
}
