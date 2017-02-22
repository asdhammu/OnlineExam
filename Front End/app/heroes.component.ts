import { Component, OnInit } from '@angular/core';
import {Hero} from './Hero/hero';
import {HeroService} from './Hero/hero-service';
import {Router} from '@angular/router';
import {FormGroup,FormBuilder, Validators} from '@angular/forms';
import {Compile} from './Hero/compile-model';

@Component({
  selector: 'my-heroes',
  templateUrl: 'app/heroes.component.html',
  styleUrls:['app/heroes.component.css'],
  providers:[HeroService]
})

export class HeroesComponent implements OnInit{
  title = 'Code Compilation';
  heroes:Hero[];
  selectedHero:Hero;
  private textValue= "";
  compile : FormGroup;
  //private code : string;

  compileResult: Compile[];
  constructor(
    private heroService: HeroService,
    private router: Router,
    public formBuilder: FormBuilder
  ){ }  


  logText(value:string):void{
      //this.code = value;
      this.compileCode(value);

  }

  getHeroes(): void{
   // this.heroService.getHereos().then(heroes => console.log(this.heroes));
    this.heroService.getHereos().then(heroes => this.heroes = heroes);
  }
  onSelect(hero:Hero):void{
    this.selectedHero=hero;
  }

  ngOnInit():void{
    this.getHeroes();
    this.compile = this.formBuilder.group({
        program:['', Validators.required]
    });

  }

  gotoDetail(): void{
     this.router.navigate(['/detail',this.selectedHero.id]);
  }

  compileCode(value:string):void{    
    //alert(this.compile.controls.program.value);
    this.heroService.postCode(value).then(result => this.compileResult= result);     
  }

}




/*
Copyright 2016 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/