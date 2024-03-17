package com.agis.AdminService.service;

import com.agis.AdminService.entity.Permission;
import com.agis.AdminService.model.PermissionRequest;
import com.agis.AdminService.model.PermissionResponse;
import com.agis.AdminService.repository.PermissionRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    PermissionRepository permissionRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public long createNewPermission(PermissionRequest permissionRequest) {

        log.info("Creating New Permission:  {} ",permissionRequest);
        Permission permission = Permission.builder().
            name(permissionRequest.getName())
                .description(permissionRequest.getDescription()).build();
        permissionRepository.save(permission);
        log.info("New Permission got created and got saved in DB");
        return permission.getPermissionId();
    }

    @Override
    public PermissionResponse updatePermission(PermissionRequest permissionRequest) {
        log.info("Updating  Permission:  {} ",permissionRequest);
        Permission permission = Permission.builder().
                permissionId(permissionRequest.getId())
                .name(permissionRequest.getName())
                .description(permissionRequest.getDescription()).build();
        permissionRepository.save(permission);
        PermissionResponse permissionResponse = PermissionResponse.builder()
                .permissionId(permission.getPermissionId())
                .name(permission.getName())
                .description(permission.getDescription()).build();
        return permissionResponse;
    }

    @Override
    public List<PermissionResponse> getPermissions() {
        List<Permission> permissions = permissionRepository.findAll();
        List<PermissionResponse> responses = permissions.stream().map(permission -> modelMapper.map(permission,PermissionResponse.class)).collect(Collectors.toList());
        return responses;
    }

    @Override
    public PermissionResponse getPermissionDetail(long permissionId) {
        Permission permission = permissionRepository.getReferenceById(permissionId);
        PermissionResponse permissionResponse = modelMapper.map(permission,PermissionResponse.class);
        return permissionResponse;
    }
}
