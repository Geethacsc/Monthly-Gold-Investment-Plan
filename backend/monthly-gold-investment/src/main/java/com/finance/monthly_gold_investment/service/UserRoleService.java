package com.finance.monthly_gold_investment.service;

import com.finance.monthly_gold_investment.dto.UserRoleRequest;
import com.finance.monthly_gold_investment.dto.UserRoleResponse;
import com.finance.monthly_gold_investment.entity.Role;
import com.finance.monthly_gold_investment.entity.User;
import com.finance.monthly_gold_investment.entity.UserRole;
import com.finance.monthly_gold_investment.repo.RoleRepository;
import com.finance.monthly_gold_investment.repo.UserRepository;
import com.finance.monthly_gold_investment.repo.UserRoleRepository;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final UserRoleRepository userRoleRepository;

	public UserRoleService(UserRepository userRepository, RoleRepository roleRepository,
			UserRoleRepository userRoleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.userRoleRepository = userRoleRepository;
	}

	// ---------------- CREATE -----------------------------------
	public UserRoleResponse assignRole(UserRoleRequest request) {

		User user = userRepository.findById(request.getUserId())
				.orElseThrow(() -> new RuntimeException("User not found"));

		Role role = roleRepository.findById(request.getRoleId())
				.orElseThrow(() -> new RuntimeException("Role not found"));

		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		userRole.setAssignedAt(new Timestamp(System.currentTimeMillis()));
		userRole.setAssignedBy(request.getAssignedBy());
		userRole.setAssignmentSource(request.getAssignmentSource());
		userRole.setExpiresAt(request.getExpiresAt());

		userRoleRepository.save(userRole);
		return mapToResponse(userRole);
	}

	// ---------------- READ (All User Roles) -------------------
	public List<UserRoleResponse> getRolesForUser(Long userId) {
		return userRoleRepository.findByUserId(userId).stream().map(this::mapToResponse).collect(Collectors.toList());
	}

	// ---------------- READ (Single) ----------------------------
	public UserRoleResponse getById(Long id) {
		return userRoleRepository.findById(id).map(this::mapToResponse)
				.orElseThrow(() -> new RuntimeException("UserRole not found"));
	}

	// ---------------- UPDATE -----------------------------------
	public UserRoleResponse updateRole(Long id, UserRoleRequest request) {

		UserRole userRole = userRoleRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("UserRole not found"));

		if (request.getRoleId() != null) {
			Role role = roleRepository.findById(request.getRoleId())
					.orElseThrow(() -> new RuntimeException("Role not found"));
			userRole.setRole(role);
		}

		userRole.setAssignedBy(request.getAssignedBy());
		userRole.setAssignmentSource(request.getAssignmentSource());
		userRole.setExpiresAt(request.getExpiresAt());

		userRoleRepository.save(userRole);
		return mapToResponse(userRole);
	}

	// ---------------- DELETE -----------------------------------
	public void deleteRole(Long id) {
		if (!userRoleRepository.existsById(id)) {
			throw new RuntimeException("UserRole not found");
		}
		userRoleRepository.deleteById(id);
	}

	// ---------------- Mapper ------------------------------------
	private UserRoleResponse mapToResponse(UserRole ur) {

		UserRoleResponse userRoleResponse = new UserRoleResponse();
		userRoleResponse.setId(ur.getId());
		userRoleResponse.setUserId(ur.getUser().getId());
		userRoleResponse.setRoleId(ur.getRole().getId());
		userRoleResponse.setAssignedAt(ur.getAssignedAt());
		userRoleResponse.setAssignedBy(ur.getAssignedBy());
		userRoleResponse.setAssignmentSource(ur.getAssignmentSource());
		userRoleResponse.setExpiresAt(ur.getExpiresAt());

		return userRoleResponse;
	}
}
