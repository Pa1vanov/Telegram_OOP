package jk.uz.pdp.service.user;

import jk.uz.pdp.model.User;
import jk.uz.pdp.service.BaseService;

import java.util.ArrayList;

public interface UserService extends BaseService<User> {
    
    ArrayList<User> users = new ArrayList<>();

    int setSMSCode(int smsCode, String phoneNumber);

    User signIn(String phoneNumber, int smsCode);

    ArrayList<User> searchByName(String name);
}