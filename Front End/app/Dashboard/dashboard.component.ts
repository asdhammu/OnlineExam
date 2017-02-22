import {Component, OnInit}  from '@angular/core';
import { Hero} from '../Hero/hero';
import {HeroService} from '../Hero/hero-service';
@Component({
	moduleId: module.id,
	selector: 'my-dashboard',
	templateUrl: './dashboard.component.html'
})

export class DashboardComponent implements OnInit{

	heroes : Hero[] = [];

	constructor(private heroService: HeroService){}

	ngOnInit(): void{

		this.heroService.getHereos()
			.then(heroes => this.heroes = heroes.slice(1,5));
	}
}