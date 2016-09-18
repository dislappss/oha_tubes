import {Component, OnInit} from '@angular/core';
import {Menubar, MenuItem} from 'primeng/primeng';
import {ROUTER_DIRECTIVES} from '@angular/router';

@Component ({
    selector: 'my-app',
    templateUrl: 'app/app.html',
    directives: [ROUTER_DIRECTIVES, Menubar],
    styleUrls: ['app/css/styles.css']
})

export class AppComponent implements OnInit {
    
    private items: MenuItem[];
    
    ngOnInit () 
    {
        this.items = 
        [
            {
                label: 'Home', icon: '', 
                routerLink: [''] 
            },
            {
                label: 'Speisekarte', icon: 'fa fa-cutlery', 
                routerLink: ['pizzalist'] 
            }
        ]
    }   
}


