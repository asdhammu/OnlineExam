import {Injectable, Component} from '@angular/core';
import {Compile} from './compile-model';
import {Hero} from './hero';
import {HEREOS} from './mock-hero';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import 'rxjs/add/operator/toPromise';
import {Observable} from 'rxjs/Observable';
import { Payload} from './payload-model';
/*
@Component({
	providers:[Payload]
})
*/
@Injectable()
export class HeroService{

	//payload:Payload; 
	private heroURL = 'http://localhost:8080/onlineexam/hero';
	private compileURL='http://localhost:8080/onlineexam/compile';
	constructor(
		private http: Http,
		private payload: Payload
		){}

	postCode(data: string): Promise<any>{
		let test_this = { "data": data};
		let headers = new Headers({ 'Content-Type': 'application/json'});
    	let options = new RequestOptions({ headers: headers });
    	this.payload.data = data;
		return this.http.post(this.compileURL, JSON.stringify(test_this), options).toPromise()
			.then(response=> response.json())
			.catch(this.handleError);
	}

	getHereos(): Promise<Hero[]>{	
		return this.http.get(this.heroURL).toPromise()
			.then(response => response.json() as Hero[])
			.catch(this.handleError);
	}

	getHero(id: number): Promise<Hero>{
		return this.getHereos().then(heroes => heroes.find(hero => hero.id === id));
	}

	private handleError(error:any): Promise<any>{

		console.error("error occured",error);
		return Promise.reject(error.message || error);
	}

	
}
