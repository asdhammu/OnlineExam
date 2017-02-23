import { NgModule }       from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms';
import { HttpModule, JsonpModule } from '@angular/http';

import { CompileModule } from './compile/compile.module';

import { AppComponent }         from './app.component';
//import { EmitterService }          from './emitter.service';


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    JsonpModule,
    CompileModule
    
  ],
  declarations: [
    AppComponent,
  ],
  
  bootstrap: [ AppComponent ]
})
export class AppModule {
}

