import { Message } from "./model/message";
import { User } from "./model/user";
import { UserServiceImp } from "./services/Users/UserServiceImpl";
import { MessageServiceImp } from "./services/message/MessageServiceImpl";

const UserService = new UserServiceImp();
const MessageService = new MessageServiceImp();

const jack = new User("Jack Wilson", 123, "+1 200 300 7585", "_Jack_");
const john = new User("John Wick", 1234, "+1 200 299 7585");
const bill = new User("Bill Bobson", 12, "+1 900 300 7585", "BOB_Lazy");
const billy = new User("Bill Bobson", 23, "+1 950 300 7585", "BIlly_");
const robertson = new User("Bil Robertson", 34, "+1 901 300 7585");
const robert = new User("Robert Bilandowski", 45, "+1 900 400 7585", "RoBeRt");

UserService.create(jack, john, bill, billy, robertson, robert);

const messageByJack = new Message(jack.getId(), john.getId(), "Hey whats up");
const messageByJohn = new Message(john.getId(), jack.getId(), "Good, how about you?");
const messageByBill = new Message(bill.getId(), billy.getId(), "Hey billy do you've done you homewrok from English");
const messageByBilly = new Message(billy.getId(), bill.getId(), "No, I haven't yet");
const messageByRobertson = new Message(robertson.getId(), robert.getId(), "Robert can you help me, please");
const messageByRobert = new Message(robert.getId(), robertson.getId(), "Sorry, I'm busy now, I will help you later");

MessageService.create(messageByJack, messageByJohn, messageByBill, messageByBilly, messageByRobertson, messageByRobert);


function chattingPleace(userID: number) {
    const messages = MessageService.chats(userID);
    const chatingArr: string[] = [];
    for (let message of messages) {
        let messagee: string = `${UserService.getById(message.fromID).fullname}  ||==>>  ${message.messageText}  ||==>>  ${UserService.getById(message.toID).fullname}`;
        chatingArr.push(messagee);
    }
    return chatingArr;
}

function chatbySenderToReciver(senderID: number, receiverID: number) {
    const messagee = MessageService.getByUserIdAndReceiverId(senderID, receiverID);
    const chatingArr: string[] = [];
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









