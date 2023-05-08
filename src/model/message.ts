import { BaseModel } from "./base";

export class Message extends BaseModel {
    constructor(public fromID: number, public toID: number, public messageText: string) {
        super();
    }
}
