/* * * ./app/comments/components/comment-form.component.ts * * */
// Imports
import { Component, EventEmitter, Input, OnChanges } from '@angular/core';
import { NgForm }    from '@angular/forms';
import {Observable} from 'rxjs/Rx';

import { CommentBoxComponent } from './comment-box.component'
import { CommentService } from '../services/comment.service';
import { EmitterService } from '../../emitter.service';
import { Comment } from '../model/comment'
import {Compile} from '../model/compile';

// Component decorator
@Component({
    selector: 'comment-form',
    template: `
        <form (ngSubmit)="compileCode()">
            <div class="form-group">
               <!-- <div class="input-group">
                    <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-user"></span></span>
                    <input type="text" class="form-control" placeholder="Author" [(ngModel)]="model.author" name="author">
                </div>
                <br /> -->
                <textarea class="form-control" rows="10" placeholder="Text" [(ngModel)]="code" name="text"></textarea>
                <br />
                <button type="submit" class="btn btn-primary btn-block">Compile</button>
                <!--<button *ngIf="editing" type="submit" class="btn btn-warning btn-block">Update</button>-->
            </div>
        </form>

        <div *ngIf="compileResult" class="form-group">      
              Compilation Result : {{compileResult.compilationResult}}
              <br/>
              {{compileResult.errors}}
        </div>

    `,
    providers: [CommentService]
})
// Component class
export class CommentFormComponent implements OnChanges { 
    // Constructor with injected service
    constructor(
        private commentService: CommentService
        ){}
    // Local properties
   /* private model = new Comment(new Date(), '', '');
    private editing = false;*/
    private code = "";
    compileResult : Compile;
    // Input properties
    /* @Input() editId: string;
     @Input() listId: string;
     */

     compileCode():void{
         //alert(this.code);
         this.commentService.postCode(this.code).then(result => this.compileResult = result);
     }


    /*submitComment(){
        // Variable to hold a reference of addComment/updateComment
        let commentOperation:Observable<Comment[]>;

        if(!this.editing){
            // Create a new comment
            commentOperation = this.commentService.addComment(this.model)
        } else {
            // Update an existing comment
             commentOperation = this.commentService.updateComment(this.model)
        }

        // Subscribe to observable
        commentOperation.subscribe(
                                comments => {
                                    // Emit list event
                                    EmitterService.get(this.listId).emit(comments);
                                    // Empty model
                                    this.model = new Comment(new Date(), '', '');
                                    // Switch editing status
                                    if(this.editing) this.editing = !this.editing;
                                }, 
                                err => {
                                    // Log errors if any
                                    console.log(err);
                                });
    }

    ngOnChanges() {
        // Listen to the 'edit'emitted event so as populate the model
        // with the event payload
        EmitterService.get(this.editId).subscribe((comment:Comment) => {
            this.model = comment
            this.editing = true;
        });
    }*/
 }
