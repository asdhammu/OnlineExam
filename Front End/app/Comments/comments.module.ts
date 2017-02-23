import { NgModule }       from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { FormsModule }    from '@angular/forms';
import { HttpModule, JsonpModule } from '@angular/http';
import { CommentFormComponent } from './components/comment-form.component';
import { CommentComponent } from './components/index';


import { CommentService } from './services/comment.service';


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
     HttpModule,
    JsonpModule,
    
  ],
  declarations: [
    CommentFormComponent,
    CommentComponent
  ],

  providers: [
      CommentService
  ],

  exports:[
    CommentComponent
  ]
  
})
export class CommentModule {
}

