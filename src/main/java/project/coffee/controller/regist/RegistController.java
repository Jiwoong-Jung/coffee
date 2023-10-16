package project.coffee.controller.regist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.coffee.domain.dto.regist.RegistForm;
import project.coffee.domain.entity.Customer;
import project.coffee.service.regist.RegistService;

@Controller
public class RegistController {
    private final RegistService registService;

    public RegistController(RegistService registService) {
        this.registService = registService;
    }

    @GetMapping("/regist")
    public String regist() {
        return "regist";
    }

    @PostMapping("/registconfirm")
    public String registconfirm(RegistForm form){
        String returnPage;
            Customer customer = new Customer();
            customer.setM_id(form.getM_id());
            customer.setM_pw(form.getM_pw());
            customer.setM_name(form.getM_name());
            customer.setGender(form.isGender());
            customer.setNickname(form.getNickname());
            registService.regist(customer);
            returnPage = "registconfirm";
        return returnPage;
    }

    @PostMapping("/idcheck")
    @ResponseBody //이게 없었더니 오류남
    public String checkIdExist(String id) { //매개변수를 "id" :$("#m_id").val() 에서 id와 같게 설정해줘야함
        String result1 = registService.checkId(id);
        return result1;
    }

    @PostMapping("/nickcheck")
    @ResponseBody
    public String checkNickExist(String nickname) {
        String result2 = registService.checkNick(nickname);
        return result2;
    }
}



