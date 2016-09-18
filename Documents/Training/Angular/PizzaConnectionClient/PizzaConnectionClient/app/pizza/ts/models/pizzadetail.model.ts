import {Pizza} from './pizza.model';

export class PizzaDetail extends Pizza
{
    private _description: string;
    
    constructor (
        id: number,
        name: string,
        description: string,
        size: string,
        price: number,
        image: string
    )
    {
        super(
            id,
            name,           
            size,
            price,
            image);
        
        this._description = description;
    }
    
    get description(): string  { return this._description;}
    set description(value: string) { this._description = value;}
    
}


