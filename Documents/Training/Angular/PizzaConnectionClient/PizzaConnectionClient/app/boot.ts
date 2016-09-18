import {bootstrap} from '@angular/platform-browser-dynamic';
import {AppComponent} from './app.component';
import {LocationStrategy, HashLocationStrategy} from '@angular/common';
import {APP_ROUTER_PROVIDERS} from './app.routes';
import {Jsonp, JSONP_PROVIDERS} from '@angular/http';
import {HTTP_PROVIDERS} from '@angular/http'

bootstrap (AppComponent, 
[
    APP_ROUTER_PROVIDERS, Jsonp, JSONP_PROVIDERS, HTTP_PROVIDERS,
    { 
        provide: LocationStrategy,
        useClass: HashLocationStrategy
    }
]);

