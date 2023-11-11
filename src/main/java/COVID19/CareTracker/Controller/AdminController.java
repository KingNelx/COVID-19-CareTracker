package COVID19.CareTracker.Controller;

import COVID19.CareTracker.Entity.Admin;
import COVID19.CareTracker.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/create-account")
    public ResponseEntity <String> createAccount(@RequestBody Admin admin){
        return adminService.createAdminAccount(admin);
    }

    @GetMapping("/log-in")
    public ResponseEntity <String> adminLogIn(@RequestParam String adminEmail, @RequestParam String adminUser, @RequestParam String adminPassword, @RequestParam String adminSpecialCharacter){
       return adminService.logInAsAdmin(adminEmail, adminUser, adminPassword, adminSpecialCharacter);
    }

    @GetMapping("/queryAll")
    public List <Admin> queryAdmins(){
        return adminService.queryAdmins();
    }
}
