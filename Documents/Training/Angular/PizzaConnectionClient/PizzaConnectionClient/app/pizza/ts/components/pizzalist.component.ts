import {Component} from '@angular/core';
import {Router} from "@angular/router";
import {PizzaService} from '../services/pizza.service';
import {Pizza} from '../models/pizza.model';
import {DataGrid, Panel} from 'primeng/primeng';

@Component ({
    selector: 'pizzalist',
    templateUrl: 'app/pizza/templates/pizzalist.html',
    styleUrls: ['app/css/styles.css'],
    providers: [PizzaService],
    directives: [DataGrid, Panel]
})

export class PizzaListComponent{
    
    private pizzaList: Array<Pizza>;
    
    constructor(
        private _pizzaService: PizzaService,
        private _router: Router )
    {
        this._pizzaService.getPizzaList().subscribe(
            res => this.pizzaList = res
        );
    }
    
    getPizzaList()
    {
        return this.pizzaList;
    }
    
    showDetails(pizza: Pizza)
    {
        this._router.navigate(['pizzadetail', pizza.id])
    }
}


