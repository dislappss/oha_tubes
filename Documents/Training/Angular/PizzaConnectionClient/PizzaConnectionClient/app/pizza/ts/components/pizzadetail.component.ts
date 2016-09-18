import {Component} from '@angular/core';
import {PizzaDetail} from '../models/pizzadetail.model';
import {PizzaDetailService} from '../services/pizzadetail.service';
import {ActivatedRoute} from "@angular/router";
import {Button} from "primeng/primeng";
import {Location} from "@angular/common";

@Component
({
    selector: 'pizzadetail',
    templateUrl: 'app/pizza/templates/pizzadetail.html',
    styleUrls: ['app/css/styles.css'],
    providers: [PizzaDetailService],
    directives: [Button]
})

export class PizzaDetailComponent{
    
    _pizzaDetail: PizzaDetail;
    
    constructor(
        private _pizzaDetailService: PizzaDetailService,
        private _route: ActivatedRoute,
        private _location: Location)
    {
        let id = this._route.snapshot.params['id'];
        this._pizzaDetailService.getPizzaDetail(id).subscribe
        (
            pizzaDetail => {
                this._pizzaDetail = pizzaDetail;
            },
            err => console.error(err),
            () => console.log('done: ' + this._pizzaDetail.image)
        );
    }
    
    addToCart(pizzaDetail: PizzaDetail)
    {
        console.log("Eine Pizza wurde in den Warenkorb gelegt: " 
                    + pizzaDetail.name);
    }
    
    historyBack()
    {
        this._location.back();
    }
    
    get pizzaDetail():PizzaDetail
    {
        return this._pizzaDetail;
    }
}  