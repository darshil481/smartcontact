package com.example.smartContact.controller;
import com.example.smartContact.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.smartContact.model.Contact;
import com.example.smartContact.repository.contactRepository;
import com.example.smartContact.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;


@Controller
public class addContactConntroller {
    @Autowired
    private contactRepository contactRepository;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/adding")
     public String solve(HttpSession session ,@RequestParam("name") String name,@RequestParam("nickName") String nickName,@RequestParam("work") String work,@RequestParam("email") String email,@RequestParam("description") String description,@RequestParam("phone") String phone, @RequestParam("image") MultipartFile file ) throws IOException {

            String fileName = file.getOriginalFilename();
            long timestamp = System.currentTimeMillis();
            String timestampStr = Long.toString(timestamp);
            String filePath = "images/" + fileName + timestampStr;
            File f = new File("images/");
            if (!f.exists()) {
                f.mkdir();
            }
            Files.copy(file.getInputStream(), Paths.get(filePath));
            Contact contact = new Contact();
            contact.setName(name);
            contact.setWork(work);
            ;
            contact.setNickName(nickName);
            contact.setPhone(phone);
            contact.setImage(filePath);
            contact.setEmail(email);
            contact.setDescription(description);
            // String userEmail= session.getAttribute("email").toString();
            Optional<User> user = userRepository.findByEmail("darshil@gmail.com");
            contact.setUser(user.get());
            contactRepository.save(contact);

        return "index1";
     }
}
