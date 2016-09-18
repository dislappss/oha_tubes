"use strict";
var platform_browser_dynamic_1 = require('@angular/platform-browser-dynamic');
var app_component_1 = require('./app.component');
var common_1 = require('@angular/common');
var app_routes_1 = require('./app.routes');
var http_1 = require('@angular/http');
var http_2 = require('@angular/http');
platform_browser_dynamic_1.bootstrap(app_component_1.AppComponent, [
    app_routes_1.APP_ROUTER_PROVIDERS, http_1.Jsonp, http_1.JSONP_PROVIDERS, http_2.HTTP_PROVIDERS,
    {
        provide: common_1.LocationStrategy,
        useClass: common_1.HashLocationStrategy
    }
]);
//# sourceMappingURL=boot.js.map