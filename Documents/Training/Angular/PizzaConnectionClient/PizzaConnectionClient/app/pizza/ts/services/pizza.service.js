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
require("rxjs/Rx");
var core_1 = require('@angular/core');
var http_1 = require('@angular/http');
var pizza_model_1 = require('../models/pizza.model');
var PizzaService = (function () {
    function PizzaService(jsonp) {
        this.jsonp = jsonp;
        this.endpoint_url = "http://localhost:8080/pizzalist?callback=JSONP_CALLBACK";
    }
    PizzaService.prototype.getPizzaList = function () {
        return this.jsonp.get(this.endpoint_url, { method: 'Get' })
            .map(function (responseData) {
            console.log("responseData: " + responseData.json());
            return responseData.json();
        })
            .map(function (pizzaList) {
            var result = [];
            if (pizzaList) {
                pizzaList.forEach(function (pizza) {
                    console.log("pizza::name = " + pizza.name);
                    result.push(new pizza_model_1.Pizza(pizza.id, pizza.name, pizza.size, pizza.price, pizza.image));
                });
            }
            if (result) {
                console.log("Anzahl Pizza: " + result.length);
            }
            else {
                console.log("ERROR 123:  + result == null");
            }
            return result;
        });
    };
    PizzaService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Jsonp])
    ], PizzaService);
    return PizzaService;
}());
exports.PizzaService = PizzaService;
//# sourceMappingURL=pizza.service.js.map