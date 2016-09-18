"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var router_1 = require("@angular/router");
var pizza_service_1 = require('../services/pizza.service');
var primeng_1 = require('primeng/primeng');
var PizzaListComponent = (function () {
    function PizzaListComponent(_pizzaService, _router) {
        var _this = this;
        this._pizzaService = _pizzaService;
        this._router = _router;
        this._pizzaService.getPizzaList().subscribe(function (res) { return _this.pizzaList = res; });
    }
    PizzaListComponent.prototype.getPizzaList = function () {
        return this.pizzaList;
    };
    PizzaListComponent.prototype.showDetails = function (pizza) {
        this._router.navigate(['pizzadetail', pizza.id]);
    };
    PizzaListComponent = __decorate([
        core_1.Component({
            selector: 'pizzalist',
            templateUrl: 'app/pizza/templates/pizzalist.html',
            styleUrls: ['app/css/styles.css'],
            providers: [pizza_service_1.PizzaService],
            directives: [primeng_1.DataGrid, primeng_1.Panel]
        }), 
        __metadata('design:paramtypes', [pizza_service_1.PizzaService, router_1.Router])
    ], PizzaListComponent);
    return PizzaListComponent;
}());
exports.PizzaListComponent = PizzaListComponent;
//# sourceMappingURL=pizzalist.component.js.map