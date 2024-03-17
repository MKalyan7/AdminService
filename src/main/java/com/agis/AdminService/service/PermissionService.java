package com.agis.AdminService.service;

import com.agis.AdminService.model.PermissionRequest;
import com.agis.AdminService.model.PermissionResponse;

import java.util.List;

public interface PermissionService {
    long createNewPermission(PermissionRequest permissionRequest);

    PermissionResponse updatePermission(PermissionRequest permissionRequest);

    List<PermissionResponse> getPermissions();

    PermissionResponse getPermissionDetail(long permissionId);
}
