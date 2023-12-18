package com.sprint.saleshistory.service;

import com.sprint.saleshistory.models.AuthPojo;
import com.sprint.saleshistory.models.UserPojo;

public interface UserService {
	AuthPojo authenticateUser(UserPojo userPojo);
}
