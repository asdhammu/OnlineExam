import { NgModule }       from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms';
import { HttpModule, JsonpModule } from '@angular/http';
import { CompileFormComponent } from './Components/compile-form.component';
import { CompileComponent } from './Components/index';


import { CompileService } from './Services/compile.service';


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

