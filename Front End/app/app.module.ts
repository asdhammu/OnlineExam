import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpModule, JsonpModule} from '@angular/http';
import { AppComponent }  from './app.component';
import {HeroDetailComponent} from './Hero/hero-detail.component';
import {HeroService} from './Hero/hero-service';
import {HeroesComponent} from './heroes.component';
import {RouterModule} from '@angular/router';
import {DashboardComponent} from './Dashboard/dashboard.component';
import {AppRoutingModule} from './app-routing.module';
import {ReactiveFormsModule, FormsModule} from '@angular/forms';
import {Payload} from './Hero/payload-model';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    JsonpModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [
    AppComponent,
    HeroDetailComponent,
    HeroesComponent,
    DashboardComponent
  ],
  providers:[
  	HeroService,
    Payload
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }


/*
Copyright 2016 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/