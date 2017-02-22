import {Component} from '@angular/core';

@Component({
	selector: 'my-app',
	
	template:`
		<nav>
			<a routerLink ="/heroes" routerLinkActive="active">Heroes</a>
			<a routerLink = "/dashboard" routerLinkActive="active">Dashboard</a>
		</nav>
		<router-outlet></router-outlet>
	`
})

export class AppComponent{

	//title ="Tour of heroes";

}