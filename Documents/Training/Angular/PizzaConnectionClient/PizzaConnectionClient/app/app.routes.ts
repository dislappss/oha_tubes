import {provideRouter, RouterConfig} from '@angular/router';
import {HomeRoutes} from './home/ts/routes/home.routes';
import {PizzaRoutes} from './pizza/ts/routes/pizza.routes';

export const ROUTER_CONFIG: RouterConfig = 
[
        ...HomeRoutes,
        ...PizzaRoutes
];

export const APP_ROUTER_PROVIDERS = 
[
    provideRouter(ROUTER_CONFIG)
];

