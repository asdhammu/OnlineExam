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
var hero_service_1 = require('./Hero/hero-service');
var router_1 = require('@angular/router');
var forms_1 = require('@angular/forms');
var HeroesComponent = (function () {
    function HeroesComponent(heroService, router, formBuilder) {
        this.heroService = heroService;
        this.router = router;
        this.formBuilder = formBuilder;
        this.title = 'Code Compilation';
        this.textValue = "";
    }
    HeroesComponent.prototype.logText = function (value) {
        //this.code = value;
        this.compileCode(value);
    };
    HeroesComponent.prototype.getHeroes = function () {
        var _this = this;
        // this.heroService.getHereos().then(heroes => console.log(this.heroes));
        this.heroService.getHereos().then(function (heroes) { return _this.heroes = heroes; });
    };
    HeroesComponent.prototype.onSelect = function (hero) {
        this.selectedHero = hero;
    };
    HeroesComponent.prototype.ngOnInit = function () {
        this.getHeroes();
        this.compile = this.formBuilder.group({
            program: ['', forms_1.Validators.required]
        });
    };
    HeroesComponent.prototype.gotoDetail = function () {
        this.router.navigate(['/detail', this.selectedHero.id]);
    };
    HeroesComponent.prototype.compileCode = function (value) {
        var _this = this;
        //alert(this.compile.controls.program.value);
        this.heroService.postCode(value).then(function (result) { return _this.compileResult = result; });
    };
    HeroesComponent = __decorate([
        core_1.Component({
            selector: 'my-heroes',
            templateUrl: 'app/heroes.component.html',
            styleUrls: ['app/heroes.component.css'],
            providers: [hero_service_1.HeroService]
        }), 
        __metadata('design:paramtypes', [hero_service_1.HeroService, router_1.Router, forms_1.FormBuilder])
    ], HeroesComponent);
    return HeroesComponent;
}());
exports.HeroesComponent = HeroesComponent;
/*
Copyright 2016 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/ 
//# sourceMappingURL=heroes.component.js.map