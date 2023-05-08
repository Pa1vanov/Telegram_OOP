package jk.uz.pdp.service.user;

import jk.uz.pdp.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserServiceImpl implements UserService {
    private Long id = 0L;

    @Override
    public int create(User user) {
        user.setId(id++);
        users.add(user);
        return 1;
    }

    @Override
    public User getById(Long id) {
        for (User u:users) {
            if(u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public User updateById(User update) {
        int i = 0;
        for (User u:users) {
            if(u.getId().equals(update.getId())) {
                users.set(i, update);
                return update;
            }
            i++;
        }
        return null;
    }

    @Override
    public int deleteById(Long id) {
        for (User u:users) {
            if(u.getId().equals(id)) {
                users.remove(u);
                break;
            }
        }
        return 1;
    }

    @Override
    public int setSMSCode(int smsCode, String phoneNumber) {
        for (User u: users) {
            if(u.getPhoneNumber().equals(phoneNumber)) {
                u.setSmsCode(smsCode);
            }
        }
        return 0;
    }

    @Override
    public User signIn(String phoneNumber, int smsCode) {
        for(User u:users) {
            if(u.getPhoneNumber().equals(phoneNumber) && u.getSmsCode() == smsCode) {
                return u;
            }
        }
        return null;
    }

    public ArrayList<User> getUsersByIds(Set<Long> ids) {
        ArrayList<User> userList = new ArrayList<>();

        for (User u:users) {
            if(ids.contains(u.getId())) {
                userList.add(u);
            }
        }
        return userList;
    }

    @Override
    public ArrayList<User> searchByName(String partOfName ) {
        ArrayList<User> foundUsers = new ArrayList<>();
        for(User user:users){
            if (user.getFullName().toLowerCase().contains(partOfName.toLowerCase())) {
                foundUsers.add(user);
            }
        }
        return foundUsers;
    }
}
