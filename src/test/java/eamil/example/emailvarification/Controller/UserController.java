package eamil.example.emailvarification.Controller;

import eamil.example.emailvarification.Entity.UserEntity;
import eamil.example.emailvarification.Service.UserService;
import org.apache.catalina.User;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/generatringOtp")
    public String generateOtp(@ModelAttribute UserEntity userEntity,Model model){

        userService.generateOtp(userEntity);
        model.addAttribute("email",userEntity.getEmail());
        return "otpVerfiyingtemplate";
    }

    @PostMapping("/verifyOtp")
    public String verifyOtp(@RequestParam("email") String email,@RequestParam("otp") int otp, Model model){
        Optional<UserEntity> userOptional = userService.getOtp(email);
        UserEntity user=userOptional.get(); //doubt
        int originalOtp=user.getOtp();
        if (otp == originalOtp) {
            model.addAttribute("result", "OTP is correct!");
        } else {
            model.addAttribute("result", "OTP is incorrect!");
        }
        return "otpgeneratedTemplate";
    }
}
