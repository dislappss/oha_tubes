import "rxjs/Rx";
import {Injectable} from '@angular/core';
import {Jsonp} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {PizzaDetail} from '../models/pizzadetail.model';

@Injectable()

export class PizzaDetailService
{
      private endpoint_url: string =
        "http://localhost:8080/pizzadetails?callback=JSONP_CALLBACK&id=";
    
    constructor (private jsonp: Jsonp){}
    
    getPizzaDetail(id: number): Observable<PizzaDetail> {
        
        console.log("PizzaDetailService.getPizzadetail/" + id);
         
        this.endpoint_url = this.endpoint_url + id;
        
        return this.jsonp.get(this.endpoint_url, 
                { method: 'Get'}
               )
            .map ((responseData) => 
                {               
                    return responseData.json();
                }
            )
            .map((pizzaDetail: PizzaDetail) => 
                {
                    let result: PizzaDetail;
                    if(pizzaDetail)
                    {
                       result = new PizzaDetail(                        
                                    pizzaDetail.id, 
                                    pizzaDetail.name,
                                    pizzaDetail.description,
                                    pizzaDetail.size,
                                    pizzaDetail.price,
                                    pizzaDetail.image
                                );
                    }
                    if(result == null)
                    {
                        console.log("ERROR: result == null");
                    }
                    return result;
                }
            );
    }
}


