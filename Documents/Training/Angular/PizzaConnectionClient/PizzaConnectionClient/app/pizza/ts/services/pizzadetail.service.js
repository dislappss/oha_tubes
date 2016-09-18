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
var pizzadetail_model_1 = require('../models/pizzadetail.model');
var PizzaDetailService = (function () {
    function PizzaDetailService(jsonp) {
        this.jsonp = jsonp;
        this.endpoint_url = "http://localhost:8080/pizzadetails?callback=JSONP_CALLBACK&id=";
    }
    PizzaDetailService.prototype.getPizzaDetail = function (id) {
        console.log("PizzaDetailService.getPizzadetail/" + id);
        this.endpoint_url = this.endpoint_url + id;
        return this.jsonp.get(this.endpoint_url, { method: 'Get' })
            .map(function (responseData) {
            return responseData.json();
        })
            .map(function (pizzaDetail) {
            var result;
            if (pizzaDetail) {
                result = new pizzadetail_model_1.PizzaDetail(pizzaDetail.id, pizzaDetail.name, pizzaDetail.description, pizzaDetail.size, pizzaDetail.price, pizzaDetail.image);
            }
            if (result == null) {
                console.log("ERROR: result == null");
            }
            return result;
        });
    };
    PizzaDetailService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Jsonp])
    ], PizzaDetailService);
    return PizzaDetailService;
}());
exports.PizzaDetailService = PizzaDetailService;
//# sourceMappingURL=pizzadetail.service.js.map