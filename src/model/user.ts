import { BaseModel } from "./base";

export class User extends BaseModel {
  constructor(public fullname: string, public smsCode: number, public phoneNumber: string, public username?: string) {
    super();
  }
}