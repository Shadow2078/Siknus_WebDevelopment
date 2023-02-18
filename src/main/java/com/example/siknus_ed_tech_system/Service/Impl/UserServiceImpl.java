package com.example.siknus_ed_tech_system.Service.Impl;

import com.example.siknus_ed_tech_system.Config.PasswordEncoderUtil;
import com.example.siknus_ed_tech_system.Entity.User;
import com.example.siknus_ed_tech_system.Exception.AppException;
import com.example.siknus_ed_tech_system.Pojo.UserPojo;
import com.example.siknus_ed_tech_system.Repo.UserRepo;
import com.example.siknus_ed_tech_system.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
        private  final UserRepo userRepo;

        @Override
        public UserPojo save(UserPojo userPojo) {
            User user;
            if (userPojo.getId() != null) {
                user = userRepo.findById(userPojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
            } else {
                user = new User();
            }
            user.setEmail(userPojo.getEmail());
            user.setFullname(userPojo.getFullname());
            user.setBirthday(userPojo.getBirthday());
            user.setGender(userPojo.getGender());
            user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));

//            if(userPojo.getImage()!=null){
//                StringBuilder fileNames = new StringBuilder();
//                System.out.println(UPLOAD_DIRECTORY);
//                Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, userPojo.getImage().getOriginalFilename());
//                fileNames.append(userPojo.getImage().getOriginalFilename());
//                Files.write(fileNameAndPath, userPojo.getImage().getBytes());
//                user.setImage(userPojo.getImage().getOriginalFilename());
//            }

            userRepo.save(user);
            return new UserPojo(user);
        }

    @Override
    public User findByEmail(String email) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));
        return user;
    }

    @Override
    public List<User> findAll() {
        return findAllInList(userRepo.findAll());
    }

    public List<User> findAllInList(List<User> list) {
        Stream<User> allJobsWithImage = list.stream().map(user ->
                User.builder()
                        .id(user.getId())
                        .birthday(user.getBirthday())
                        .fullname(user.getFullname())
                        .email(user.getEmail())
                        .gender(user.getGender())
                        .build()
        );
        list = allJobsWithImage.toList();
        return list;
    }


}

