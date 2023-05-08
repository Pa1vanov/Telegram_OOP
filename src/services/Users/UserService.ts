import { User } from "../../model/user";
import { BaseService } from "../BaseService";

export interface UserService extends BaseService<User> {
    list: any;
    setSMSCode(smsCode: number, phoneNumber: string): any
    signIn(phoneNumber: string, smsCode: number): User;
}