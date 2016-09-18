import {PizzaListComponent} from "../components/pizzalist.component";
import {PizzaDetailComponent} from "../components/pizzadetail.component";

export const PizzaRoutes = [
    { path: 'pizzalist', component: PizzaListComponent},
    { path: 'pizzadetail/:id', component: PizzaDetailComponent}
];


