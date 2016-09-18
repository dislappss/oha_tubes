"use strict";
var Pizza = (function () {
    function Pizza(id, name, size, price, image) {
        this._id = id;
        this._name = name;
        this._size = size;
        this._price = price;
        this._image = image;
    }
    Object.defineProperty(Pizza.prototype, "id", {
        get: function () { return this._id; },
        set: function (value) { this._id = value; },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Pizza.prototype, "name", {
        get: function () { return this._name; },
        set: function (value) { this._name = value; },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Pizza.prototype, "size", {
        get: function () { return this._size; },
        set: function (value) { this._size = value; },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Pizza.prototype, "price", {
        get: function () { return this._price; },
        set: function (value) { this._price = value; },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Pizza.prototype, "image", {
        get: function () { return this._image; },
        set: function (value) { this._image = value; },
        enumerable: true,
        configurable: true
    });
    return Pizza;
}());
exports.Pizza = Pizza;
//# sourceMappingURL=pizza.model.js.map