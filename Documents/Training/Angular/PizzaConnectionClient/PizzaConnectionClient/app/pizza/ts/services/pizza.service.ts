import "rxjs/Rx";
import {Injectable} from '@angular/core';
import {Jsonp} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {Pizza} from '../models/pizza.model';

@Injectable()
export class PizzaService {
    
    private endpoint_url: string =
        "http://localhost:8080/pizzalist?callback=JSONP_CALLBACK";
    
    constructor (private jsonp: Jsonp){}
    
    getPizzaList(): Observable<Array<Pizza>> {
        
        return this.jsonp.get
        (this.endpoint_url, { method: 'Get'})
        .map ((responseData) => 
            {
                console.log("responseData: " + responseData.json());
                return responseData.json();
            }
        )
        .map((pizzaList: Array<any>) => 
            {
                let result: Array<Pizza> = [];
                if(pizzaList)
                {
                    pizzaList.forEach((pizza) => 
                    {
                        console.log("pizza::name = " + pizza.name);
                        result.push(new Pizza(
                                pizza.id, 
                                pizza.name,
                                pizza.size,
                                pizza.price,
                                pizza.image
                            )
                        );
                    });
                }
                if(result)
                {
                    console.log("Anzahl Pizza: " + result.length);
                }
                else
                {
                    console.log("ERROR 123:  + result == null");
                }
                return result;
            }
        );
    }
    
}