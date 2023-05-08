import { User } from "../../model/user";
import { UserService } from "./UserService";

export class UserServiceImp implements UserService {
  list: User[] = [];
  
  private counterID = 0;
  
    create(...data: User[]) {
      for (let user of data) {
        user.setId(++this.counterID);
        this.list.push(user);
      }
    }
  
    getById(id: number) {
      for (let user of this.list) {
        if (user.getId() === id) {
          return user;
        }
      }
  
      throw new Error("User not found");
    }
  
    updateById(update: User, messageId: number) {
      let i = 0;
      for (let u of this.list) {
        if(u.getId() === update.getId()) {
          u = update;
          return update;
        }
        i++;
      }
    }
  
    deleteById(id: number) {
      for (let user of this.list) {
        if (user.getId() === id) {
          this.list.splice(this.list.indexOf(user), 1);
        }
      }
    }
  
    setSMSCode(smsCode: number, phoneNumber: string) {
      for (let user of this.list) {
        if (user.phoneNumber === phoneNumber) {
          user.smsCode = smsCode;
          return 0;
        }
      }
  
      throw new Error("This phone number does not exist");
    }
  
    signIn(phoneNumber: string, smsCode: number): User {
      for (let user of this.list) {
        if (user.phoneNumber === phoneNumber && user.smsCode === smsCode) {
          return user;
        }
      }
  
      throw new Error("Password or PhoneNumber is wrong");
    }
  
  }
  