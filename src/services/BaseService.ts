export interface BaseService<myType> {
    create(data: myType): any;

    getById(id: number): any;

    updateById(update: myType, messageId: number): any;
    deleteById(id: number): any;
}
