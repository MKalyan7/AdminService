package com.agis.AdminService.controller;

import com.agis.AdminService.model.PermissionRequest;
import com.agis.AdminService.model.PermissionResponse;
import com.agis.AdminService.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/permission")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @PostMapping("/createPermission")
    public long createPermission(@RequestBody PermissionRequest permissionRequest) {
        return permissionService.createNewPermission(permissionRequest);
    }
    @PutMapping("/updatePermission")
    public ResponseEntity<PermissionResponse> UpdatePermission(@RequestBody PermissionRequest permissionRequest){
        PermissionResponse permissionResponse = permissionService.updatePermission(permissionRequest);
        return  new ResponseEntity<>(permissionResponse, HttpStatus.OK);
    }

    @GetMapping("/getPermissionsList")
    public ResponseEntity<List<PermissionResponse>> getPermissionsList() {
        List<PermissionResponse> permissionResponseList = permissionService.getPermissions();
         return new ResponseEntity<>(permissionResponseList,HttpStatus.OK);
    }

    @GetMapping("/getPermissionDetail/{id}")
    public ResponseEntity<PermissionResponse> getPermissionDetail(@PathVariable("id") long permissionId) {
        PermissionResponse permissionResponse = permissionService.getPermissionDetail(permissionId);
        return new ResponseEntity<>(permissionResponse,HttpStatus.OK);

    }



}
