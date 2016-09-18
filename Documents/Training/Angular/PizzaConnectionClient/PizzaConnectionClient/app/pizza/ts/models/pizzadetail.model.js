"use strict";
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
var pizza_model_1 = require('./pizza.model');
var PizzaDetail = (function (_super) {
    __extends(PizzaDetail, _super);
    function PizzaDetail(id, name, description, size, price, image) {
        _super.call(this, id, name, size, price, image);
        this._description = description;
    }
    Object.defineProperty(PizzaDetail.prototype, "description", {
        get: function () { return this._description; },
        set: function (value) { this._description = value; },
        enumerable: true,
        configurable: true
    });
    return PizzaDetail;
}(pizza_model_1.Pizza));
exports.PizzaDetail = PizzaDetail;
//# sourceMappingURL=pizzadetail.model.js.map