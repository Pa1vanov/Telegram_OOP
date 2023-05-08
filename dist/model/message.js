"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Message = void 0;
const base_1 = require("./base");
class Message extends base_1.BaseModel {
    constructor(fromID, toID, messageText) {
        super();
        this.fromID = fromID;
        this.toID = toID;
        this.messageText = messageText;
    }
}
exports.Message = Message;
