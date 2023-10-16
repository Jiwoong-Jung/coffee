package project.coffee.controller.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.coffee.domain.dto.mypage.OrderDetailDTO;
import project.coffee.domain.dto.mypage.PostOrderCoffee;
import project.coffee.domain.dto.mypage.PresentOrderCoffee;
import project.coffee.service.mypage.MyPageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MyPageController {

    private MyPageService service = null;

    @Autowired
    MyPageController(MyPageService service){
        this.service = service;
    }

    @RequestMapping("/mypage")
    public String mypage(Model model, HttpSession session, HttpServletRequest request) {
        String UID_se = (String)session.getAttribute("UID");
        String flag = request.getParameter("flag");

        List<OrderDetailDTO> review = service.getOrderDetail(UID_se);
        List<PostOrderCoffee> post = service.getPostOrder(UID_se);
        List<PresentOrderCoffee> present = service.getPresentOrder(UID_se);

        model.addAttribute("orderDetail",review);
        model.addAttribute("post",post);
        model.addAttribute("present",present);

        if(flag !=null){
            request.setAttribute("flag",flag);
            int review_num = Integer.parseInt(request.getParameter("rid"));
            request.setAttribute("rid",review_num);
        }

        return "mypage";
    }

    @RequestMapping(value = "/deletereview", method = RequestMethod.GET)
    public String deleteReview(HttpServletRequest request){

        int review_num = Integer.parseInt(request.getParameter("review_num"));
        service.deleteOrderDetail(review_num);

        return "redirect:/mypage";
    }


    @RequestMapping("/updateReviewShow")
    public String updateReviewShow(HttpServletRequest request){
        int review_num = Integer.parseInt(request.getParameter("review_num"));
        request.setAttribute("review_num", review_num);
        return "redirect:mypage?flag=u&rid="+review_num;
    }

    @RequestMapping("/reviewUpdateDo")
    public String reviewUpdateDo(HttpServletRequest request){
        String answer = request.getParameter("answer");
        int review_num = Integer.parseInt(request.getParameter("review_num"));
        String updateReview = service.updateOrderDetail(answer, review_num);
        return "redirect:/mypage";

    }


}
