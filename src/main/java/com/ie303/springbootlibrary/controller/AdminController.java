package com.ie303.springbootlibrary.controller;

import com.ie303.springbootlibrary.requestmodels.AddBookRequest;
import com.ie303.springbootlibrary.service.AdminService;
import com.ie303.springbootlibrary.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://54.151.185.48:80")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @PutMapping("secure/increase/book/quantity")
    public void increaseBookQuantity(@RequestHeader(value = "Authorization") String token,
                                     @RequestParam Long bookId) throws Exception{
        String admin = ExtractJWT.payloadJWTExtraction(token, "\"userType\"");
        if (admin == null || !admin.equals("admin")){
            throw new Exception("Administration page only");
        }
        adminService.increaseBookQuantity(bookId);
    }

    @PutMapping("secure/decrease/book/quantity")
    public void decreaseBookQuantity(@RequestHeader(value = "Authorization") String token,
                                     @RequestParam Long bookId) throws Exception{
        String admin = ExtractJWT.payloadJWTExtraction(token, "\"userType\"");
        if (admin == null || !admin.equals("admin")){
            throw new Exception("Administration page only");
        }
        adminService.decreaseBookQuantity(bookId);
    }

    @PostMapping("secure/add/book")
    public void postBook(@RequestHeader(value = "Authorization") String token,
                       @RequestBody AddBookRequest addBookRequest) throws Exception{
        String admin = ExtractJWT.payloadJWTExtraction(token, "\"userType\"");
        if (admin == null || !admin.equals("admin")){
            throw new Exception("Administration page only");
        }

        adminService.postBook(addBookRequest);
    }

    @DeleteMapping("secure/delete/book")
    public void deleteBook(@RequestHeader(value = "Authorization") String token,
                         @RequestParam Long bookId) throws Exception{
        String admin = ExtractJWT.payloadJWTExtraction(token, "\"userType\"");
        if (admin == null || !admin.equals("admin")){
            throw new Exception("Administration page only");
        }

        adminService.deleteBook(bookId);
    }
}
