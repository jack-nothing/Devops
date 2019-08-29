package com.kechun.controller;


import com.kechun.conf.ContentSet;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@CrossOrigin("*")
public class RoleController {


    @GetMapping("/getRolePageList/{roleId}")
    public ContentSet getRoleList(@PathVariable("roleId") Integer roleId) {


        return ContentSet.getContentSet(200, "", "操作成功");
    }


    @GetMapping("/getRole/{roleId}")
    public ContentSet addRole(@PathVariable("roleId") Integer roleId) {


        return ContentSet.getContentSet(200, "", "操作成功");
    }

    @PostMapping("/addRole")
    public ContentSet addRole() {


        return ContentSet.getContentSet(200, "", "操作成功");
    }

    @PostMapping("/deleRole/{roleId}")
    public ContentSet deleRole(@PathVariable("roleId") Integer roleId) {


        return ContentSet.getContentSet(200, "", "操作成功");
    }

    @PostMapping("/updateAuthRole")
    public ContentSet updateAuthRole() {


        return ContentSet.getContentSet(200, "", "操作成功");
    }
}