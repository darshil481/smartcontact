package com.example.smartContact.controller;
import com.example.smartContact.model.user;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.smartContact.model.contact;
import com.example.smartContact.repository.contactRepository;
import com.example.smartContact.repository.userRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



@Controller
public class addContactConntroller {
    @Autowired
    private contactRepository contactRepository;
    @Autowired
    private userRepository userRepository;
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
            contact contact = new contact();
            contact.setName(name);
            contact.setWork(work);
            ;
            contact.setNickName(nickName);
            contact.setPhone(phone);
            contact.setImage(filePath);
            contact.setEmail(email);
            contact.setDescription(description);
            // String userEmail= session.getAttribute("email").toString();
            user user = userRepository.findByEmail("darshil@gmail.com");
            contact.setUser(user);
            contactRepository.save(contact);

        return "index1";
     }
}
