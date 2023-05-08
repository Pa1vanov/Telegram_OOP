import { Message } from "../../model/message";
import { BaseService } from "../BaseService";

export interface MessageService extends BaseService<Message>{
    list: any;
    getByUserIdAndReceiverId(userID: number, receiverID: number):any;
}