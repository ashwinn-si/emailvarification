package eamil.example.emailvarification.Service;

import eamil.example.emailvarification.Entity.UserEntity;
import eamil.example.emailvarification.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    // Generate and save OTP
    public void generateOtp(UserEntity userEntity) {
        int otp = generateRandomOtp(); // Generate a 6-digit OTP
        userEntity.setOtp(otp);
        userRepository.save(userEntity);
    }

    // Generate a 6-digit OTP
    private int generateRandomOtp() {
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }

    // Fetch user by email
    public Optional<UserEntity> getOtp(String email) {
        return userRepository.findByEmail(email);
    }
}
