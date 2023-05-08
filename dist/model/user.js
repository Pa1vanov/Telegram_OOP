"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.User = void 0;
const base_1 = require("./base");
class User extends base_1.BaseModel {
    constructor(fullname, smsCode, phoneNumber, username) {
        super();
        this.fullname = fullname;
        this.smsCode = smsCode;
        this.phoneNumber = phoneNumber;
        this.username = username;
    }
}
exports.User = User;
