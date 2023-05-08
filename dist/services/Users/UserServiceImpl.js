"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.UserServiceImp = void 0;
class UserServiceImp {
    constructor() {
        this.list = [];
        this.counterID = 0;
    }
    create(...data) {
        for (let user of data) {
            user.setId(++this.counterID);
            this.list.push(user);
        }
    }
    getById(id) {
        for (let user of this.list) {
            if (user.getId() === id) {
                return user;
            }
        }
        throw new Error("User not found");
    }
    updateById(update, messageId) {
        let i = 0;
        for (let u of this.list) {
            if (u.getId() === update.getId()) {
                u = update;
                return update;
            }
            i++;
        }
    }
    deleteById(id) {
        for (let user of this.list) {
            if (user.getId() === id) {
                this.list.splice(this.list.indexOf(user), 1);
            }
        }
    }
    setSMSCode(smsCode, phoneNumber) {
        for (let user of this.list) {
            if (user.phoneNumber === phoneNumber) {
                user.smsCode = smsCode;
                return 0;
            }
        }
        throw new Error("This phone number does not exist");
    }
    signIn(phoneNumber, smsCode) {
        for (let user of this.list) {
            if (user.phoneNumber === phoneNumber && user.smsCode === smsCode) {
                return user;
            }
        }
        throw new Error("Password or PhoneNumber is wrong");
    }
}
exports.UserServiceImp = UserServiceImp;
