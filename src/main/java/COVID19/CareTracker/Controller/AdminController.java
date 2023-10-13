package COVID19.CareTracker.Controller;

import COVID19.CareTracker.Entity.Admin;
import COVID19.CareTracker.Service.AdminService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
@NoArgsConstructor
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/create-account")
    public ResponseEntity <String> createAccount(@RequestBody Admin admin){
        return adminService.createAccount(admin);
    }

    @GetMapping("/sign-in")
    public ResponseEntity <String> logInAsAdmin(@RequestParam String email, @RequestParam String userName, @RequestParam String password, @RequestParam String specialCharacters){
        return adminService.logInAsAdmin(email, userName, password, specialCharacters);
    }

    @PutMapping("/update-account")
    public ResponseEntity <String> updateAdminData(@PathVariable String id, @RequestBody Admin admin){
        return adminService.updateAdminData(id, admin);
    }

}
