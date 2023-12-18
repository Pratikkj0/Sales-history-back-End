package  com.sprint.saleshistory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.saleshistory.dao.UserRepository;
import com.sprint.saleshistory.entities.RolesEntity;
import com.sprint.saleshistory.entities.UserEntity;
import com.sprint.saleshistory.models.AuthPojo;
import com.sprint.saleshistory.models.RolesPojo;
import com.sprint.saleshistory.models.UserPojo;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	JwtService jwtService;
	
	@Override
	public AuthPojo authenticateUser(UserPojo userPojo) {
	
		AuthPojo authModel = new AuthPojo();
		UserEntity fetchedUser = userRepo.findByUserName(userPojo.getUserName());
		if(fetchedUser!=null && fetchedUser.getUserPassword().equals(userPojo.getUserPassword())) {
			List<RolesPojo> allRolesModel = new ArrayList<>();
			for(RolesEntity eachRoles: fetchedUser.getAllRoles()) {	
				RolesPojo roleModel = new RolesPojo();
				BeanUtils.copyProperties(eachRoles, roleModel);
				allRolesModel.add(roleModel);
			}
			userPojo.setAllRoles(allRolesModel);
			authModel.setUser(userPojo);
			System.out.println(userPojo);
			authModel.setToken(jwtService.generateToken(userPojo));
		}else {
			throw new RuntimeException("Invalid Username/password!");
		}
		return authModel;
	}
		
	
}