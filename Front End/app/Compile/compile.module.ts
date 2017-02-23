import { NgModule }       from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms';
import { HttpModule, JsonpModule } from '@angular/http';
import { CompileFormComponent } from './components/compile-form.component';
import { CompileComponent } from './components/index';


import { CompileService } from './services/compile.service';


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
     HttpModule,
    JsonpModule,
    
  ],
  declarations: [
    CompileFormComponent,
    CompileComponent
  ],

  providers: [
      CompileService
  ],

  exports:[
    CompileComponent
  ]
  
})
export class CompileModule {
}

