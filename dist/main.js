"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const message_1 = require("./model/message");
const user_1 = require("./model/user");
const UserServiceImpl_1 = require("./services/Users/UserServiceImpl");
const MessageServiceImpl_1 = require("./services/message/MessageServiceImpl");
const UserService = new UserServiceImpl_1.UserServiceImp();
const MessageService = new MessageServiceImpl_1.MessageServiceImp();
const jack = new user_1.User("Jack Wilson", 123, "+1 200 300 7585", "_Jack_");
const john = new user_1.User("John Wick", 1234, "+1 200 299 7585");
const bill = new user_1.User("Bill Bobson", 12, "+1 900 300 7585", "BOB_Lazy");
const billy = new user_1.User("Bill Bobson", 23, "+1 950 300 7585", "BIlly_");
const robertson = new user_1.User("Bil Robertson", 34, "+1 901 300 7585");
const robert = new user_1.User("Robert Bilandowski", 45, "+1 900 400 7585", "RoBeRt");
UserService.create(jack, john, bill, billy, robertson, robert);
const messageByJack = new message_1.Message(jack.getId(), john.getId(), "Hey whats up");
const messageByJohn = new message_1.Message(john.getId(), jack.getId(), "Good, how about you?");
const messageByBill = new message_1.Message(bill.getId(), billy.getId(), "Hey billy do you've done you homewrok from English");
const messageByBilly = new message_1.Message(billy.getId(), bill.getId(), "No, I haven't yet");
const messageByRobertson = new message_1.Message(robertson.getId(), robert.getId(), "Robert can you help me, please");
const messageByRobert = new message_1.Message(robert.getId(), robertson.getId(), "Sorry, I'm busy now, I will help you later");
MessageService.create(messageByJack, messageByJohn, messageByBill, messageByBilly, messageByRobertson, messageByRobert);
function chattingPleace(userID) {
    const messages = MessageService.chats(userID);
    const chatingArr = [];
    for (let message of messages) {
        let messagee = `${UserService.getById(message.fromID).fullname}  ||==>>  ${message.messageText}  ||==>>  ${UserService.getById(message.toID).fullname}`;
        chatingArr.push(messagee);
    }
    return chatingArr;
}
function chatbySenderToReciver(senderID, receiverID) {
    const messagee = MessageService.getByUserIdAndReceiverId(senderID, receiverID);
    const chatingArr = [];
    for (let i = 0; i < messagee.length; i++) {
        let senderName = UserService.getById(messagee[i].fromID).fullname;
        let receiverName = UserService.getById(messagee[i].toID).fullname;
        let message = messagee[i].messageText;
        chatingArr.push(`${senderName}  ||==>>  ${message}  ||==>>  ${receiverName}`);
    }
    return chatingArr;
}
const chattingHistory = chattingPleace(john.getId());
console.log(chattingHistory);
const messagesWithPartner = chatbySenderToReciver(robert.getId(), robertson.getId());
console.log(messagesWithPartner);
