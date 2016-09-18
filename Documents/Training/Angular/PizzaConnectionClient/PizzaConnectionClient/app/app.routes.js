"use strict";
var router_1 = require('@angular/router');
var home_routes_1 = require('./home/ts/routes/home.routes');
var pizza_routes_1 = require('./pizza/ts/routes/pizza.routes');
exports.ROUTER_CONFIG = home_routes_1.HomeRoutes.concat(pizza_routes_1.PizzaRoutes);
exports.APP_ROUTER_PROVIDERS = [
    router_1.provideRouter(exports.ROUTER_CONFIG)
];
//# sourceMappingURL=app.routes.js.map