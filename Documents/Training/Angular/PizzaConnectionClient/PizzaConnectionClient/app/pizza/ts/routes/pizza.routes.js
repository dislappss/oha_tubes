"use strict";
var pizzalist_component_1 = require("../components/pizzalist.component");
var pizzadetail_component_1 = require("../components/pizzadetail.component");
exports.PizzaRoutes = [
    { path: 'pizzalist', component: pizzalist_component_1.PizzaListComponent },
    { path: 'pizzadetail/:id', component: pizzadetail_component_1.PizzaDetailComponent }
];
//# sourceMappingURL=pizza.routes.js.map