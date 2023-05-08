export class BaseModel {
    private id: number;
    getId() {
        return this.id;
    } 
    setId(newID: number) {
        this.id = newID;
    }
}