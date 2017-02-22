"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var http_1 = require('@angular/http');
require('rxjs/add/operator/toPromise');
var payload_model_1 = require('./payload-model');
/*
@Component({
    providers:[Payload]
})
*/
var HeroService = (function () {
    function HeroService(http, payload) {
        this.http = http;
        this.payload = payload;
        //payload:Payload; 
        this.heroURL = 'http://localhost:8080/onlineexam/hero';
        this.compileURL = 'http://localhost:8080/onlineexam/compile';
    }
    HeroService.prototype.postCode = function (data) {
        var test_this = { "data": data };
        var headers = new http_1.Headers({ 'Content-Type': 'application/json' });
        var options = new http_1.RequestOptions({ headers: headers });
        this.payload.data = data;
        return this.http.post(this.compileURL, JSON.stringify(test_this), options).toPromise()
            .then(function (response) { return response.json(); })
            .catch(this.handleError);
    };
    HeroService.prototype.getHereos = function () {
        return this.http.get(this.heroURL).toPromise()
            .then(function (response) { return response.json(); })
            .catch(this.handleError);
    };
    HeroService.prototype.getHero = function (id) {
        return this.getHereos().then(function (heroes) { return heroes.find(function (hero) { return hero.id === id; }); });
    };
    HeroService.prototype.handleError = function (error) {
        console.error("error occured", error);
        return Promise.reject(error.message || error);
    };
    HeroService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Http, payload_model_1.Payload])
    ], HeroService);
    return HeroService;
}());
exports.HeroService = HeroService;
//# sourceMappingURL=hero-service.js.map