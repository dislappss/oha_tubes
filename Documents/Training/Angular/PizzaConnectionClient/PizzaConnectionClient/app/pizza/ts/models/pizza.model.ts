export class Pizza
{
    private _id: number;
    private _name: string;
    private _size: string;
    private _price: number;
    private _image: string;
    
    constructor (
        id: number,
        name: string,
        size: string,
        price: number,
        image: string
    )
    {
        this._id = id;
        this._name=name;
        this._size = size;
        this._price = price;
        this._image = image;
    }
    
    get id(): number { return this._id;}
    set id(value: number) { this._id = value;}
    
    get name(): string { return this._name;}
    set name(value: string) { this._name = value;}
    
    get size(): string { return this._size;}
    set size(value: string) { this._size = value;}
    
    get price(): number { return this._price;}
    set price(value: number) { this._price = value;}
    
    get image(): string { return this._image;}
    set image(value: string) { this._image = value;}
}
 
